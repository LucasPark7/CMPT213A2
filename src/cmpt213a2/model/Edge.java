//Granton Lo
//ID:301360495
//Email: grantonl@sfu.ca

//Lucas Park
//Email: lpa24@sfu.ca
//ID: 301362079

package cmpt213a2.model;

//Tracks edges of each cell for maze generation
public class Edge {
    private int xCoord;
    private int yCoord;
    private String direction;

    public Edge(int xCoord, int yCoord, String direction) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.direction = direction;
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public String getDirection() {
        return direction;
    }
}
