package MazeSolverProject;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MazeSolverApp extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("MAZE SOLVER");
        primaryStage.setMinHeight(480);
        primaryStage.setMinWidth(800);
        primaryStage.setMaxHeight(480);
        primaryStage.setMaxWidth(800);
        Image logo = new Image(MazeSolverApp.class.getResourceAsStream("MazeSolverLogo.png"));
        primaryStage.getIcons().add(logo);
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("App.fxml"))));
        primaryStage.show();
    }

}
