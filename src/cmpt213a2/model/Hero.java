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

    public void moveHero(String input, Maze mazeList) {
        switch (input) {
            case "w" -> {
                if (mazeList.get(yCoord - 1).getType().equals("Wall")) {
                    System.out.println("Illegal Move");
                    break;
                }
                yCoord--;
                discover(mazeList);
            }
            case "a" -> {
                if (mazeList.get(xCoord - 1).getType().equals("Wall")) {
                    System.out.println("Illegal Move");
                    break;
                }
                xCoord--;
                discover(mazeList);
            }
            case "s" -> {
                if (mazeList.get(yCoord + 1).getType().equals("Wall")) {
                    System.out.println("Illegal Move");
                    break;
                }
                yCoord++;
                discover(mazeList);
            }
            case "d" -> {
                if (mazeList.get(xCoord + 1).getType().equals("Wall")) {
                    System.out.println("Illegal Move");
                    break;
                }
                xCoord++;
                discover(mazeList);
            }
        }
    }

    public void discover(Maze mazeList)
    {
        mazeList.get((xCoord * 18) + yCoord).setRevealed(true); // hero spot
        mazeList.get(((xCoord* 18) + yCoord)+1).setRevealed(true); // reveals right
        mazeList.get((xCoord * 18) + yCoord+1).setRevealed(true); // reveals up
        mazeList.get((xCoord * 18) + yCoord-1).setRevealed(true); // reveal down
        mazeList.get(((xCoord * 18) + yCoord)-1).setRevealed(true); //reveal left
        mazeList.get(((xCoord * 18) + yCoord+1)+1).setRevealed(true); // reveal top right
        mazeList.get(((xCoord * 18) + yCoord-1)+1).setRevealed(true); // reveal down right
        mazeList.get(((xCoord * 18) + yCoord-1)-1).setRevealed(true); //reveal down left
        mazeList.get(((xCoord * 18) + yCoord+1)-1).setRevealed(true);//reveal top left
    }


}
