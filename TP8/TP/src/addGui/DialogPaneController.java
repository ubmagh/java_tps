package addGui;

import Entities.Personne;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class DialogPaneController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField tel;
    @FXML
    private TextField fonction;
    @FXML
    private TextArea adresse;

    @FXML
    private DialogPane dialogPane;


    private Personne personne;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ButtonType ok = new ButtonType("Ajouter", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancel = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialogPane.getButtonTypes().add(ok);
        dialogPane.getButtonTypes().add(cancel);
    }

    public void setPersonne( Personne p ){
        personne = p;
        nom.textProperty().bindBidirectional( p.nomProperty() );
        prenom.textProperty().bindBidirectional( p.prenomProperty() );
        email.textProperty().bindBidirectional( p.emailProperty() );
        tel.textProperty().bindBidirectional( p.telProperty() );
        fonction.textProperty().bindBidirectional( p.fonctionProperty() );
        adresse.textProperty().bindBidirectional( p.adresseProperty() );
    }





}

