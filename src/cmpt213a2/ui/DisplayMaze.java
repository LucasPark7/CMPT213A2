//Granton Lo
//ID:301360495
//Email: grantonl@sfu.ca

//Lucas Park
//Email: lpa24@sfu.ca
//ID: 301362079

package cmpt213a2.ui;

import cmpt213a2.model.Maze;

//displays the maze to string
public class DisplayMaze {
    public static void displayMaze(Maze maze) {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 20; j++) {
                if (!(maze.get((i*20) + j).isRevealed())) {
                    System.out.print(".");
                }
                else {
                    switch (maze.get((i * 18) + j).getType()) {
                        case "Hero" -> System.out.print("@");
                        case "Wall" -> System.out.print("#");
                        case "Monster" -> System.out.print("!");
                        case "Power" -> System.out.print("$");
                        case "Empty" -> System.out.print(" ");
                    }
                }
            }
            System.out.println("");
        }
    }
}
