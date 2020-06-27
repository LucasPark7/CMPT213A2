//Granton Lo
//ID:301360495
//Email: grantonl@sfu.ca

//Lucas Park
//Email: lpa24@sfu.ca
//ID: 301362079


package cmpt213a2.model;
/**
 * Hero class moves hero
 * and discovers maze around it
 * holds information on coordinates, powers
 * and how many monsters remain
 */

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

    public static void moveHero(String input, Maze mazeList, Cell hero) {
        switch (input) {
            case "w" -> {
                if (mazeList.get((hero.getyCoord()-1) * 20 + hero.getxCoord()).getType().equals("Wall")) {
                    System.out.println("Illegal Move");
                    break;
                }
                mazeList.get(hero.getyCoord() * 20 + hero.getxCoord()).setType("Empty");
                hero.setyCoord(hero.getyCoord() - 1);
                mazeList.get(hero.getyCoord() * 20 + hero.getxCoord()).setType("Hero");
                mazeList.get((hero.getyCoord() * 20) + hero.getxCoord()).setRevealed(true);
                discover(mazeList, hero);
            }
            case "a" -> {
                if (mazeList.get(hero.getyCoord() * 20 + hero.getxCoord()-1).getType().equals("Wall")) {
                    System.out.println("Illegal Move");
                    break;
                }
                mazeList.get(hero.getyCoord() * 20 + hero.getxCoord()).setType("Empty");
                hero.setxCoord(hero.getxCoord() - 1);
                mazeList.get(hero.getyCoord() * 20 + hero.getxCoord()).setType("Hero");
                mazeList.get((hero.getyCoord() * 20) + hero.getxCoord()).setRevealed(true);
                discover(mazeList, hero);
            }
            case "s" -> {
                if (mazeList.get((hero.getyCoord()+1) * 20 + hero.getxCoord()).getType().equals("Wall")) {
                    System.out.println("Illegal Move");
                    break;
                }
                mazeList.get(hero.getyCoord() * 20 + hero.getxCoord()).setType("Empty");
                hero.setyCoord(hero.getyCoord() + 1);
                mazeList.get(hero.getyCoord() * 20 + hero.getxCoord()).setType("Hero");
                mazeList.get((hero.getyCoord() * 20) + hero.getxCoord()).setRevealed(true);
                discover(mazeList, hero);
            }
            case "d" -> {
                if (mazeList.get(hero.getyCoord() * 20 + hero.getxCoord()+1).getType().equals("Wall")) {
                    System.out.println("Illegal Move");
                    break;
                }
                mazeList.get(hero.getyCoord() * 20 + hero.getxCoord()).setType("Empty");
                hero.setxCoord(hero.getxCoord() + 1);
                mazeList.get(hero.getyCoord() * 20 + hero.getxCoord()).setType("Hero");
                mazeList.get((hero.getyCoord() * 20) + hero.getxCoord()).setRevealed(true);
                discover(mazeList, hero);
            }
        }
    }

    public static void discover(Maze mazeList, Cell hero)
    {
        mazeList.get((hero.getyCoord() * 20) + hero.getxCoord()).setRevealed(true); // hero spot
        mazeList.get((hero.getyCoord()  * 20) + hero.getxCoord() + 1).setRevealed(true); // reveals right
        mazeList.get(((hero.getyCoord() + 1) * 20) + hero.getxCoord()).setRevealed(true); // reveals up
        mazeList.get(((hero.getyCoord() - 1) * 20) + hero.getxCoord() - 1).setRevealed(true); // reveal down
        mazeList.get((hero.getyCoord()  * 20) + hero.getxCoord() -1).setRevealed(true); //reveal left
        mazeList.get(((hero.getyCoord() + 1) * 20) + hero.getxCoord()  + 1).setRevealed(true); // reveal top right
        mazeList.get(((hero.getyCoord() - 1) * 20) + hero.getxCoord()  + 1).setRevealed(true); // reveal down right
        mazeList.get(((hero.getyCoord() - 1) * 20) + hero.getxCoord() - 1).setRevealed(true); //reveal down left
        mazeList.get(((hero.getyCoord() +1 ) * 20) + hero.getxCoord() - 1).setRevealed(true);//reveal top left
    }


}
