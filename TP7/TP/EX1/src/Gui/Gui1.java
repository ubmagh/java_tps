package Gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Gui1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane gridPane = FXMLLoader.load( getClass().getResource("MainVue.fxml") );
        Scene scene = new Scene(gridPane, 800, 600);
        scene.getStylesheets().add( getClass().getResource("style.css").toString() );
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Gestion des utilisateurs ");
        primaryStage.show();

    }
}
