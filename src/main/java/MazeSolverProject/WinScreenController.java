package MazeSolverProject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class WinScreenController {
 
    @FXML
    Button playAgainButton;

    @FXML
    Label scoreLabel;



    @FXML
    public void initializeData(int score, int perfectScore) {
        PointsCalculator calculator = new PointsCalculator();
        calculator.setScore(score);
        int calculatedScore = calculator.calculateScore(perfectScore);
        if (calculatedScore == -1) {
            this.scoreLabel.setLayoutX(160);
            this.scoreLabel.setText("Perfect Score!");
        }
        else {
            this.scoreLabel.setLayoutX(190);
            this.scoreLabel.setText("Score: " + String.valueOf(calculatedScore));
        }
    }

    @FXML
    private void closeScene() {
        Stage stage = (Stage) playAgainButton.getScene().getWindow();
        stage.close();
    }
}
