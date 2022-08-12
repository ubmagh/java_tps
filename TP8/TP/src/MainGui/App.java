package MainGui;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane borderPane = FXMLLoader.load( getClass().getResource("MainGui.fxml") );
        Scene scene = new Scene(borderPane, 800, 600);
        scene.getStylesheets().add( getClass().getResource("baseStyle.css").toString() );
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Gestion des personnes");
        primaryStage.show();

    }
}

