package cmpt213a2.model;

import java.util.Random;

public class Power {
    public static int yCoord;
    public static int xCoord;

    public Power(int xCoord, int yCoord) {
        Power.yCoord = yCoord;
        Power.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        Power.yCoord = yCoord;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        Power.xCoord = xCoord;
    }

}
