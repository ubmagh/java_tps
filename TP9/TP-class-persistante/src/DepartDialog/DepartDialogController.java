package DepartDialog;

import Entities.Departement;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class DepartDialogController implements Initializable {

    @FXML
    public DialogPane dialogPane;

    @FXML
    public TextField nomField;

    private Departement departement;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ButtonType ok = new ButtonType("Ajouter", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancel = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialogPane.getButtonTypes().add(ok);
        dialogPane.getButtonTypes().add(cancel);
    }

    public void setEditButtons(){
        dialogPane.getButtonTypes().clear();
        ButtonType ok = new ButtonType("Enregistrer", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancel = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialogPane.getButtonTypes().add(ok);
        dialogPane.getButtonTypes().add(cancel);
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
        nomField.textProperty().bindBidirectional( departement.nomProperty() );
    }
}
