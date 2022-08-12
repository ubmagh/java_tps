package Gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import Entities.User;
import java.net.URL;
import java.util.ResourceBundle;

public class GuiController /* implements Initializable */ {
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField login;
    @FXML
    private TextField chercher;
    @FXML
    private TextArea adresse;
    @FXML
    private PasswordField password;
    @FXML
    private TableView<User> tableView;

    @FXML
    private TableColumn<User, String> COLNOM;
    @FXML
    private TableColumn<User, String> COLPRENOM;
    @FXML
    private TableColumn<User, String> COLLOGIN;
    @FXML
    private TableColumn<User, String> COLPASSWORD;

    private Number edittedIndex=-1;

    private ObservableList<User> mainData;


    public GuiController() {
    }


    @FXML
    private void initialize() {
        tableView.getSelectionModel().selectedIndexProperty().addListener( (obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                edittedIndex = newSelection;
                loadUser();
            }else{
                tableView.getSelectionModel().clearSelection();
                clearFields();
            }
        });
        tableView.getItems().add( new User("Maghdaoui", "Ayoub", "ubmagh", "123321", "SWHERe") );
        tableView.getItems().add( new User("BACHA", "Ahmed", "uhac", "159951", "HERE") );
        mainData = FXCollections.observableArrayList( tableView.getItems() );
    }

    /* // when implementing initializable interface
    @Override
    public void initialize(URL location, ResourceBundle rb) {
        tableView.getSelectionModel().selectedIndexProperty().addListener( (obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                edittedIndex = newSelection;
                loadUser();
            }else{
                tableView.getSelectionModel().clearSelection();
                clearFields();
            }
        });
    }
    */

    public void getInfos(){
        Alert alert = new Alert( Alert.AlertType.INFORMATION );
        alert.setTitle("Ayoub Maghdaoui");
        Hyperlink hl = new Hyperlink();
        alert.setHeaderText("Créé par Ayoub Maghdaoui : https://github.com/ubmagh");
        alert.show();
    }

    public void searchUser(){

        String newValue = chercher.getText().trim();
        FilteredList<User> filteredData = new FilteredList<User>( mainData, p -> true);
        nom.setText("");
        prenom.setText("");
        login.setText("");
        adresse.setText("");
        password.setText("");
        tableView.getSelectionModel().clearSelection();
        edittedIndex = -1;

        filteredData.setPredicate(user -> {
            // If filter text is empty, display all users
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            // written search word to lowerCase
            String lowerCaseFilter = newValue.toLowerCase();
            // Compare first 'nom', 'prenom', 'login' and 'adresse' of every user with filter text.
            if (user.getNom().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches "nom".
            } else if (user.getPrenom().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches "prenom"".
            } else if (user.getLogin().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches "login".
            } else if (user.getAdresse().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches "adresse".
            }
            return false; // Does not match.
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<User> sortedData = new SortedList<>(filteredData);
        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        // 5. Add sorted (and filtered) data to the table.
        tableView.setItems(sortedData);
    }



    public void updateUser(){
        Alert alert=new Alert(Alert.AlertType.WARNING);

        if( edittedIndex.intValue()>=0 ){
            String nomS = nom.getText();
            String prenomS = prenom.getText();
            String passwordS = password.getText();
            String adresseS = adresse.getText();
            String loginS = login.getText();

            User user = new User( nomS, prenomS, loginS, passwordS, adresseS);

            int mainEditted = mainData.indexOf(tableView.getItems().get(edittedIndex.intValue()));

            tableView.getItems().set( edittedIndex.intValue(), user);
            mainData.set( mainEditted, user);

            alert.setAlertType( Alert.AlertType.INFORMATION );
            alert.setTitle("Modification effectuée");
            alert.setHeaderText(" Utilisateur modifié");
            alert.setContentText("");
            alert.show();
            loadUser();

        }else{
            alert.setTitle("Modification impossible !");
            alert.setHeaderText(" utilisateur avec indice introuvables ! ");
            alert.setContentText("Veuillez sélectionner un élément dans la table ");
            alert.show();
        }
    }


    public void deleteUser(){
        int indice= tableView.getSelectionModel().getSelectedIndex();
        if(indice>=0) {
            User user = tableView.getItems().get(indice);
            mainData.remove(user);
            tableView.getItems().remove(indice);
            clearFields();
        }else{
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Supprission impossible !");
            alert.setHeaderText(" utilisateur avec indice introuvables ! ");
            alert.setContentText("Veuillez sélectionner un élément dans la table ");
            alert.show();
        }

    }


    public void addUser(){
        String nomS = nom.getText();
        String prenomS = prenom.getText();
        String passwordS = password.getText();
        String adresseS = adresse.getText();
        String loginS = login.getText();
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(" Erreur de validation ");
        alert.setResizable(false);
        if( nomS.length()==0 ){
            alert.setHeaderText("champ du Nom est vide");
            alert.setContentText("Veuillez saisir le nom");
            alert.show();
            return;
        }

        if( prenomS.length()==0 ){
            alert.setHeaderText("champ du Prenom est vide");
            alert.setContentText("Veuillez saisir le prénom");
            alert.show();
            return;
        }

        if( loginS.length()==0  ){
            alert.setHeaderText("champ de Login est vide");
            alert.setContentText("Veuillez saisir le login");
            alert.show();
            return;
        }

        if( adresseS.length()==0  ){
            alert.setHeaderText("champ d'adresse est vide");
            alert.setContentText("Veuillez saisir l'adresse ");
            alert.show();
            return;
        }
        if( passwordS.length()==0 ){
            alert.setHeaderText("champ du mot de passe est vide");
            alert.setContentText("Veuillez saisir le mot de passe");
            alert.show();
            return;
        }
        User user = new User(nomS, prenomS, loginS, passwordS, adresseS);
        tableView.getItems().add(user);
        mainData.add(user);
        clearFields();
    }


    public void loadUser(){
        if( edittedIndex.intValue() ==-1 )
            return;
        try {
            User user = tableView.getItems().get(edittedIndex.intValue());
            nom.setText(user.getNom());
            prenom.setText( user.getPrenom() );
            adresse.setText( user.getAdresse() );
            password.setText( user.getPassword() );
            login.setText( user.getLogin() );
        }catch( IndexOutOfBoundsException ex){
            Alert alert = new Alert( Alert.AlertType.ERROR );
            alert.setTitle("Exception: loadUser");
            alert.setContentText("index introuvable !!");

        }
    }

    public void clearFields (){
        nom.setText("");
        prenom.setText("");
        login.setText("");
        adresse.setText("");
        password.setText("");
        chercher.setText("");
        tableView.setItems( FXCollections.observableArrayList( mainData )  );
        tableView.getSelectionModel().clearSelection();
        edittedIndex = -1;

    }


    public TextField getChercher() {
        return chercher;
    }

    public void setChercher(TextField chercher) {
        this.chercher = chercher;
    }

    public TableColumn<User, String> getCOLNOM() {
        return COLNOM;
    }

    public void setCOLNOM(TableColumn<User, String> COLNOM) {
        this.COLNOM = COLNOM;
    }

    public TableColumn<User, String> getCOLPRENOM() {
        return COLPRENOM;
    }

    public void setCOLPRENOM(TableColumn<User, String> COLPRENOM) {
        this.COLPRENOM = COLPRENOM;
    }

    public TableColumn<User, String> getCOLLOGIN() {
        return COLLOGIN;
    }

    public void setCOLLOGIN(TableColumn<User, String> COLLOGIN) {
        this.COLLOGIN = COLLOGIN;
    }

    public TableColumn<User, String> getCOLPASSWORD() {
        return COLPASSWORD;
    }

    public void setCOLPASSWORD(TableColumn<User, String> COLPASSWORD) {
        this.COLPASSWORD = COLPASSWORD;
    }

    public Number getEdittedIndex() {
        return edittedIndex;
    }

    public void setEdittedIndex(Number edittedIndex) {
        this.edittedIndex = edittedIndex;
    }

    public TextField getNom() {
        return nom;
    }

    public void setNom(TextField nom) {
        this.nom = nom;
    }

    public TextField getPrenom() {
        return prenom;
    }

    public void setPrenom(TextField prenom) {
        this.prenom = prenom;
    }

    public TextField getLogin() {
        return login;
    }

    public void setLogin(TextField login) {
        this.login = login;
    }

    public TextArea getAdresse() {
        return adresse;
    }

    public void setAdresse(TextArea adresse) {
        this.adresse = adresse;
    }

    public PasswordField getPassword() {
        return password;
    }

    public void setPassword(PasswordField password) {
        this.password = password;
    }

    public TableView<User> getTableView() {
        return tableView;
    }

    public void setTableView(TableView<User> tableView) {
        this.tableView = tableView;
    }
}
