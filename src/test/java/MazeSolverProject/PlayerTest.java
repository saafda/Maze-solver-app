package MazeSolverProject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    private Player player;

    private int[][] maze = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                        {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 9, 0, 0, 1},
                        {1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                        {1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                        {1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                        {1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                        {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1},
                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                        {1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
    

    @BeforeEach
    public void setup() {
        player = new Player();
        player.setMaze(maze);
        player.setxPosition(1);
        player.setyPosition(1);
    }


    @Test
    @DisplayName("Testing moveUp()")
    void moveUpTest() {
        assertEquals(player.getxPosition(), 1);
        assertEquals(player.getyPosition(), 1);

        player.moveUp();
        assertEquals(player.getxPosition(), 1);
        assertEquals(player.getyPosition(), 1);

        player.setxPosition(3);
        player.setyPosition(1);

        player.moveUp();
        assertEquals(player.getxPosition(), 2);
        assertEquals(player.getyPosition(), 1);
        
        player.moveUp();
        assertEquals(player.getxPosition(), 1);
        assertEquals(player.getyPosition(), 1);

        player.moveUp();
        assertEquals(player.getxPosition(), 1);
        assertEquals(player.getyPosition(), 1);
    }

    @Test
    @DisplayName("Testing moveDown()")
    void moveDownTest() {
        assertEquals(player.getxPosition(), 1);
        assertEquals(player.getyPosition(), 1);

        player.moveDown();
        assertEquals(player.getxPosition(), 2);
        assertEquals(player.getyPosition(), 1);

        player.moveDown();
        assertEquals(player.getxPosition(), 3);
        assertEquals(player.getyPosition(), 1);

        player.setxPosition(2);
        player.setyPosition(3);

        player.moveDown();
        assertEquals(player.getxPosition(), 3);
        assertEquals(player.getyPosition(), 3);

        player.moveDown();
        assertEquals(player.getxPosition(), 3);
        assertEquals(player.getyPosition(), 3);
    }

    @Test
    @DisplayName("Testing moveRight()") 
    void moveRightTest() {
        assertEquals(player.getxPosition(), 1);
        assertEquals(player.getyPosition(), 1);

        player.moveRight();
        assertEquals(player.getxPosition(), 1);
        assertEquals(player.getyPosition(), 2);

        player.moveRight();
        assertEquals(player.getxPosition(), 1);
        assertEquals(player.getyPosition(), 3);

        player.moveRight();
        assertEquals(player.getxPosition(), 1);
        assertEquals(player.getyPosition(), 3);

        player.setxPosition(3);
        player.setyPosition(1);

        player.moveRight();
        assertEquals(player.getxPosition(), 3);
        assertEquals(player.getyPosition(), 2);
    }

    @Test
    @DisplayName("Testing moveLeft()")
    void moveLeftTest() {
        assertEquals(player.getxPosition(), 1);
        assertEquals(player.getyPosition(), 1);

        player.moveLeft();
        assertEquals(player.getxPosition(), 1);
        assertEquals(player.getyPosition(), 1);

        player.setxPosition(1);
        player.setyPosition(2);

        player.moveLeft();
        assertEquals(player.getxPosition(), 1);
        assertEquals(player.getyPosition(), 1);

        player.setxPosition(9);
        player.setyPosition(2);

        player.moveLeft();
        assertEquals(player.getxPosition(), 9);
        assertEquals(player.getyPosition(), 1);
    }
}
