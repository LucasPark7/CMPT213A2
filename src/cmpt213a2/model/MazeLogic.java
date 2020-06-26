package cmpt213a2.model;

import java.util.ArrayList;
import java.util.Random;

public class MazeLogic {
    private static Maze maze;
    private static int cols = 20;
    private static int rows = 15;

    public static Maze createMaze(){
        //creates 20x15 arraylist
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                //create walls of the maze
                maze.add(new Cell("Wall", i, j, false, false, (i * rows) + j, 0));
            }
        }

        //generateMaze();

        //set Hero and Monsters in corners of maze
        maze.get(21).setType("Hero");
        maze.get(38).setType("Monster");
        maze.get(38).setMonsterCount(1);
        maze.get(261).setType("Monster");
        maze.get(261).setMonsterCount(1);
        maze.get(278).setType("Monster");
        maze.get(278).setMonsterCount(1);

        return maze;
    }

    private static void generateMaze() {
        Random random = new Random();
        ArrayList<Cell> cellList = new ArrayList<>();

        maze.get(21).setChecked(true);
        cellList.add(maze.get(22));
        cellList.add(maze.get(41));

        while (cellList.size() > 0) {
            Cell selectedWall = cellList.get(random.nextInt(cellList.size()));
            int wallIndex = selectedWall.getIndex();


        }
    }
}
