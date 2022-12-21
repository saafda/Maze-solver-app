package MazeSolverProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface IFileHandler {
    
    void uploadFromFile(File file) throws FileNotFoundException;

    void saveToFIle(int[][] maze, Player player) throws IOException;


}
