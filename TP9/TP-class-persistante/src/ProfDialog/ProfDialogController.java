package ProfDialog;

import Entities.Departement;
import Entities.Professeur;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProfDialogController implements Initializable {

    @FXML
    private DialogPane dialogPane;

    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField telField;

    @FXML
    private TextField emailField;

    @FXML
    private TextArea adresseField;

    @FXML
    private TextField cinField;

    @FXML
    private DatePicker daterecField;

    @FXML
    private ComboBox<Departement> departementComboBox;

    private Professeur prof;
    private List<Departement> departements;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ButtonType ok = new ButtonType("Ajouter", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancel = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialogPane.getButtonTypes().add(ok);
        dialogPane.getButtonTypes().add(cancel);
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
                            setText(item.getId_depart() + ":  " + item.getNom());
                        }
                    }
                } ;
            }
        };
        departementComboBox.setButtonCell(cellFactory.call(null));
        departementComboBox.setCellFactory(cellFactory);
    }

    public void setEditButtons() {
        dialogPane.getButtonTypes().clear();
        ButtonType ok = new ButtonType("Enregistrer", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancel = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialogPane.getButtonTypes().add(ok);
        dialogPane.getButtonTypes().add(cancel);
    }

    public void onDaterecrChange() {
        prof.setDate_recrutement( new Date( daterecField.getValue().getYear() -1900, daterecField.getValue().getMonthValue()-1, daterecField.getValue().getDayOfMonth() ) );
    }

    public void onDepartementChange() {
        prof.setDepartement( departementComboBox.getSelectionModel().getSelectedItem() );
    }

    public void setDepartements(List<Departement> departements) {
        List<Departement> departementsCopy_1 = new ArrayList<Departement>(departements);
        departementsCopy_1.remove(0); // remove "Tous les Départements" Object
        this.departements = departementsCopy_1;
        departementComboBox.getItems().addAll(this.departements);
    }

    public void setProf(Professeur professeur) {
        prof = professeur;
        nomField.textProperty().bindBidirectional( prof.nomProperty() );
        prenomField.textProperty().bindBidirectional( prof.prenomProperty() );
        cinField.textProperty().bindBidirectional( prof.cinProperty() );
        adresseField.textProperty().bindBidirectional( prof.adresseProperty() );
        emailField.textProperty().bindBidirectional( prof.emailProperty() );
        telField.textProperty().bindBidirectional( prof.telephoneProperty() );
        // daterecField.converterProperty().bindBidirectional( prof.date_recrutementProperty() );
        if( professeur.getDepartement()!=null )
            departementComboBox.getSelectionModel().select( departementComboBox.getItems().indexOf(professeur.getDepartement()) );
        if( professeur.getDate_recrutement()!=null )
            daterecField.setValue( professeur.getDate_recrutement().toLocalDate() );
    }

}


