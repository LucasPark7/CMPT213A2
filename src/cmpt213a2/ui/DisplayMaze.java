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
            System.out.print("#");
            for (int j = 0; j < 18; j++) {
                if(maze[j][i].equals("Hero")) {
                    System.out.print("@");
                }
                else if(maze[j][i].equals("Wall")) {
                    System.out.print("#");
                }
                else if(maze[j][i].equals("Monster")) {
                    System.out.print("!");
                }
                else if(maze[j][i].equals("Power")) {
                    System.out.print("$");
                }
                else if(maze[j][i].equals("Hidden")) {
                    System.out.print(".");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println("#");
        }
        System.out.println("####################");
    }
}
