package cmpt213a2.ui;

import cmpt213a2.model.Maze;
import cmpt213a2.model.MazeLogic;

public class Main {
    public static void main(String[] args) {
        boolean gameDone = false;
        Maze maze = MazeLogic.createMaze();

        System.out.println("DIRECTIONS:");
        System.out.println("    Kill 3 Monsters!");
        System.out.println("LEGEND: ");
        System.out.println("    #: Wall");
        System.out.println("    @: You (the hero)");
        System.out.println("    !: Monster");
        System.out.println("    $: Power");
        System.out.println("    .: Unexplored space");
        System.out.println("MOVES:");
        System.out.println("    Use W (up), A (left), S (down), D (right) to move.");
        System.out.println("    (Press enter after each move)");

        while (!(gameDone)) {
            System.out.println("Maze:");

            gameDone = true;
        }
    }
}
