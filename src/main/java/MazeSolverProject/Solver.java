package MazeSolverProject;

import java.util.ArrayList;
import java.util.Arrays;

public class Solver {

    // variables
    
    private MazeSolver mazeSolver;

    private int[][] maze;

    private int colDim = 21;
    private int rowDim = 21;

    private int startingCol;
    private int startingRow;

    private int endingCol;
    private int endingRow;

    private int[] minPath = new int[rowDim * colDim];
    private int minLength;
    
    private ArrayList<int[]> solved = new ArrayList<>(); 

    int[][] testMaze = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 2, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1},
                        {1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1},
                        {1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1},
                        {1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                        {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                        {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                        {1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                        {1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1},
                        {1, 0, 0, 0, 1, 9, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
                        

    // getters and setters

    public int getRowDim() {
        return this.rowDim;
    }
    
    public int getColDim() {
        return this.colDim;
    }
    
    public int[] getMinPath() {
        int[] path = Arrays.stream(this.minPath).filter(x -> x > 0).toArray();
        return path;
    }

    public int getMinLength() {
        return this.minLength;
    }

    public int getStartingRow() {
        return this.startingRow;
    }

    public int getStartingCol() {
        return this.startingCol;
    }

    public ArrayList<int[]> getSolved() {
        return this.solved;
    }

    public void setMinlength(int value) {
        this.minLength = value;
    }

    public void setMinPath(int value, int index) {
        this.minPath[index] = value;
    }

    public void setColDim(int value) {
        this.colDim = value;
    }

    public void setRowDim(int value) {
        this.rowDim = value;
    }

    public void setStartingCol(int value) {
        this.startingCol = value;
    }

    public void setStartingRow(int value) {
        this.startingRow = value;
    }

    public void setEndingCol(int value) {
        this.endingCol = value;
    }

    public void setEndingRow(int value) {
        this.endingRow = value;
    }

    public void setMaze(int[][] maze) {
        this.maze = maze;
    }

    public void setValues(MazeSolver mazeSolver) {
        this.mazeSolver = mazeSolver;

        setMaze(this.mazeSolver.getPlainMaze());

        setStartingCol(this.mazeSolver.getFirstCell()[1]);
        setStartingRow(this.mazeSolver.getFirstCell()[0]);

        setEndingCol(this.mazeSolver.getLastCell()[1]);
        setEndingRow(this.mazeSolver.getLastCell()[0]);

    }


    private void recursiveSearch(int row, int column, int[] pathUntilNow, int lengthUntilNow) {
        // Base case
        if (row < 0 || column < 0 || row >= rowDim || column >= colDim) return;
        if (maze[row][column] == 1) return;
        if (visitedChecker(row, column, pathUntilNow, lengthUntilNow)) return;

        int[] path = new int[lengthUntilNow + 1];

        System.arraycopy(pathUntilNow, 0, path, 0, lengthUntilNow);
        path[lengthUntilNow++] = row * colDim + column;

        if (row == endingRow && column == endingCol) {
            if (lengthUntilNow <= minLength) {
                minLength = lengthUntilNow;
                System.arraycopy(path, 0, minPath, 0, lengthUntilNow);
            }
            return;
        }
        recursiveSearch(row-1, column, path, lengthUntilNow);
		recursiveSearch(row, column-1, path, lengthUntilNow);
		recursiveSearch(row, column+1, path, lengthUntilNow);
		recursiveSearch(row+1, column, path, lengthUntilNow);
    
    }


    private String display(int[] pathUntilNow, int lengthUntilNow) {
        StringBuilder outString = new StringBuilder();
        ArrayList<int[]> solvedPath = new ArrayList<>(); 

        for (int i = 0; i < rowDim; i++) {
            for (int j = 0; j < colDim; j++) {

                if (this.maze[i][j] == 1){outString.append("1 ");}

                else if (visitedChecker(i, j, pathUntilNow, lengthUntilNow)) {outString.append("* "); 
                solvedPath.add(new int[]{i, j});}

                else if (i == this.startingRow && j == this.startingCol) {outString.append("S ");}

                else if (i == this.endingRow && j == this.endingCol) {outString.append("E ");}

                else if (this.maze[i][j] == 0) {outString.append("  ");}

                if (j % 21 == 0 && j != 0) {
                    outString.append("\n");}
            }
            outString.append("\n");
        }
        this.solved = solvedPath;
        return outString.toString();
    }

    private boolean visitedChecker(int row, int column, int[] pathUntilNow, int lengthUntilNow) {
        int cellNumber = row*colDim+column;

        for (int i = 0; i < lengthUntilNow; i++) {
            if (pathUntilNow[i] ==  cellNumber) return true;
        }
        return false;
    }


    public void solve() {
        int lengthUntilNow = 0;
        int[] pathUntilNow = new int[getRowDim()*getColDim()];

        for (int i = 0; i < getRowDim() * getColDim(); i++) {
            setMinPath(-1, i);
            pathUntilNow[i] = -1;
        }
        
        setMinlength(getRowDim() * getColDim() + 1);
        
        recursiveSearch(getStartingRow(), getStartingCol(), pathUntilNow, lengthUntilNow);

        display(getMinPath(), getMinLength());
    }

    // https://www.cs.ucf.edu/~dmarino/ucf/java/MazeSolver.java


    public static void main(String[] args) {
        Solver solver = new Solver();

        MazeSolver mazeSolver = new MazeSolver();

        mazeSolver.setPlainMaze(solver.testMaze);

        mazeSolver.setFirstCell(1, 1);
        mazeSolver.setLastCell(19, 5);

        mazeSolver.toString(mazeSolver.getPlainMaze());
        solver.setValues(mazeSolver);
        solver.solve();
    }
}
