package DepartsGui;

import DepartDialog.DepartDialogController;
import Entities.Departement;
import Impl.IMetierImplementation;
import MainGui.MainGuiController;
import com.sun.javafx.collections.ImmutableObservableList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;

public class DepartsGuiCotroller implements Initializable {

    private Stage parentStage;

    @FXML
    private Button returnBtn;

    @FXML
    public TextField searchTextfield;

    @FXML
    public Button addBtn;

    @FXML
    public Button editBtn;

    @FXML
    public Button deleteBtn;

    @FXML
    public TableView<Departement> tableView;

    private IMetierImplementation imp;

    private ObservableList<Departement> depListData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imp = new IMetierImplementation();
        for( Departement dep: imp.getDepartements()){
            tableView.getItems().add(dep);
        }
        depListData = FXCollections.observableList( tableView.getItems() );
    }

    public void deleteDepartement(){
        Departement dep = tableView.getSelectionModel().getSelectedItem();
        int itemIndex = tableView.getSelectionModel().getSelectedIndex();
        if( dep == null ){
            Alert NoSelectionAlert = new Alert( Alert.AlertType.WARNING);
            NoSelectionAlert.setResizable(false);
            NoSelectionAlert.setHeaderText(" Aucun déparement n'a été séléctionné dans la liste ");
            NoSelectionAlert.setTitle(" Aucun déparement n'a été séléctionné  ");
            NoSelectionAlert.show();
            return;
        }

        Alert confirmationAlert = new Alert( Alert.AlertType.CONFIRMATION );
        confirmationAlert.setTitle(" Confirmez la supprission  ");
        confirmationAlert.setHeaderText(" Etes-vous sure de supprimer le département '"+dep.getNom()+"' ?");
        confirmationAlert.setContentText(" Vous risquez de supprimer les professeurs liés à ce département, ( s'ils existent) .");
        confirmationAlert.setResizable(false);

        Optional<ButtonType> result = confirmationAlert.showAndWait();

        if( result.get()== ButtonType.OK ){
            imp.supprimerDepartement(dep);
            depListData.remove(dep);
            doSearch();
            Alert alerty = new Alert( Alert.AlertType.INFORMATION );
            alerty.setResizable(false);
            alerty.setHeaderText("Département Bien supprimé !");
            alerty.setTitle("Succès !");
            alerty.show();
        }
    }

    public void editDepartement(){
        Dialog<ButtonType> dialog = new Dialog<ButtonType>();
        dialog.setTitle("Modifier un département");
        dialog.setHeight(170.0);
        dialog.setWidth(350.0);
        dialog.setResizable(false);
        Departement dep = tableView.getSelectionModel().getSelectedItem();
        int itemIndex = tableView.getSelectionModel().getSelectedIndex();
        if( dep == null ){
            Alert NoSelectionAlert = new Alert( Alert.AlertType.WARNING);
            NoSelectionAlert.setResizable(false);
            NoSelectionAlert.setHeaderText(" Aucun déparement n'a été séléctionné dans la liste ");
            NoSelectionAlert.setTitle(" Aucun déparement n'a été séléctionné  ");
            NoSelectionAlert.show();
            return;
        }
        Departement copyDep = new Departement(dep);


        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/DepartDialog/departDialog.fxml"));
            DialogPane dp = fxmlLoader.load();
            dialog.setDialogPane( dp );
            DepartDialogController dialogPaneController = fxmlLoader.getController();
            dialogPaneController.setDepartement( copyDep );
            dialogPaneController.setEditButtons(); // show save button instead of create button
            Optional<ButtonType> bt = dialog.showAndWait();
            if( bt.get().getButtonData() == ButtonBar.ButtonData.OK_DONE ){
                Alert alerty = new Alert( Alert.AlertType.WARNING);
                alerty.setResizable(false);
                if( !copyDep.hasAllFields() ){
                    alerty.setHeaderText("Il faut saisir le champ : 'nom' !!");
                    alerty.setTitle("Champ vide");
                    alerty.show();
                }else{
                    imp.modifierDepartement(copyDep);
                    depListData.set( depListData.indexOf(copyDep), copyDep);
                    doSearch();
                    alerty.setAlertType( Alert.AlertType.INFORMATION );
                    alerty.setHeaderText("Département Bien modifié !");
                    alerty.setTitle("Succès !");
                    alerty.show();
                }
            }
        }catch( Exception exc ){
            Alert alert = new Alert( Alert.AlertType.ERROR );
            alert.setResizable(false);
            alert.setHeaderText("[DepartementGuiController::editDepartement]Exception> "+exc.getMessage());
            alert.setTitle("Exception");
            alert.setContentText( Arrays.toString( exc.getStackTrace() ) );
            alert.show();
        }
    }


    public void addDepartement(){
        Dialog<ButtonType> dialog = new Dialog<ButtonType>();
        dialog.setTitle("Ajouter un département");
        dialog.setHeight(170.0);
        dialog.setWidth(350.0);
        dialog.setResizable(false);
        Departement dep = new Departement();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/DepartDialog/departDialog.fxml"));
            DialogPane dp = fxmlLoader.load();
            dialog.setDialogPane( dp );
            DepartDialogController dialogPaneController = fxmlLoader.getController();
            dialogPaneController.setDepartement( dep );
            Optional<ButtonType> bt = dialog.showAndWait();
            if( bt.get().getButtonData() == ButtonBar.ButtonData.OK_DONE ){
                Alert alerty = new Alert( Alert.AlertType.WARNING);
                if( !dep.hasAllFields() ){
                    alerty.setResizable(false);
                    alerty.setHeaderText("Il faut saisir le champ : 'nom' !!");
                    alerty.setTitle("Champ vide");
                    alerty.show();
                }else{
                    imp.ajouterDepartement(dep);
                    depListData.add(dep);
                    doSearch();
                    alerty.setAlertType( Alert.AlertType.INFORMATION );
                    alerty.setHeaderText("Département Bien Ajouté !");
                    alerty.setTitle("Succès !");
                    alerty.show();
                }
            }
        }catch( Exception exc ){
            Alert alert = new Alert( Alert.AlertType.ERROR );
            alert.setResizable(false);
            alert.setHeaderText("[DepartementGuiController::addDepartement]Exception> "+exc.getMessage());
            alert.setTitle("Exception");
            alert.setContentText( Arrays.toString( exc.getStackTrace() ) );
            alert.show();
        }
    }


    public void doSearch(){
        String Keyword = searchTextfield.getText().trim();
        FilteredList<Departement> filteredData = new FilteredList<Departement>( depListData, departement -> {
            if (Keyword == null || Keyword.isEmpty()) {
                return true;
            }
            String lowerCaseFilter = Keyword.toLowerCase();
            if (departement.getNom().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            }
            return false; // Does not match.
        });
        SortedList<Departement> sortedData = new SortedList<Departement>(filteredData);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);
        if( sortedData.size()==0 && Keyword.length()>0 )
            tableView.setPlaceholder( new Label(" Aucun département n'a été trouvé pour la recherche : '"+ Keyword +"'") );
        else
            tableView.setPlaceholder( new Label(" Aucun département n'a été trouvé ") );
    }

    public void returnAction() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation( getClass().getResource("/MainGui/MainGui.fxml") );
        BorderPane borderPane = loader.load();
        MainGuiController controller = loader.getController();
        controller.setParentStage(parentStage);
        Scene scene = new Scene(borderPane, 800, 600);
        scene.getStylesheets().add( getClass().getResource("/MainGui/baseStyle.css").toString() );
        parentStage.setScene(scene);
    }


    public void setParentStage(Stage parentStage) {
        this.parentStage = parentStage;
    }
}

