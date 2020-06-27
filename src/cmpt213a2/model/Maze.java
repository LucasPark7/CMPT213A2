//Granton Lo
//ID:301360495
//Email: grantonl@sfu.ca

//Lucas Park
//Email: lpa24@sfu.ca
//ID: 301362079


package cmpt213a2.model;

import java.util.ArrayList;
/**
 * Maze class holds the maze information
 * Data includes ArrayList of cells
 * index, and size
 */
public class Maze {
    ArrayList<Cell> maze = new ArrayList<>();

    public Cell get(int index) {
        return maze.get(index);
    }

    public void add(Cell cell) {
        maze.add(cell);
    }

    public int size() {
        return maze.size();
    }
}
