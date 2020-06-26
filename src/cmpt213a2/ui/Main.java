package cmpt213a2.ui;

import cmpt213a2.model.Hero;
import cmpt213a2.model.Maze;
import cmpt213a2.model.MazeLogic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero(0, 1, 1, 3);
        int numMonsters = 3;
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
            DisplayMaze.displayMaze(maze);

            System.out.println("Total number of monsters to be killed: " + numMonsters);
            System.out.println("Number of Powers currently in possession: " + hero.getNumPowers());
            System.out.println("Number of Monsters Alive: " + hero.getMonstersRemain());
            System.out.println("Enter your move [WASD?]: ");

            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            switch (input) {
                default:
                    gameDone = true;
                    break;
            }
        }
    }
}
