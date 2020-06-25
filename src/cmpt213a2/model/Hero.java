package cmpt213a2.model;

import java.util.Scanner;

public class Hero {
    static int numPowers;
    static int yCoord;
    static int xCoord;

    public int getNumPowers() {
        return numPowers;
    }

    public void setNumPowers(int numPowers) {
        this.numPowers = numPowers;
    }

    public static int getyCoord() {
        return yCoord;
    }

    public static void setyCoord(int yCoord) {
        Hero.yCoord = yCoord;
    }

    public static int getxCoord() {
        return xCoord;
    }

    public static void setxCoord(int xCoord) {
        Hero.xCoord = xCoord;
    }


    private static void moveHero() {

        do {
            System.out.print("Enter move [WASD?]: ");
            Scanner sc = new Scanner(System.in);
            String heroInput = sc.next().toLowerCase();
            switch (heroInput) {

                case "w":
                    yCoord++;
                    System.out.println("moved up");
                    checkPower();
                    break;
                case "a":
                    xCoord--;
                    System.out.println("moved left");
                    checkPower();
                    break;
                case "s":
                    yCoord--;
                    System.out.println("moved down");
                    checkPower();
                    break;
                case "d":
                    xCoord++;
                    System.out.println("moved right");
                    checkPower();
                    break;
                case "?":
                    System.out.println("DIRECTIONS:\n" +
                            "Kill 3 Monsters!\n" +
                            "LEGEND:\n" +
                            "#: Wall\n" +
                            "@: You (a hero)\n" +
                            "!: Monster\n" +
                            "$: Power\n" +
                            ".: Unexplored space\n" +
                            "MOVES:\n" +
                            "Use W (up), A (left), S (down) and D (right) to move.\n" +
                            "(You must press enter after each move)");
                    break;
                case "m":
                    //reveal map;
                    break;
                case "c":
                    //cheat code
                    break;
                default:
                    System.out.println("Invalid move. Please enter just A (left), S (down), D (right), or W (up).");
                    break;
            }
        } while (true);

    }
    public static void checkPower()
    {
        if((Hero.yCoord == Power.yCoord)&&(Hero.xCoord == Power.yCoord))
        {
            Hero.numPowers++;
        }
    }
}
