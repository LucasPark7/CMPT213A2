package cmpt213a2.model;

import java.util.Scanner;

public class Hero {
     private static int numPowers;
     private static  int yCoord;
     private static  int xCoord;


    public int getNumPowers() {
        return numPowers;
    }

    public void setNumPowers(int numPowers) {
        Hero.numPowers = numPowers;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        Hero.yCoord = yCoord;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        Hero.xCoord = xCoord;
    }

    private static void moveHero() {
        do {
            Scanner sc = new Scanner(System.in);
            String heroInput = sc.next().toLowerCase();
            switch (heroInput) {
                case "w" -> Hero.yCoord++;
                case "a" -> xCoord--;
                case "s" -> yCoord--;
                case "d" -> xCoord++;
            }

        } while (true);

    }

}
