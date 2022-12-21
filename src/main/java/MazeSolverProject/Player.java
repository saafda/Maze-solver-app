package MazeSolverProject;

public class Player {
 
    // variables

    private int xPosition;
    
    private int yPosition;

    private int[][] maze;

    private int score;

    private boolean gameState;

    // getters and setters

    public int getxPosition() {
        return xPosition;
    }
    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }
    public int getyPosition() {
        return yPosition;
    }
    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
    public int[][] getMaze() {
        return maze;
    }
    public void setMaze(int[][] maze) {
        this.maze = maze;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getScore() {
        return this.score;
    }
    public void setGameState(boolean state) {
        this.gameState = state;
    }
    public boolean getGameState() {
        return this.gameState;
    }

    public void setValues(FileHandler fileHandler, int score) {
        setMaze(fileHandler.getMazeFromFile());
        setxPosition(fileHandler.getStartingX());
        setyPosition(fileHandler.getStartingY());
        setScore(score);
    }
    public void setValues(MazeSolver mazeSolver, int score) {
        setMaze(mazeSolver.getPlainMaze());
        setxPosition(mazeSolver.getFirstCell()[0]);
        setyPosition(mazeSolver.getFirstCell()[1]);
        setScore(score);
    }
  

    public void moveUp() {
        if (maze[getxPosition() - 1][getyPosition()] == 0) {// forwards
            maze[getxPosition() - 1][getyPosition()] = 3;
            setxPosition(getxPosition() - 1);
            setScore(getScore() + 1);
        }

        else if (maze[getxPosition() - 1][getyPosition()] == 2) { // back to start
            maze[getxPosition()][getyPosition()] = 0;
            setxPosition(getxPosition() - 1);
            setScore(getScore() - 1);
        }

        else if (maze[getxPosition() - 1][getyPosition()] == 3) { // backwards
            maze[getxPosition()][getyPosition()] = 0;
            setxPosition(getxPosition() - 1);
            setScore(getScore() - 1);
        }

        else if (maze[getxPosition() - 1][getyPosition()] == 9) { // win
            maze[getxPosition() - 1][getyPosition()] = 3;
            setxPosition(getxPosition() - 1);
            setGameState(true);
            setScore(getScore() + 1);
        }
    }

    public void moveDown() {
        if (maze[getxPosition() + 1][getyPosition()] == 0) { // forwards
            maze[getxPosition() + 1][getyPosition()] = 3;
            setxPosition(getxPosition() + 1);
            setScore(getScore() + 1);
        }

        else if (maze[getxPosition() + 1][getyPosition()] == 2) { // back to start
            maze[getxPosition()][getyPosition()] = 0;
            setxPosition(getxPosition() + 1);
            setScore(getScore() - 1);
        }
        
        else if (maze[getxPosition() + 1][getyPosition()] == 3) { // backwards
            maze[getxPosition()][getyPosition()] = 0;
            setxPosition(getxPosition() + 1);
            setScore(getScore() - 1);
        }

        else if (maze[getxPosition() + 1][getyPosition()] == 9) { // win
            maze[getxPosition() + 1][getyPosition()] = 3;
            setxPosition(getxPosition() + 1);
            setGameState(true);
            setScore(getScore() + 1);
        }   
    }

    public void moveRight() {
        if (maze[getxPosition()][getyPosition() + 1] == 0) { // forwards
            maze[getxPosition()][getyPosition() + 1] = 3;
            setyPosition(getyPosition() + 1);
            setScore(getScore() + 1);
        }

        else if (maze[getxPosition()][getyPosition() + 1] == 2) { // back to start
            maze[getxPosition()][getyPosition()] = 0;
            setyPosition(getyPosition() + 1);
            setScore(getScore() - 1);
        }

        else if (maze[getxPosition()][getyPosition() + 1] == 3) { // backwards
            maze[getxPosition()][getyPosition()] = 0;
            setyPosition(getyPosition() + 1);
            setScore(getScore() - 1);
        }

        else if (maze[getxPosition()][getyPosition() + 1] == 9) { // win
            maze[getxPosition()][getyPosition() + 1] = 3;
            setyPosition(getyPosition() + 1);
            setGameState(true);
            setScore(getScore() + 1);
        }
    }

    public void moveLeft() {
        if (maze[getxPosition()][getyPosition() - 1] == 0) { // forwards
            maze[getxPosition()][getyPosition() - 1] = 3;
            setyPosition(getyPosition() - 1);
            setScore(getScore() + 1);
        }

        else if (maze[getxPosition()][getyPosition() - 1] == 2) { // back to start
            maze[getxPosition()][getyPosition()] = 0;
            setyPosition(getyPosition() - 1);
            setScore(getScore() - 1);
        }

        else if (maze[getxPosition()][getyPosition() - 1] == 3) { // backwards
            maze[getxPosition()][getyPosition()] = 0;
            setyPosition(getyPosition() - 1);
            setScore(getScore() - 1);
        }
        
        else if (maze[getxPosition()][getyPosition() - 1] == 9) { // win
            maze[getxPosition()][getyPosition() - 1] = 3;
            setyPosition(getyPosition() - 1);
            setGameState(true);
            setScore(getScore() + 1);
        }
    }
}
