//Granton Lo
//ID:301360495
//Email: grantonl@sfu.ca

//Lucas Park
//Email: lpa24@sfu.ca
//ID: 301362079

package cmpt213a2.model;

import java.util.ArrayList;
import java.util.Random;

//Holds methods for generating the maze
public class MazeLogic {
    private static final int cols = 18;
    private static final int rows = 13;
    private static String[][] maze = new String[cols][rows];

    public static String[][] createMaze(){
        //creates 18x13 2D array
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                //make temporary walls
                maze[i][j] = "Temp";
            }
        }

        generateMaze();

        return maze;
    }

    private static void generateMaze() {
        Random random = new Random();
        ArrayList<Edge> edgeList = new ArrayList<>();
        String[][] walls;

        //add edges of initial wall
        int initialCellX = random.nextInt(18);
        int initialCellY = random.nextInt(13);
        maze[initialCellX][initialCellY] = "Empty";

        addEdges(edgeList, initialCellX, initialCellY);

        //implement Prim's algorithm
        while (edgeList.size() > 0) {
            //get random edge
            Edge selectedWall = edgeList.get(random.nextInt(edgeList.size()));

            if (selectedWall.getDirection().equals("North")) {

                if (maze[selectedWall.getxCoord()][selectedWall.getyCoord()-1].equals("North")) {

                    maze[selectedWall.getxCoord()][selectedWall.getyCoord()-1] = "Empty";

                    //add new edges to edge list
                    addEdges(edgeList, selectedWall.getxCoord(),selectedWall.getyCoord()-1);
                }
                //if another edge connects to cell then it becomes a wall
                maze[selectedWall.getxCoord()][selectedWall.getyCoord()-1] = "Wall";
            }
            if (selectedWall.getDirection().equals("West")) {

                if (maze[selectedWall.getxCoord()-1][selectedWall.getyCoord()].equals("West")) {

                    maze[selectedWall.getxCoord()-1][selectedWall.getyCoord()] = "Empty";

                    //add new edges to edge list
                    addEdges(edgeList, selectedWall.getxCoord()-1,selectedWall.getyCoord());
                }
                //if another edge connects to cell then it becomes a wall
                maze[selectedWall.getxCoord()-1][selectedWall.getyCoord()] = "Wall";
            }
            if (selectedWall.getDirection().equals("East")) {

                if (maze[selectedWall.getxCoord()+1][selectedWall.getyCoord()].equals("East")) {

                    maze[selectedWall.getxCoord()+1][selectedWall.getyCoord()] = "Empty";

                    //add new edges to edge list
                    addEdges(edgeList, selectedWall.getxCoord()+1,selectedWall.getyCoord());
                }
                //if another edge connects to cell then it becomes a wall
                maze[selectedWall.getxCoord()+1][selectedWall.getyCoord()] = "Wall";
            }
            if (selectedWall.getDirection().equals("South")) {

                if (maze[selectedWall.getxCoord()][selectedWall.getyCoord()+1].equals("South")) {

                    maze[selectedWall.getxCoord()][selectedWall.getyCoord()+1] = "Empty";

                    //add new edges to edge list
                    addEdges(edgeList, selectedWall.getxCoord(),selectedWall.getyCoord()+1);
                }
                //if another edge connects to cell then it becomes a wall
                maze[selectedWall.getxCoord()][selectedWall.getyCoord()+1] = "Wall";
            }
            //remove edges
            removeEdge(edgeList, selectedWall);
        }
        for (String[] cellArray : maze) {
            for (String cell : cellArray) {
                if (!(cell.equals("Wall"))) {
                    cell = "Empty";
                }
            }
        }
    }

    private static void addEdges(ArrayList<Edge> edgeList, int xCoord, int yCoord) {

        if (xCoord == 0) { //add edges of each cell on 0 x-axis
            if (yCoord == 0) {
                edgeList.add(new Edge( xCoord, yCoord, "East"));
                //"mark" next cell so we know which cells have edges added
                maze[xCoord+1][yCoord] = "East";

                edgeList.add(new Edge( xCoord, yCoord, "South"));

                //"mark" next cell so we know which cells have edges added
                maze[xCoord][yCoord+1] = "South";
            }
            else if (yCoord == 13) {
                edgeList.add(new Edge( xCoord, yCoord, "North"));
                maze[xCoord][yCoord-1] = "North";

                edgeList.add(new Edge( xCoord, yCoord, "East"));
                maze[xCoord+1][yCoord] = "East";
            }
            else {
                edgeList.add(new Edge( xCoord, yCoord, "East"));
                maze[xCoord+1][yCoord] = "East";

                edgeList.add(new Edge( xCoord, yCoord, "North"));
                maze[xCoord][yCoord-1] = "North";

                edgeList.add(new Edge( xCoord, yCoord, "South"));
                maze[xCoord][yCoord+1] = "South";
            }
        }
        else if (xCoord == 18) { //add edges of each cell on 18 x-axis
            if (yCoord == 0) {
                edgeList.add(new Edge( xCoord, yCoord, "West"));
                maze[xCoord-1][yCoord] = "West";

                edgeList.add(new Edge( xCoord, yCoord, "South"));
                maze[xCoord][yCoord+1] = "South";
            }
            else if (yCoord == 13) {
                edgeList.add(new Edge(xCoord, yCoord, "North"));
                maze[xCoord][yCoord-1] = "North";

                edgeList.add(new Edge(xCoord, yCoord, "West"));
                maze[xCoord-1][yCoord] = "West";
            }
            else {
                edgeList.add(new Edge(xCoord, yCoord, "West"));
                maze[xCoord-1][yCoord] = "West";

                edgeList.add(new Edge(xCoord, yCoord, "North"));
                maze[xCoord][yCoord-1] = "North";

                edgeList.add(new Edge(xCoord, yCoord, "South"));
                maze[xCoord][yCoord+1] = "South";
            }
        }
        else if (yCoord == 0) { //add edges of each cell on 0 y-axis
            edgeList.add(new Edge(xCoord, yCoord, "East"));
            maze[xCoord+1][yCoord] = "East";

            edgeList.add(new Edge(xCoord, yCoord, "West"));
            maze[xCoord-1][yCoord] = "West";

            edgeList.add(new Edge(xCoord, yCoord, "South"));
            maze[xCoord][yCoord+1] = "South";
        }
        else if (yCoord == 13) { //add edges of each cell on 13 y-axis
            edgeList.add(new Edge(xCoord, yCoord, "East"));
            maze[xCoord+1][yCoord] = "East";

            edgeList.add(new Edge(xCoord, yCoord, "West"));
            maze[xCoord-1][yCoord] = "West";

            edgeList.add(new Edge(xCoord, yCoord, "North"));
            maze[xCoord][yCoord-1] = "North";
        }
        else { //any non-edge case
            edgeList.add(new Edge(xCoord, yCoord, "East"));
            maze[xCoord+1][yCoord] = "East";

            edgeList.add(new Edge(xCoord, yCoord, "West"));
            maze[xCoord-1][yCoord] = "West";

            edgeList.add(new Edge(xCoord, yCoord, "North"));
            maze[xCoord][yCoord-1] = "North";

            edgeList.add(new Edge(xCoord, yCoord, "South"));
            maze[xCoord][yCoord+1] = "South";
        }
    }

    private static void removeEdge(ArrayList<Edge> edgeList, Edge selectedWall) {
        Edge edgeToRemove = selectedWall;

        if (selectedWall.getDirection().equals("North")) {
            edgeToRemove = edgeListFind(edgeList, selectedWall.getxCoord(), selectedWall.getyCoord()-1, "North");
        }
        if (selectedWall.getDirection().equals("West")) {
            edgeToRemove = edgeListFind(edgeList, selectedWall.getxCoord(), selectedWall.getyCoord()-1, "West");
        }
        if (selectedWall.getDirection().equals("East")) {
            edgeToRemove = edgeListFind(edgeList, selectedWall.getxCoord(), selectedWall.getyCoord()-1, "East");
        }
        if (selectedWall.getDirection().equals("South")) {
            edgeToRemove = edgeListFind(edgeList, selectedWall.getxCoord(), selectedWall.getyCoord()-1, "South");
        }

        //remove from edgeList
        if (edgeToRemove != null) {
            edgeList.remove(selectedWall);
            edgeList.remove(edgeToRemove);
        }
        edgeList.remove(selectedWall);
    }

    private static Edge edgeListFind(ArrayList<Edge> edgeList, int xCoord, int yCoord, String direction) {
        for (Edge edge : edgeList) {
            if (direction.equals("North")) {
                if (edge.getyCoord() == yCoord &&
                        edge.getxCoord() == xCoord &&
                        edge.getDirection().equals("South")) {
                    return edge;
                }
            }
            if (direction.equals("West")) {
                if (edge.getyCoord() == yCoord &&
                        edge.getxCoord() == xCoord &&
                        edge.getDirection().equals("East")) {
                    return edge;
                }
            }
            if (direction.equals("East")) {
                if (edge.getyCoord() == yCoord &&
                        edge.getxCoord() == xCoord &&
                        edge.getDirection().equals("West")) {
                    return edge;
                }
            }
            if (direction.equals("South")) {
                if (edge.getyCoord() == yCoord &&
                        edge.getxCoord() == xCoord &&
                        edge.getDirection().equals("North")) {
                    return edge;
                }
            }
        }
        //if nothing found in edgeList return null
        return null;
    }
}
