package cmpt213a2.model;

public class Power {
    public int yCoord;
    public int xCoord;

    public Power(int xCoord, int yCoord) {
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
}
