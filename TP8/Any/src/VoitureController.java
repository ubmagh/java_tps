

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import metier.Voiture;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

public class VoitureController implements Initializable {
    @FXML
    private TextField fieldMat;
    @FXML
    private TextField fieldMarque;
    @FXML
    private TextField fieldPrix;
    @FXML
    private ListView listeView;

    private Connection conx;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            // create connection
            Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatps", "root", "");

        }catch(Exception e){
            Alert alert =  new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Connction à La BD");
            alert.setHeaderText( e.getMessage() );
            alert.setContentText( e.getStackTrace().toString() );
            alert.show();
        }
    }

    public  void ajouterVoiture(){
        String mat=fieldMat.getText();
        String marque=fieldMarque.getText();
        double prix= Double.valueOf( fieldPrix.getText() );
        listeView.getItems().add(new Voiture(mat,marque, prix));
        try {
            Statement stmt = conx.createStatement();
            stmt.executeUpdate(" INSERT INTO voiture( matricule, marque, prix) VALUES ( '"+mat+"', '"+marque+"', "+prix+")" );

        }catch( Exception exc ){
            Alert alert =  new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Insertion à la BD");
            alert.setHeaderText( exc.getMessage() );
            alert.setContentText( exc.getStackTrace().toString() );
            alert.show();
        }
    }


    public void supprimerVoiture(){
        int indice=listeView.getSelectionModel().getSelectedIndex();
        if(indice>=0) {
            listeView.getItems().remove(indice);
        }else{
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez sélectionner un élément ");
            alert.show();
        }
    }

    public TextField getFieldMat() {
        return fieldMat;
    }

    public void setFieldMat(TextField fieldMat) {
        this.fieldMat = fieldMat;
    }

    public TextField getFieldMarque() {
        return fieldMarque;
    }

    public void setFieldMarque(TextField fieldMarque) {
        this.fieldMarque = fieldMarque;
    }

    public ListView getListeView() {
        return listeView;
    }

    public void setListeView(ListView listeView) {
        this.listeView = listeView;
    }
}
