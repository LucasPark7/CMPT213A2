package cmpt213a2.model;

import java.util.ArrayList;
import java.util.Random;

public class Monster {

    public int yCoord;
    public int xCoord;
    public static ArrayList<Monster> monsterList = new ArrayList<>();

    public Monster(int yCoord, int xCoord) {
        this.yCoord = yCoord;
        this.xCoord = xCoord;
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


    //move monster
    public static void moveMonster(int yCoord, int xCoord) {
        Random random = new Random();
        int move = random.nextInt(4 - 1 + 1) + 1;
        switch (move) {
            case 1:// move up
                yCoord++;
                break;
            case 2: // move down
                yCoord--;
                break;
            case 3: // move right
                xCoord++;
                break;
            case 4: // move left
                xCoord--;
                break;
        }

    }

}
