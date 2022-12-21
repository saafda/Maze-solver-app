package MazeSolverProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MazeSolver {

    // Variables

    private FileHandler fileHandler;

    private int x = 21;

    private int y = 21;

    private int[][] emptyMaze;

    private int[] firstCell = new int[2];

    private int[] lastCell = new int[2];

    private int[][] plainMaze = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

    // getters and setters

    public int getXDimensions() {
        return this.x;
    }

    public int getYDimensions() {
        return this.y;
    }

    public int[][] getMaze() {
        return this.plainMaze;
    }

    public int[] getLastCell() {
        return this.lastCell;
    }

    public int[][] getPlainMaze() {
        return this.plainMaze;
    }
 
    public void setFirstCell(int i, int j) {
        this.firstCell[0] = i;
        this.firstCell[1] = j;
    }

    public void setLastCell(int i, int j) {
        this.lastCell[0] = i;
        this.lastCell[1] = j;
    }

    public void setPlainMaze(int[][] maze) {
        this.plainMaze = maze;
    }


    public void setValues(FileHandler fileHandler) {
        this.fileHandler = fileHandler;

        setPlainMaze(fileHandler.getMazeFromFile());
        setFirstCell(this.fileHandler.getStartingX(), this.fileHandler.getEndingY());
        setLastCell(this.fileHandler.getEndingX(), this.fileHandler.getEndingY());
    }


    public int[] getFirstCell() {
        for (int i = 0; i < getMaze().length; i++) {
            for (int j = 0; j < getMaze()[i].length; j++) {
                if (getMaze()[i][j] == 2) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { 1, 1 };
    }



    private int[][] emptyMaze() {
        this.emptyMaze = new int[x][y];
        for (int i = 0; i < emptyMaze.length; i++) {
            for (int j = 0; j < emptyMaze[0].length; j += 2) {
                emptyMaze[i][j] = 1;
            }
        }

        for (int i = 0; i < emptyMaze.length; i += 2) {
            for (int j = 0; j < emptyMaze[0].length; j++) {
                emptyMaze[i][j] = 1;
            }
        }
        return emptyMaze;
    }

    private ArrayList<int[]> findNeighbours(int[] cell) {
        int[][] neighboursTemp = new int[4][2];

        for (int i = 0; i < 4; i++) {
            if (cell[0] - 2 > 0) {
                neighboursTemp[0][0] = cell[0] - 2;
                neighboursTemp[0][1] = cell[1];
            }
            if (cell[0] + 2 < x - 1) {
                neighboursTemp[1][0] = cell[0] + 2;
                neighboursTemp[1][1] = cell[1];
            }
            if (cell[1] - 2 > 0) {
                neighboursTemp[2][0] = cell[0];
                neighboursTemp[2][1] = cell[1] - 2;
            }
            if (cell[1] + 2 < y - 1) {
                neighboursTemp[3][0] = cell[0];
                neighboursTemp[3][1] = cell[1] + 2;
            }
        }

        ArrayList<int[]> neighbours = new ArrayList<int[]>();

        for (int[] neighbour : neighboursTemp) {
            if (neighbour[0] != 0 && neighbour[1] != 0) {
                neighbours.add(neighbour);
            }
        }
        return neighbours;
    }

    public int[][] generateMaze() {

        Random rd = new Random();

        this.plainMaze = emptyMaze();
        int[][] visitedMap = new int[x][y];

        int unvisited = ((x - 1) / 2) * ((y - 1) / 2);

        int[] currentCell = new int[] {1, 1};


        while (unvisited > 0) {
            ArrayList<int[]> neighbours = findNeighbours(currentCell);
            int[] randomNeighbour = neighbours.get(rd.nextInt(0, neighbours.size()));
            if (visitedMap[randomNeighbour[0]][randomNeighbour[1]] == 0) {
                this.plainMaze[(randomNeighbour[0] + currentCell[0]) / 2][(randomNeighbour[1] + currentCell[1]) / 2] = 0;
                visitedMap[randomNeighbour[0]][randomNeighbour[1]] = 1;
                unvisited -= 1;
            }
            currentCell[0] = randomNeighbour[0];
            currentCell[1] = randomNeighbour[1];
        }

        this.firstCell = new int[] {1, 1};
        
        int[] localLastCell = new int[] {currentCell[0], currentCell[1] };

        if (localLastCell[0] == firstCell[0] && localLastCell[1] == firstCell[1]) { // If the last cell is the first we pick the furthest corner as the last cell.
            this.lastCell[0] = 19;
            this.lastCell[1] = 19;
            localLastCell[0] = 19;
            localLastCell[1] = 19;
        }
        else {this.lastCell = localLastCell;}    

        this.plainMaze[this.firstCell[0]][this.firstCell[1]] = 2;
        this.plainMaze[localLastCell[0]][localLastCell[1]] = 9;
    
        return this.plainMaze;
    }

    // https://en.wikipedia.org/wiki/Maze_generation_algorithm

    public String toString(int[][] maze) {
        StringBuilder outString = new StringBuilder();
        for (int[] row : maze) {
            outString.append(Arrays.toString(row)).append('\n');
        }
        outString.deleteCharAt(outString.length() - 1);
        String s = outString.toString();
        return s;
    }

    public static void main(String[] args) {

    }

}


