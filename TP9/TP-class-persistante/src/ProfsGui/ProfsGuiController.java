package ProfsGui;

import DepartDialog.DepartDialogController;
import Entities.Departement;
import Entities.Professeur;
import Impl.IMetierImplementation;
import MainGui.MainGuiController;
import ProfDialog.ProfDialogController;
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
import javafx.util.Callback;
import java.net.URL;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;


public class ProfsGuiController implements Initializable {

    private Stage parentStage;

    @FXML
    private Button returnBtn;

    @FXML
    private ComboBox<Departement> departementCombo;

    @FXML
    private TextField searchTextfield;

    @FXML
    private Button addBtn;

    @FXML
    private Button editBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private TableView<Professeur> tableView;
    private IMetierImplementation imp;
    private ObservableList<Professeur> listProfs;

    public ProfsGuiController(){
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //parentStage.setTitle("Gestion des professeurs");
        imp = new IMetierImplementation();

        departementCombo.getItems().add( new Departement( 0, "Tous les départements") );
        departementCombo.getItems().addAll(imp.getDepartements());

        Callback<ListView<Departement>, ListCell<Departement>> cellFactory = new Callback<ListView<Departement>, ListCell<Departement>>() {
            @Override
            public ListCell<Departement> call(ListView<Departement> l) {
                return new ListCell<Departement>() {
                    @Override
                    protected void updateItem(Departement item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setGraphic(null);
                        } else {
                            if(item.getId_depart()==0)
                                setText(" -->  " + item.getNom() + "  <-- ");
                            else
                                setText(item.getId_depart() + ":  " + item.getNom());
                        }
                    }
                } ;
            }
        };
        departementCombo.setButtonCell(cellFactory.call(null));
        departementCombo.setCellFactory(cellFactory);
        departementCombo.getSelectionModel().select(0);
        tableView.getItems().addAll(imp.getAllProfesseurs());
        listProfs = FXCollections.observableList(tableView.getItems());
    }

    public void changeDepartement(){
        Departement dep = departementCombo.getSelectionModel().getSelectedItem();
        listProfs.removeAll(listProfs);
        if( dep.getId_depart()==0 )
            listProfs.addAll(imp.getAllProfesseurs());
        else
            listProfs.addAll(imp.getProfesseursByDepartement(dep));
        this.tableView.setItems( FXCollections.observableList( listProfs) );
        doSearch();
    }

    public void addProf(){
        Dialog<ButtonType> dialog = new Dialog<ButtonType>();
        dialog.setTitle("Ajouter un professeur");
        dialog.setHeight(400.0);
        dialog.setWidth(400.0);
        dialog.setResizable(false);
        Professeur prof = new Professeur();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/ProfDialog/profDialog.fxml"));
            DialogPane dp = fxmlLoader.load();
            dialog.setDialogPane( dp );
            ProfDialogController dialogPaneController = fxmlLoader.getController();
            dialogPaneController.setProf( prof );
            dialogPaneController.setDepartements(departementCombo.getItems());
            Optional<ButtonType> bt = dialog.showAndWait();
            if( bt.get().getButtonData() == ButtonBar.ButtonData.OK_DONE ){
                Alert alerty = new Alert( Alert.AlertType.WARNING);
                if( !prof.hasAllFields() ){
                    alerty.setResizable(false);
                    alerty.setHeaderText("Il faut saisir tous les champs !!");
                    alerty.setTitle("Champs vides");
                    alerty.show();
                }else{
                    imp.ajouterProfesseur(prof);
                    listProfs.add(prof);
                    doSearch();
                    alerty.setAlertType( Alert.AlertType.INFORMATION );
                    alerty.setHeaderText("Professeur Bien Ajouté !");
                    alerty.setTitle("Succès !");
                    alerty.show();
                }
            }
        }catch( Exception exc ){
            Alert alert = new Alert( Alert.AlertType.ERROR );
            alert.setHeaderText("[ProfsGuiController::addProf]Exception> "+exc.getMessage());
            alert.setTitle("Exception");
            alert.setContentText( Arrays.toString( exc.getStackTrace() ) );
            alert.show();
        }
    }

    public void editProf(){
        Dialog<ButtonType> dialog = new Dialog<ButtonType>();
        dialog.setTitle("Modifier un Professeur");
        dialog.setHeight(400.0);
        dialog.setWidth(400.0);
        dialog.setResizable(false);
        Professeur prof = tableView.getSelectionModel().getSelectedItem();
        int itemIndex = tableView.getSelectionModel().getSelectedIndex();
        if( prof == null ){
            Alert NoSelectionAlert = new Alert( Alert.AlertType.WARNING);
            NoSelectionAlert.setResizable(false);
            NoSelectionAlert.setHeaderText(" Aucun professeur n'a été séléctionné dans la liste ");
            NoSelectionAlert.setTitle(" Aucun professeur n'a été séléctionné  ");
            NoSelectionAlert.show();
            return;
        }
        Professeur copyProf = new Professeur(prof);


        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/ProfDialog/profDialog.fxml"));
            DialogPane dp = fxmlLoader.load();
            dialog.setDialogPane( dp );
            ProfDialogController dialogPaneController = fxmlLoader.getController();
            dialogPaneController.setDepartements(departementCombo.getItems());
            dialogPaneController.setProf( copyProf );
            dialogPaneController.setEditButtons(); // show save button instead of create button
            Optional<ButtonType> bt = dialog.showAndWait();
            if( bt.get().getButtonData() == ButtonBar.ButtonData.OK_DONE ){
                Alert alerty = new Alert( Alert.AlertType.WARNING);
                alerty.setResizable(false);
                if( !copyProf.hasAllFields() ){
                    alerty.setHeaderText("Il faut saisir tous les champs!!");
                    alerty.setTitle("Champs vides");
                    alerty.show();
                }else{
                    imp.modifierProfesseur(copyProf);
                    listProfs.set( listProfs.indexOf(copyProf), copyProf);
                    alerty.setAlertType( Alert.AlertType.INFORMATION );
                    alerty.setHeaderText("Professeur Bien modifié !");
                    alerty.setTitle("Succès !");
                    alerty.show();
                    doSearch();
                }
            }
        }catch( Exception exc ){
            //System.err.print(exc);
            exc.printStackTrace();
            Alert alert = new Alert( Alert.AlertType.ERROR );
            alert.setResizable(false);
            alert.setHeaderText("[ProfsGuiController::editProf]Exception> "+exc.getMessage());
            alert.setTitle("Exception");
            alert.setContentText( Arrays.toString( exc.getStackTrace() ) );
            alert.show();
        }
    }

    public void deleteProf(){
        Professeur professeur = tableView.getSelectionModel().getSelectedItem();
        int itemIndex = tableView.getSelectionModel().getSelectedIndex();
        if( professeur == null ){
            Alert NoSelectionAlert = new Alert( Alert.AlertType.WARNING);
            NoSelectionAlert.setResizable(false);
            NoSelectionAlert.setHeaderText(" Aucun professeur n'a été séléctionné dans la liste ");
            NoSelectionAlert.setTitle(" Aucun professeur n'a été séléctionné  ");
            NoSelectionAlert.show();
            return;
        }

        Alert confirmationAlert = new Alert( Alert.AlertType.CONFIRMATION );
        confirmationAlert.setTitle(" Confirmez la supprission  ");
        confirmationAlert.setHeaderText(" Etes-vous sure de supprimer le professeur '"+professeur.getNom()+" "+professeur.getPrenom()+"' ?");
        confirmationAlert.setResizable(false);

        Optional<ButtonType> result = confirmationAlert.showAndWait();

        if( result.get()== ButtonType.OK ){
            imp.supprimerProfesseur(professeur);
            listProfs.remove(professeur);
            doSearch();
            Alert alerty = new Alert( Alert.AlertType.INFORMATION );
            alerty.setResizable(false);
            alerty.setHeaderText("Professeur Bien supprimé !");
            alerty.setTitle("Succès !");
            alerty.show();
        }
    }

    public void doSearch(){
        String Keyword = searchTextfield.getText().trim();
        FilteredList<Professeur> filteredData = new FilteredList<Professeur>( listProfs, prof -> {
            if (Keyword == null || Keyword.isEmpty()) {
                return true;
            }
            String lowerCaseFilter = Keyword.toLowerCase();
            if (prof.getNom().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            } else if (prof.getPrenom().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            } else if (prof.getCin().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            } else if (prof.getAdresse().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            } else if (prof.getTelephone().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            } else if (prof.getEmail().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            } else if (prof.getDate_recrutement().toLocalDate().toString().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            }
            return false; // Does not match.
        });
        SortedList<Professeur> sortedData = new SortedList<Professeur>(filteredData);
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);
        if( sortedData.size()==0 && Keyword.length()>0 )
            tableView.setPlaceholder( new Label(" Aucun professeur n'a été trouvé pour la recherche : '"+ Keyword +"'") );
        else
            tableView.setPlaceholder( new Label(" Aucun professeur n'a été trouvé") );
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

