package MainGui;

import DepartsGui.DepartsGuiCotroller;
import Impl.SignletonConnexionDB;
import ProfsGui.ProfsGuiController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class MainGuiController implements Initializable  {


    @FXML
    private Button Btn1;

    @FXML
    private Button Btn2;

    @FXML
    private Button Btn3;

    @FXML
    private VBox vbox;

    private Stage parentStage;

    public MainGuiController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // verifying DataBase connection
        Connection connection = SignletonConnexionDB.getConnection();
        if( connection==null){
            Label label = new Label(" Erreur de connexion à la base de données : Vérifiez les nom de la base de données et des tables.");
            Btn1.setDisable(true);
            Btn2.setDisable(true);
            label.getStyleClass().add("errorMessage");
            label.setPadding( new Insets( 25,0,0,0));
            vbox.getChildren().add(label);
        }

    }


    public void profsScene() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation( getClass().getResource("/ProfsGui/profsGui.fxml") );
        BorderPane borderPane = loader.load();
        ProfsGuiController controller = loader.getController();
        controller.setParentStage(parentStage);
        Scene scene = new Scene(borderPane, 1000, 600);
        scene.getStylesheets().add( getClass().getResource("/ProfsGui/style.css").toString() );
        parentStage.setScene(scene);
    }


    public void departsScene() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation( getClass().getResource("/DepartsGui/departsGui.fxml") );
        BorderPane borderPane = loader.load();
        DepartsGuiCotroller controller = loader.getController();
        controller.setParentStage(parentStage);
        Scene scene = new Scene(borderPane, 1000, 600);
        scene.getStylesheets().add( getClass().getResource("/DepartsGui/style.css").toString() );
        parentStage.setScene(scene);
    }

    public void setParentStage(Stage parentStage) {
        this.parentStage = parentStage;
    }

    public void Quit(){
        this.parentStage.close();
    }
}
