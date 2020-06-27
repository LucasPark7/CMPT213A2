//Granton Lo
//ID:301360495
//Email: grantonl@sfu.ca

//Lucas Park
//Email: lpa24@sfu.ca
//ID: 301362079
package cmpt213a2.model;

import java.util.ArrayList;
import java.util.Random;

public class Monster {

    private int yCoord;
    private int xCoord;
    public int lastMove;

    public Monster(int xCoord, int yCoord, int lastMove) {
        this.yCoord = yCoord;
        this.xCoord = xCoord;
        this.lastMove = lastMove;
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

    public int getLastMove() {
        return lastMove;
    }

    public void moveMonster(Maze mazeList, int lastMove) {
        boolean moved = false;
        Random random = new Random();
        int move = random.nextInt(4);
        if (move != lastMove) {
            switch (move) {
                case 1:
                    if (!(mazeList.get(yCoord + 1).getType().equals("Wall"))) {
                        yCoord++;
                        lastMove = 2;
                        moved = true;
                        break;
                    }
                case 2:
                    if (!(mazeList.get(yCoord - 1).getType().equals("Wall"))) {
                        yCoord--;
                        lastMove = 1;
                        moved = true;
                        break;
                    }
                case 3:
                    if (!(mazeList.get(xCoord + 1).getType().equals("Wall"))) {
                        xCoord++;
                        lastMove = 4;
                        moved = true;
                        break;
                    }
                case 4:
                    if (!(mazeList.get(xCoord - 1).getType().equals("Wall"))) {
                        xCoord--;
                        lastMove = 3;
                        moved = true;
                        break;
                    }

            }
            //if monster is forced to backtrack
            switch (lastMove) {
                case 2:
                    if (mazeList.get(yCoord + 1).getType().equals("Wall") ||
                            (mazeList.get(xCoord + 1).getType().equals("Wall")) ||
                            (mazeList.get(xCoord + 1).getType().equals("Wall"))) {
                        yCoord--;
                        lastMove = 1;
                        moved = true;
                        break;
                    }
                case 1:
                    if (mazeList.get(yCoord - 1).getType().equals("Wall") ||
                            (mazeList.get(xCoord + 1).getType().equals("Wall")) ||
                            (mazeList.get(xCoord + 1).getType().equals("Wall"))) {
                        yCoord++;
                        lastMove = 2;
                        moved = true;
                        break;
                    }
                case 4:
                    if (mazeList.get(yCoord + 1).getType().equals("Wall") ||
                            (mazeList.get(yCoord - 1).getType().equals("Wall")) ||
                            (mazeList.get(xCoord - 1).getType().equals("Wall"))) {
                        xCoord++;
                        lastMove = 3;
                        moved = true;
                        break;
                    }
                case 3:
                    if (mazeList.get(yCoord + 1).getType().equals("Wall") ||
                            (mazeList.get(yCoord - 1).getType().equals("Wall")) ||
                            (mazeList.get(xCoord + 1).getType().equals("Wall"))) {
                        xCoord--;
                        lastMove = 4;
                        moved = true;
                        break;
                    }
            }
            if (moved) {
                moveMonster(mazeList, lastMove);
            }
        }
    }
}
