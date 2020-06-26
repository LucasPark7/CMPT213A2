package cmpt213a2.model;

public class Power {
    public  static int yCoord;
    public static int xCoord;

    public Power(int yCoord, int xCoord) {
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
