package cmpt213a2.model;



public class Collision {

    //hero and monster
    public void heroMonsterCheck(int yCoord, int xCoord) {
        Monster monster = new Monster(yCoord, xCoord);
        if((Hero.yCoord == monster.yCoord) && (Hero.xCoord == monster.xCoord))
        {
            if(Hero.numPowers > 0) // change to monster count later
            {
                monster = null;
                Hero.numPowers--;
            }
        }


    }

    //hero and power
    public void heroPowerCheck() {
        if ((Hero.yCoord == Power.yCoord) && (Hero.xCoord == Power.xCoord)) {
            Hero.numPowers++;
            // put numPowers to different location
        }
    }

}

