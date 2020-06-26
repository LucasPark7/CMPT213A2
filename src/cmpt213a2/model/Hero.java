//Granton Lo
//ID:301360495
//Email: grantonl@sfu.ca

//Lucas Park
//Email: lpa24@sfu.ca
//ID: 301362079

package cmpt213a2.model;


public class Hero {
     public int numPowers;
     private int yCoord;
     private int xCoord;
     private int monstersRemain;

    public Hero(int numPowers, int xCoord, int yCoord, int monstersRemain) {
        this.numPowers = numPowers;
        this.yCoord = yCoord;
        this.xCoord = xCoord;
        this.monstersRemain = monstersRemain;
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

    public int getMonstersRemain() {
        return monstersRemain;
    }

    public void setMonstersRemain(int monstersRemain) {
        this.monstersRemain = monstersRemain;
    }

    public void moveHero(String input) {
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
