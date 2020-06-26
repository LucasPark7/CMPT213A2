package cmpt213a2.ui;

import cmpt213a2.model.Maze;

public class DisplayMaze {
    public static void displayMaze(Maze maze) {
        for (int i = 0; i < maze.size(); i++) {
            if (maze.get(i).isRevealed()) {
                System.out.println(".");
            }
            else if (maze.get(i).getType() == "Hero") {
                System.out.println("@");
            }
            else if (maze.get(i).getType() == "Monster") {
                System.out.println("!");
            }
            else if (maze.get(i).getType() == "Power") {
                System.out.println("$");
            }
            else if (maze.get(i).getType() == "Wall") {
                System.out.println("#");
            }
            else {
                System.out.println(" ");
            }
        }
    }
}
