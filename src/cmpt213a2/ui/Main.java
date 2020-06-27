//Granton Lo
//ID:301360495
//Email: grantonl@sfu.ca

//Lucas Park
//Email: lpa24@sfu.ca
//ID: 301362079
package cmpt213a2.ui;

import cmpt213a2.model.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Maze mazeList = new Maze();
    private static Power power;
    private static boolean gameDone = false;

    public static void main(String[] args) {

        String[][] maze = MazeLogic.createMaze();
        // Build ArrayList Maze
        for (int k = 0; k < 20; k++) {
            mazeList.add(new Cell("Wall", k, 0, true));
        }
        for (int i = 0; i < 13; i++) {

            mazeList.add(new Cell("Wall", 0, i+1, true));
            for (int j = 0; j < 18; j++) {
                if (maze[j][i].equals("Wall")) {
                    mazeList.add(new Cell( "Wall", j+1, i+1, false));
                }
                else {
                    mazeList.add(new Cell("Empty", j+1, i+1, false));
                }
            }
            mazeList.add(new Cell("Wall", 20, i+1, true));
        }
        for (int k = 0; k < 20; k++) {
            mazeList.add(new Cell("Wall", k, 15, true));
        }
        Hero hero = new Hero(0, 1, 1, 3);
        mazeList.add(new Cell("Hero", hero.getxCoord(), hero.getyCoord(), true));
        mazeList.get(21).setType("Hero");
        mazeList.get(21).setyCoord(hero.getyCoord());
        mazeList.get(21).setxCoord(hero.getxCoord());
        mazeList.get(21).setRevealed(true);


        ArrayList<Monster> monsters = new ArrayList<>(); // 0,13  18,13, 18,0
        Monster m1 = new Monster(18,13, 2);
        Monster m2 = new Monster(1,13, 1);
        Monster m3 = new Monster(18,1, 1);
        monsters.add(m1);
        monsters.add(m2);
        monsters.add(m3);
        for(int i = 0; i < monsters.size(); i++)
        {
            mazeList.add(new Cell("Monster", monsters.get(i).getxCoord(), monsters.get(i).getyCoord(), true));
            mazeList.get(monsters.get(i).getyCoord()*20 + monsters.get(i).getxCoord()).setType("Monster");
            mazeList.get(monsters.get(i).getyCoord()*20 + monsters.get(i).getxCoord()).setRevealed(true);
            mazeList.get(monsters.get(i).getyCoord()*20 + monsters.get(i).getxCoord()).setxCoord(monsters.get(i).getxCoord());
            mazeList.get(monsters.get(i).getyCoord()*20 + monsters.get(i).getxCoord()).setyCoord(monsters.get(i).getyCoord());


        }

        int numMonsters = 3; // # monsters killed to win

        //spawn power

        Random random = new Random();
        int x = random.nextInt(18); // 0 to 18
        int y = random.nextInt(13);
        if(!(maze[x][y].equals("Hero") && maze[x][y].equals("Wall")))
        {
            power = new Power(x,y);
            mazeList.add(new Cell("Power", power.xCoord, power.yCoord, true));
            mazeList.get((x*20)+y).setType("Power");
            mazeList.get((x*20)+y).setxCoord(power.xCoord);
            mazeList.get((x*20)+y).setyCoord(power.yCoord);
            mazeList.get((x*20)+y).setRevealed(true);
        }

        displayHelp();



        do {
            System.out.println("Maze:");
            DisplayMaze.displayMaze(mazeList);

            System.out.println("Total number of monsters to be killed: " + numMonsters);
            System.out.println("Number of Powers currently in possession: " + hero.getNumPowers());
            System.out.println("Number of Monsters Alive: " + hero.getMonstersRemain());
            System.out.println("Enter your move [WASD?]: ");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch (input) {
                case "?":
                    displayHelp();
                    break;
                case "c":
                    numMonsters = 1;
                    break;
                case "m":
                    for (int i = 0; i < mazeList.size(); i++) {
                        mazeList.get(i).setRevealed(true);
                    }
                    break;
                case "w":
                case "a":
                case "s":
                case "d":
                    hero.moveHero(input, mazeList);

                    heroPowerCheck(maze, hero);

                    heroMonsterCheck(maze, hero, monsters);

                    for(int i = 0; i < monsters.size(); i++)
                    {
                        monsters.get(i).moveMonster(mazeList, monsters.get(i).getLastMove());
                        heroMonsterCheck(maze, hero, monsters);
                    }
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }while(!gameDone);
    }


    private static void heroMonsterCheck(String[][] maze, Hero hero, ArrayList<Monster> monsters)
    {
        for(int i = 0; i < monsters.size(); i++) // hero vs monster
        {
            if((hero.getyCoord() == monsters.get(i).getyCoord()) && (hero.getxCoord() == monsters.get(i).getxCoord()))
            {
                if(hero.getNumPowers() > 0)
                {
                    monsters.remove(i);
                    i--;
                    hero.setMonstersRemain(hero.getMonstersRemain()-1);
                    hero.setNumPowers(hero.numPowers--);
                }
                else
                {
                    System.out.println("You have died!");
                    gameDone = true;
                }
            }
        }
        if (hero.getMonstersRemain() == 0) {
            System.out.println("You have won!");
            gameDone = true;
        }
    }

    private static void heroPowerCheck(String[][] maze, Hero hero)
    {
        if ((hero.getyCoord() == power.yCoord) && (hero.getxCoord() == power.xCoord))
        {
            hero.setNumPowers(hero.numPowers++);
            for (String[] strings : maze) {
                for (int j = 0; j < maze.length; j++) {
                    if (!(strings[j].equals("Hero") && strings[j].equals("Wall"))) {
                        Random random = new Random();
                        int x = random.nextInt(19) + 1; // 0 to 18
                        int y = random.nextInt(14) + 1;
                        power.xCoord = x;
                        power.yCoord = y;
                        mazeList.get((x * 18) + y).setType("Power");
                    }
                }

            }
        }
    }

    private static void displayHelp()
    {
        System.out.println("DIRECTIONS:");
        System.out.println("    Kill 3 Monsters!");
        System.out.println("LEGEND: ");
        System.out.println("    #: Wall");
        System.out.println("    @: You (the hero)");
        System.out.println("    !: Monster");
        System.out.println("    $: Power");
        System.out.println("    .: Unexplored space");
        System.out.println("MOVES:");
        System.out.println("    Use W (up), A (left), S (down), D (right) to move.");
        System.out.println("    (Press enter after each move)");
    }
}

