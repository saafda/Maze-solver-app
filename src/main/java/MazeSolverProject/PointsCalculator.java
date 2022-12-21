package MazeSolverProject;

public class PointsCalculator {
    private int score;


    public int calculateScore(int perfectScore) {

        if (this.score == perfectScore) return -1;

        if (this.score < perfectScore) throw new IllegalStateException("Impossible state, score can never be better than perfect");

        else {
            return (this.score * 100) / perfectScore;
        }
    }

    // getters and setters

    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }

    

    public static void main(String[] args) {
        
    }
}
