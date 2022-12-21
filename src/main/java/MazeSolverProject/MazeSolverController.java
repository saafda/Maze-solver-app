package MazeSolverProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MazeSolverController {

    private MazeSolver mazeSolver;
    private int[][] maze;
    private Solver solver;
    private Player player;
    private int score = 1;

    @FXML
    private Button playAgainButton;

    @FXML
    private AnchorPane ap;

    @FXML
    private ImageView imageView;

    @FXML
    private GridPane gridpane;

    @FXML
    private void initPlayer() {
        player = new Player();
        player.setValues(mazeSolver, score);
    }

    @FXML
    private void initMazeSolver() {
        mazeSolver = new MazeSolver();      
    }

    @FXML
    private void initGenerator() {
        this.maze = mazeSolver.generateMaze();
    }

    @FXML
    private void initSolver() {
        solver = new Solver();
    }

    @FXML
    public void initialize() {
        handleButtonClickGenerateMaze();        
    }


    @FXML
    private void handleButtonClickGenerateMaze() {
        initMazeSolver();
        initGenerator();
        initPlayer();
        this.score = 1;
        player.setScore(score);
        List<Node> childList = gridpane.getChildren();

        // Pre initialize
        for (Node child : childList) {
            child.setStyle("-fx-background-color: #FFFFFF");
        }
        displayScreen(childList);
    }

    @FXML
    private void handleButtonClickSolveMaze() {
        initSolver();
        solver.setValues(mazeSolver);
        solver.solve();

        List<Node> childList = gridpane.getChildren();
        for (int[] pair : solver.getSolved()) childList.get((pair[0]*21) + pair[1]).setStyle("-fx-background-color: #FFC0CB");
    }
    
    @FXML
    private void fileChooserButton() throws FileNotFoundException {
        FileHandler uploader = new FileHandler();

        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(ap.getScene().getWindow());

        if (file != null) { // When clicking cancel istead of selecting a file, then file = null

            uploader.uploadFromFile(file);

            List<Node> childList = gridpane.getChildren();
    
            for (Node child : childList) {
                child.setStyle("-fx-background-color: #FFFFFF");
            }

            score = uploader.getScore();
            mazeSolver.setValues(uploader);
            player.setValues(uploader, score);
            this.maze = uploader.getMazeFromFile();
            displayScreen(childList);
        }

    }
    

    @FXML
    private void fileSaverButton() throws IOException {
        FileHandler saver = new FileHandler();
        saver.saveToFIle(this.maze, player);
    }



    @FXML
    private void onPopUpClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PopUp.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.setMaxHeight(400);
            stage.setMaxWidth(500);
            stage.setMinHeight(400);
            stage.setMinWidth(500);
            stage.show();

        } catch (Exception e) {
           System.out.println("cant load window");
        }
    }


    @FXML
    private void keyboardInput(KeyEvent e) {
        maze = mazeSolver.getMaze();
        List<Node> childList = gridpane.getChildren();
        if (e.getCode().equals(KeyCode.W)) {
            player.moveUp();
            displayScreen(childList);
            score = player.getScore();
        }
        if (e.getCode().equals(KeyCode.S)) {
            player.moveDown();
            displayScreen(childList);
            score = player.getScore();
        }
        
        if (e.getCode().equals(KeyCode.D)) {
            player.moveRight();
            displayScreen(childList);
            score = player.getScore();
        }

        if (e.getCode().equals(KeyCode.A)) {
            player.moveLeft();
            displayScreen(childList);
            score = player.getScore();
        }

        if (player.getGameState()) {
            winningScreen();
            score = 1;
            player.setScore(score);
        }
    }




    @FXML
    private void displayScreen(List<Node> childList) {
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {

                if (mazeSolver.getPlainMaze()[i][j] == 1) {
                    childList.get((i*21) + j).setStyle("-fx-background-color: #232b2b"); // Wall, color: black
                }
                
                else if (mazeSolver.getPlainMaze()[i][j] == 2) {
                    childList.get((i*21) + j).setStyle("-fx-background-color: #68C74F"); // StartCell, color: dark green
                }

                else if (mazeSolver.getPlainMaze()[i][j] == 9) {
                    childList.get((i*21) + j).setStyle("-fx-background-color: #E43B37"); // FinishCell, color: red
                }
                
                else if (mazeSolver.getPlainMaze()[i][j] == 3) {
                    childList.get((i*21) + j).setStyle("-fx-background-color: #AAFF66"); // Path, color: light green
                }   

                else {
                    childList.get((i*21) + j).setStyle("-fx-background-color: #FAFAFA"); // Ground, color: white
                }
            }
        }
    }



    @FXML
    private void winningScreen() {
        try {
            initSolver();

            solver.setValues(mazeSolver);
            solver.solve();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Win.fxml"));
            Parent root2 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root2));  
            WinScreenController controller = fxmlLoader.getController();
            controller.initializeData(this.score, solver.getMinLength());

            stage.setMaxHeight(400);
            stage.setMaxWidth(500);
            stage.setMinHeight(400);
            stage.setMinWidth(500);
            handleButtonClickGenerateMaze();
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("WinningScreen: cant load window");
        }
    }

}
