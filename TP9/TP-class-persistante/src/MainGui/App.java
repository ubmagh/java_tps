package MainGui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MainGui.fxml"));
        BorderPane borderPane = loader.load();
        MainGuiController controller = loader.getController();
        controller.setParentStage(primaryStage);
        Scene scene = new Scene(borderPane, 1000, 600);
        scene.getStylesheets().add( getClass().getResource("baseStyle.css").toString() );
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Gestion des professeurs & des départements");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
