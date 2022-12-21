// package MazeSolverProject;

// import java.text.Normalizer;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Collections;
// import java.util.List;

// import javafx.util.Pair;

// public class Dijkstra {

//     // private int[][] maze;

//     int startingX;
//     int startingY;

//     int endingX;
//     int endingY;

//     int[][] maze = {{1, 1, 1, 1, 1, 1},
//                     {1, 2, 0, 0, 0, 1},
//                     {1, 0, 0, 0, 0, 1},
//                     {1, 0, 0, 0, 0, 1},
//                     {1, 0, 0, 0, 9, 1},
//                     {1, 1, 1, 1, 1, 1}};

//     private int numberOfVertices;

//     private List<Pair<Tuple<Integer, Integer>, Integer>> distArray = new ArrayList<>();

//     private List<Integer> distances;

//     private ArrayList<Tuple<Integer, Integer>> listOfVertices = new ArrayList<>();

//     private void initializeVertices() {
//         for (int i = 0; i < maze.length; i++) {
//             for (int j = 0; j < maze.length; j++) {
//                 if (this.maze[i][j] == 0 || this.maze[i][j] == 2 || this.maze[i][j] == 9 ) {
//                     numberOfVertices++;
//                     Tuple<Integer, Integer> vertex = new Tuple<Integer,Integer>(i, j);
//                     listOfVertices.add(vertex);

//                 }

//             }
//         }
        
//         for (int i = 0; i < listOfVertices.size(); i++) {
//             distArray.add(new Pair<Tuple<Integer, Integer>, Integer>(listOfVertices.get(i), Integer.MAX_VALUE)); 
//         }
        
//         distArray.set(0, new Pair<Tuple<Integer,Integer>,Integer>(distArray.get(0).getKey(), 0));

//         int[] lengths = new int[distArray.size()];
//         for (int i = 0; i < lengths.length; i++) {
//             lengths[i] = Integer.MAX_VALUE;
//         }
//         lengths[0] = 0;

//         distances = Arrays.stream(lengths).boxed().toList();
//     }


//     private List<Tuple<Integer, Integer>> findNextVertex(Tuple<Integer, Integer> tuple) {

//         Tuple<Integer, Integer> NORTH = new Tuple<>(tuple.getX() + 1, tuple.getY());
//         Tuple<Integer, Integer> SOUTH = new Tuple<>(tuple.getX() - 1, tuple.getY());
//         Tuple<Integer, Integer> EAST = new Tuple<>(tuple.getX(), tuple.getY() + 1);
//         Tuple<Integer, Integer> WEST = new Tuple<>(tuple.getX(), tuple.getY() - 1);

//         ArrayList<Tuple<Integer, Integer>> vertices = new ArrayList<>();
//         vertices.add(NORTH); vertices.add(SOUTH); vertices.add(EAST); vertices.add(WEST);

//         List<Tuple<Integer, Integer>> nextVertex = vertices.stream().filter(x -> this.maze[x.getX()][x.getY()] != 1).toList();

//         return nextVertex;
//     }

//     private void findDistance() {

//         // while (Collections.max(distances) == Integer.MAX_VALUE) {

//         //     Pair<Tuple<Integer,Integer>,Integer> min = new Pair<Tuple<Integer,Integer>,Integer>(new Tuple<Integer, Integer>(0, 0), Integer.MAX_VALUE);
//         //     for (Pair<Tuple<Integer,Integer>,Integer> pair : distArray) {
//         //         if (pair.getValue() < min.getValue()) min = pair;
                
//         //     }

//         //     List<Tuple<Integer, Integer>> nextVertices = findNextVertex(min.getKey());

//         //     int dist = min.getValue();

//         //     for (Tuple<Integer,Integer> tuple : nextVertices) {
//         //         List<Integer> filtered = distArray.stream().filter(x -> tuple.compareTo(x.getKey())).map(x -> x.getValue()*0 + dist + 1).toList();
                
//         //         for (int i = 0; i < distArray.size(); i++) {
//         //             if (tuple.compareTo(distArray.get(i).getKey())) {
//         //                 distances.set(i, distArray.get(i).getValue());
//         //                 distArray.set(i, new Pair<Tuple<Integer,Integer>,Integer>(distArray.get(i).getKey(), filtered.get(0)));
//         //             }
//         //         }
//         //     }   

//         // }

//         Pair<Tuple<Integer,Integer>,Integer> min = new Pair<Tuple<Integer,Integer>,Integer>(new Tuple<Integer, Integer>(0, 0), Integer.MAX_VALUE);
//             for (Pair<Tuple<Integer,Integer>,Integer> pair : distArray) {
//                 if (pair.getValue() < min.getValue()) min = pair;
                
//             }

//             List<Tuple<Integer, Integer>> nextVertices = findNextVertex(min.getKey());

//             int dist = min.getValue();

//             for (Tuple<Integer,Integer> tuple : nextVertices) {
//                 List<Integer> filtered = distArray.stream().filter(x -> tuple.compareTo(x.getKey())).map(x -> x.getValue()*0 + dist + 1).toList();
                
//                 for (int i = 0; i < distArray.size(); i++) {
//                     if (tuple.compareTo(distArray.get(i).getKey())) {
//                         distances.set(i, distArray.get(i).getValue());
//                         distArray.set(i, new Pair<Tuple<Integer,Integer>,Integer>(distArray.get(i).getKey(), filtered.get(0)));
//                     }
//                 }
//             }  
//     }


//     public ArrayList<Tuple<Integer, Integer>> getListOfVertices() {
//         return listOfVertices;
//     }

//     public int[][] getMaze() {
//         return maze;
//     }

//     public int getNumberOfVertices() {
//         return numberOfVertices;
//     }

//     public void setMaze(int[][] maze) {
//         this.maze = maze;
//     }

//     public void setStartingX(int startingX) {
//         this.startingX = startingX;
//     }

//     public void setStartingY(int startingY) {
//         this.startingY = startingY;
//     }

//     public void setEndingX(int endingX) {
//         this.endingX = endingX;
//     }

//     public void setEndingY(int endingY) {
//         this.endingY = endingY;
//     }



//     public String infArrayToString(int[] array) {

//         StringBuilder sb = new StringBuilder();
//         sb.append("[");
//         for (int i : array) {
//             if (i == Integer.MAX_VALUE) {
//                 sb.append("INF, ");

//             }
//             else {
//                 sb.append(String.valueOf(i) + ", ");
//             }
//         }
//         sb.deleteCharAt(sb.length() - 1);
//         sb.deleteCharAt(sb.length() - 1);
//         sb.append("]");

//         String output = sb.toString();

//         return output;
//     }

//     public static void main(String[] args) {
//         Dijkstra dijkstra = new Dijkstra();
//         dijkstra.initializeVertices();
//         System.out.println(dijkstra.getNumberOfVertices());
//         System.out.println(dijkstra.getListOfVertices());
//         dijkstra.findDistance();
//         System.out.println(dijkstra.getNumberOfVertices());
//         System.out.println(dijkstra.getListOfVertices());

//     }

// }
