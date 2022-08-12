package MainGui;

import Entities.Personne;
import Static.MyConnection;
import Static.MyGlobalConfiguration;
import addGui.DialogPaneController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.swing.plaf.nimbus.State;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class MainGuiController implements Initializable {

    // FXML attributes
    @FXML
    private TextField searchTF;
    @FXML
    private TableView<Personne> tableView;

    private ObservableList<Personne> mainData;

    // other attributes
    private Connection connection;
    String tableName; //  <========================

    public MainGuiController(){
        tableName = MyGlobalConfiguration.tableName;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        connection = MyConnection.getConex();
        try {
            Statement fillUsersStmt = connection.createStatement() ;
            ResultSet rs = fillUsersStmt.executeQuery("SELECT * FROM " + tableName + " ");
            while( rs.next() ){
                Personne prs = new Personne(
                        rs.getInt("id"),
                        rs.getString( "nom"),
                        rs.getString( "prenom"),
                        rs.getString( "adresse"),
                        rs.getString( "email"),
                        rs.getString( "tel"),
                        rs.getString( "fonction")
                        );
                tableView.getItems().add( prs );
            }
            fillUsersStmt.close();
            mainData = FXCollections.observableArrayList(tableView.getItems());

        }catch( Exception exc){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur dans l'accès à la Base de données !");
            alert.setHeaderText( "[MainGuiController::Class]Exception> "+ exc.getMessage() );
            alert.setContentText( Arrays.toString( exc.getStackTrace() ) );
            alert.setResizable(false);
            alert.show();
        }

    }

    public void Search(){
        String Keyword = searchTF.getText().trim();
        FilteredList<Personne> filteredData = new FilteredList<Personne>( mainData, p -> true);
        filteredData.setPredicate(user -> {
            // If filter text is empty, display all users
            if (Keyword == null || Keyword.isEmpty()) {
                return true;
            }
            // written search word to lowerCase
            String lowerCaseFilter = Keyword.toLowerCase();
            // Compare first 'nom', 'prenom', 'login' and 'adresse' of every user with filter text.
            if (user.getNom().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches "nom".
            } else if (user.getPrenom().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches "prenom"".
            } else if (user.getEmail().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches "email".
            } else if (user.getAdresse().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches "adresse".
            } else if (user.getFonction().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches "fonction".
            } else if (user.getTel().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches "tel".
            }
            return false; // Does not match.
        });
        SortedList<Personne> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);
    }


    public void addPerson(){
        Dialog<ButtonType> dialog = new Dialog<ButtonType>();
        dialog.setTitle("Ajouter une personne");
        dialog.setHeight(600.0);
        dialog.setWidth(500.0);
        dialog.setResizable(false);

        Personne personne = new Personne();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../addGui/dialogPane.fxml"));
            DialogPane dp = fxmlLoader.load();
            dialog.setDialogPane( dp );
            DialogPaneController dialogPaneController = fxmlLoader.getController();
            dialogPaneController.setPersonne( personne );

            Optional<ButtonType> bt = dialog.showAndWait();


            if( bt.get().getButtonData() == ButtonBar.ButtonData.OK_DONE ){
                Alert alerty = new Alert( Alert.AlertType.WARNING);
                if( !personne.hasAllFields() ){
                    alerty.setResizable(false);
                    alerty.setHeaderText("Il faut saisir tous les champs !!");
                    alerty.setTitle("Champs vides");
                    alerty.show();
                }else{
                    Statement insertStatement = connection.createStatement();
                    insertStatement.executeUpdate("INSERT INTO "+tableName+"(nom, prenom, adresse, email, tel, fonction) " +
                            "VALUES ( '" +
                            personne.getNom() +
                            "', '" +
                            personne.getPrenom()+
                            "', '" +
                            personne.getAdresse() +
                            "', '" +
                            personne.getEmail() +
                            "', '" +
                            personne.getTel() +
                            "', '" +
                            personne.getFonction() +
                            "')");
                    Statement getIdStatement = connection.createStatement();
                    ResultSet rs = getIdStatement.executeQuery(" SELECT MAX(id) as lastid FROM "+tableName+" ");
                    if( rs.next() ){
                        personne.setId( rs.getInt("lastid") );
                    }
                    mainData.add(personne);
                    Search();
                    alerty.setAlertType( Alert.AlertType.INFORMATION );
                    alerty.setHeaderText("Personne Bien Ajoutéé !");
                    alerty.setTitle("Succès !");
                    alerty.show();
                }
            }

        }catch( Exception exc ){
            Alert alert = new Alert( Alert.AlertType.ERROR );
            alert.setResizable(false);
            alert.setHeaderText("[MainGuiController::addPerson]Exception> "+exc.getMessage());
            alert.setTitle("Exception");
            alert.setContentText( Arrays.toString( exc.getStackTrace() ) );
            alert.show();
        }
    }


    public void deletePerson(){

        Personne selectedP = tableView.getSelectionModel().getSelectedItem();
        int selectedIndexx = tableView.getSelectionModel().getSelectedIndex();
        try {
            if (selectedIndexx >= 0) {

                Statement deleteStatement = connection.createStatement();
                deleteStatement.executeUpdate("DELETE FROM "+tableName+" WHERE id="+selectedP.getId() );
                mainData.remove(selectedIndexx);
                tableView.getSelectionModel().clearSelection();
                Search();

                Alert alerty = new Alert( Alert.AlertType.INFORMATION );
                alerty.setAlertType( Alert.AlertType.INFORMATION );
                alerty.setHeaderText("Personne supprimée !");
                alerty.setTitle("Succès !");
                alerty.show();

            }
        }catch( Exception exc){
            Alert alert = new Alert( Alert.AlertType.ERROR );
            alert.setResizable(false);
            alert.setHeaderText("[MainGuiController::deletePerson]Exception> "+exc.getMessage());
            alert.setTitle("Exception");
            alert.setContentText( Arrays.toString( exc.getStackTrace() ) );
            alert.show();
        }

    }


}
