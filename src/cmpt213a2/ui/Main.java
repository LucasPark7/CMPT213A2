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
    public static void main(String[] args) {
        Hero hero = new Hero(0, 0, 0, 3);

        ArrayList<Monster> monsters = new ArrayList<>(); // 0,13  18,13, 18,0
        Monster m1 = new Monster(0,13);
        Monster m2 = new Monster(18,13);
        Monster m3 = new Monster(18,0);
        monsters.add(m1);
        monsters.add(m2);
        monsters.add(m3);

        String[][] maze = MazeLogic.createMaze();

        int numMonsters = 3; // # monsters killed to win
        boolean gameDone = false;

        for(int i = 0; i < 18; i++)
        {
            for(int j = 0; j < 13; j++)
            {
                if(maze[i][j].equals("Hero") || maze[i][j].equals("Wall"))
                {
                    Random random = new Random();
                    int x = random.nextInt(18); // 0 to 18
                    int y = random.nextInt(13);
                    Power.xCoord = x;
                    Power.yCoord = y;
                }
            }
        }

        displayHelp();



        while (!(gameDone)) {
            System.out.println("Maze:");
            DisplayMaze.displayMaze(maze);

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
                default:
                    gameDone = true;
                    break;
                case "c":
                    numMonsters = 1;
                    break;
                case "m":
                    for(int i = 0; i < maze.length; i++)
                    {
                        for(int j = 0; j < maze.length; j++)
                        {
                            {
                                //System.out.print(" ");
                            }
                        }

                    }
                    break;
                case "w":
                case "a":
                case "s":
                case "d":
                    hero.moveHero(input);

                    heroPowerCheck(maze, hero);

                    heroMonsterCheck(maze, hero, monsters, gameDone);

                    for(int i = 0; i < monsters.size(); i++)
                    {
                        monsters.get(i).moveMonster();
                        heroMonsterCheck(maze, hero, monsters, gameDone);
                    }
                    break;
            }
        }
    }


    private static void heroMonsterCheck(String[][] maze, Hero hero, ArrayList<Monster> monsters, boolean gameDone)
    {
        for(int i = 0; i < monsters.size(); i++) // hero vs monster
        {
            if((hero.getyCoord() == monsters.get(i).getxCoord()) && (hero.getxCoord() == monsters.get(i).getxCoord()))
            {
                if(hero.getNumPowers() > 0)
                {
                    monsters.remove(i);
                    hero.setNumPowers(hero.numPowers--);
                }
                else
                {
                    gameDone = true;
                    break;
                }
            }
        }
    }

    private static void heroPowerCheck(String[][] maze, Hero hero)
    {
        if ((hero.getyCoord() == Power.yCoord) && (hero.getxCoord() == Power.xCoord))
        {
            hero.setNumPowers(hero.numPowers++);
            for(int i = 0; i < maze.length; i++)
            {
                for(int j = 0; j < maze.length; j++)
                {
                    if(maze[i][j].equals("Hero") || maze[i][j].equals("Wall"))
                    {
                        Random random = new Random();
                        int x = random.nextInt(19); // 0 to 18
                        int y = random.nextInt(14);
                        Power.xCoord = x;
                        Power.yCoord = y;
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

