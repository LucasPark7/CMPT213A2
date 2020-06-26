//Granton Lo
//ID:301360495
//Email: grantonl@sfu.ca

//Lucas Park
//Email: lpa24@sfu.ca
//ID: 301362079
package cmpt213a2.model;

import java.util.Random;

public class Monster {

    private int yCoord;
    private int xCoord;
    public static int lastMove;

    public Monster(int xCoord, int yCoord) {
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


    public void moveMonster()
    {
        Random random = new Random();
        int move = random.nextInt(4-1+1) + 1;
        if(move != lastMove)
        {
            switch (move)
            {
                case 1 -> yCoord++;
                case 2 -> yCoord--;
                case 3 -> xCoord++;
                case 4 -> xCoord--;
            }
            lastMove = move;
        }
        else
        {
            move = random.nextInt(4-1+1) + 1;
            moveMonster();
        }

    }

}
