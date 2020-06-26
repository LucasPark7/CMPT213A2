package cmpt213a2.model;

import java.util.Scanner;

public class Hero {
     public static int numPowers;
     public static int yCoord;
     public static int xCoord;

    public Hero(int numPowers, int yCoord, int xCoord) {
        this.numPowers = numPowers;
        Hero.yCoord = yCoord;
        Hero.xCoord = xCoord;
    }

    public int getNumPowers() {
        return numPowers;
    }

    public void setNumPowers(int numPowers) {
        this.numPowers = numPowers;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    private void moveHero(String input) {
        do {
            switch (input) {
                case "w" -> yCoord++;
                case "a" -> xCoord--;
                case "s" -> yCoord--;
                case "d" -> xCoord++;
            }

        } while (true);

    }

}
