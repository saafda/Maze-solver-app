package MazeSolverProject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class FileHandler implements IFileHandler {

    // variables

    private int[][] mazeFromFile;

    private int startingX;

    private int startingY;
    
    private int endingX;
    
    private int endingY;

    private int score;
    
    @Override
    public void uploadFromFile(File file) throws NullPointerException, FileNotFoundException {
        // FileReader og Scanner krever fileNotFoundException, 
        // men siden jeg bruker en file chooser så vil ikke dette skje,
        // men derimot hvis filen er tom vil vi trenge en NullPointerException

        // FileReader and Scanner need to fileNotFoundException wrapped around them
        // however when utilizing a file chooser this will not occurr (I don't know how it might)
        // but a file might be empty so we use NullPointerException.

        // BufferedReader bReader = new BufferedReader(new FileReader(file));

        // display the maze
        // String fileString;
        
        // try {
        //     while ((fileString = bReader.readLine()) != null); System.out.println(fileString);

        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // https://stackoverflow.com/questions/24924937/read-text-string-into-2d-array

        Scanner fileScanner = new Scanner(file);
        List<String[]> lines = new ArrayList<>();
        while(fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine().trim();
            String[] splitString = line.split(", ");
            lines.add(splitString);
        }

        String[][] result = new String[lines.size()][];
        for(int i = 0; i < result.length; i++) {
            result[i] = lines.get(i);
        }
        fileScanner.close();

        this.mazeFromFile = new int[21][21];

        this.startingX = 0;

        this.startingY = 0;

        this.endingX = 0;
        
        this.endingY = 0;

        int count = 0;

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                try{
                    int element = Integer.parseInt(result[i][j]);
                    if (element == 2) {
                        this.startingX = i;
                        this.startingY = j;
                        count++;
                    }

                    if (element == 9) {
                        this.endingX = i;
                        this.endingY = j;
                    }
                    mazeFromFile[i][j] = element;

                    if (element == 3) {
                        count++;
                    }
                    if (element == 4) {
                        this.startingX = i;
                        this.startingY = j;
                        mazeFromFile[i][j] = 3;
                        count++;
                    }
                }

                catch (NumberFormatException ex){
                    ex.printStackTrace();
                    System.out.println("Wrong file format");
                }
            }
        }    
        setScore(count);
    }

    // getters and setters

    public int[][] getMazeFromFile() {
        return this.mazeFromFile;
    }

    

    public int getStartingX() {
        return startingX;
    }

    public void setStartingX(int startingX) {
        this.startingX = startingX;
    }

    public int getStartingY() {
        return startingY;
    }

    public void setStartingY(int startingY) {
        this.startingY = startingY;
    }

    public int getEndingX() {
        return endingX;
    }

    public void setEndingX(int endingX) {
        this.endingX = endingX;
    }

    public int getEndingY() {
        return endingY;
    }

    public void setEndingY(int endingY) {
        this.endingY = endingY;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    
    @Override
    public void saveToFIle(int[][] maze, Player player) {
        if (maze != null) {
            maze[player.getxPosition()][player.getyPosition()] = 4;
            setScore(player.getScore());

            try {
                String locationName = "target/SavedMazes";

                String fileName = "maze.txt";

                File location = new File (locationName);
                File file = new File (location, fileName);
                
                BufferedWriter bfw = new BufferedWriter(new FileWriter(file));

                for (int i = 0; i < maze.length; i++) {
                    for (int j = 0; j < maze.length; j++) {
                        if (j == maze.length - 1) {
                            bfw.write(String.valueOf(maze[i][j]) + "\n");
                        }
                        else {
                            bfw.write(String.valueOf(maze[i][j]) + ", ");
                        }
                    }
                }
                bfw.close();
                maze[player.getxPosition()][player.getyPosition()] = 3;

            } catch (Exception e) {
                throw new IllegalArgumentException("Could not save to file due to illegal argument");
            }
 
        }
        else throw new NullPointerException("File can not be empty");
    }
    
}
