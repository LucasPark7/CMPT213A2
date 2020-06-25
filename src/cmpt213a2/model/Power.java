package cmpt213a2.model;

public class Power {

    static int yCoord;
    static int xCoord;

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

    public Power(int yCoord, int xCoord)
    {
        this.yCoord = yCoord;
        this.xCoord = xCoord;
    }
}
