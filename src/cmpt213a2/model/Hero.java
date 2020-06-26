package cmpt213a2.model;

import java.util.Scanner;

public class Hero {
     private int numPowers;
     private int yCoord;
     private int xCoord;

    public Hero(int numPowers, int yCoord, int xCoord) {
        this.numPowers = numPowers;
        this.yCoord = yCoord;
        this.xCoord = xCoord;
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

    //rework this to take in an int input and return the correct case
    /*private static void moveHero() {
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

    }*/

}
