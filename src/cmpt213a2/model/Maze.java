package cmpt213a2.model;

import java.util.ArrayList;

public class Maze {
    ArrayList<Cell> maze = new ArrayList<>();

    public Cell get(int index) {
        return maze.get(index);
    }

    public void add(Cell cell) {
        maze.add(cell);
    }
}
