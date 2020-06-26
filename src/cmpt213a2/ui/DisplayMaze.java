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
    public static void displayMaze(String[][] maze) {
        System.out.println("####################");
        for (int i = 0; i < 13; i++) {
            System.out.println("#");
            for (int j = 0; j < 19; j++) {
                if(maze[j-1][i] == "Hero") {
                    System.out.println("@");
                }
                else if(maze[j-1][i] == "Monster") {
                    System.out.println("!");
                }
                else if(maze[j-1][i] == "Power") {
                    System.out.println("$");
                }
                else if(maze[j-1][i] == "Hidden") {
                    System.out.println(".");
                }
                else {
                    System.out.println(" ");
                }
            }
            System.out.println("#");
        }
        System.out.println("####################");
    }
}
