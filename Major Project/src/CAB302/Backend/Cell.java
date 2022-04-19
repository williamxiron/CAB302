package CAB302.Backend;

import java.util.ArrayList;
import java.lang.Math;

/**
 * The information of a particular cell inside a maze
 */
public class Cell {
    /** The x component */
    private int positionX;
    /** The y component */
    private int yComp;
    /** The walls of a cell in order of  {top, right, bottom, left} */
    private final boolean[] walls;
    /** If the cell has been explored */
    private boolean explored;

    /**
     * Creates an unexplored cell in a given (x, y) position with all walls
     * @param positionX
     * @param yComp
     */
    public Cell(int positionX, int yComp) {
        this.positionX = positionX;
        this.yComp = yComp;
        this.walls    = new boolean[] {true, true, true, true};
        this.explored = false;
    }

    /**
     * Selects a random unexplored neighbour
     * @param cells A 2D array that is the entire maze
     * @return a random unexplored neighbour, returns null if none are found
     */
    public Cell findValidNeighbour(Cell[][] cells) {
        ArrayList<Cell> neighbours = new ArrayList<Cell>();
        Cell top    = isValid(cells, positionX, yComp - 1);
        Cell right  = isValid(cells, positionX + 1, yComp);
        Cell bottom = isValid(cells, positionX, yComp + 1);
        Cell left   = isValid(cells, positionX - 1, yComp);

        if (top != null && !top.explored) {
            neighbours.add(top);
        }
        if (right != null && !right.explored) {
            neighbours.add(right);
        }
        if (bottom != null && !bottom.explored) {
            neighbours.add(bottom);
        }
        if (left != null && !left.explored) {
            neighbours.add(left);
        }

        if (neighbours.size() > 0) {
            int randomIndex = (int)(Math.random() * neighbours.size());
            return neighbours.get(randomIndex);
        } else {
            return null;
        }
    }

    /**
     * Checks if cell is in bound and returns it
     * @param cells A 2D array that is the entire maze
     * @param xComp The x position of the cell
     * @param yComp The y position of the cells
     * @return the cell if it is in bound, returns null if out of bounds
     */
    public Cell isValid(Cell[][] cells, int xComp, int yComp) {
        try {
            return cells[xComp][yComp];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    /**
     * Removes the walls in between two cells
     * @param neighbour The neighbouring cell that shares the wall to be removed
     */
    public void removeWalls(Cell neighbour) {
        int xDifference = neighbour.getX() - this.positionX;
        // Checks the right wall, then the left wall
        if (xDifference == 1) {
            this.walls[1] = false;
            neighbour.walls[3] = false;
        } else if (xDifference == -1) {
            this.walls[3] = false;
            neighbour.walls[1] = false;
        }

        int yDifference = neighbour.getY() - this.yComp;
        // Checks the bottom wall, then the top wall
        if (yDifference == 1) {
            this.walls[2] = false;
            neighbour.walls[0] = false;
        } else if (yDifference == -1) {
            this.walls[0] = false;
            neighbour.walls[2] = false;
        }
    }

    /**
     * Removes a specific wall in the cell
     * @param index Specifies a wall | 0 - top | 1 - right | 2 - bottom | 3 - left |
     */
    public void removeWall(int index) {
        walls[index] = false;
    }

    /**
     * Marks the current cell as explored
     */
    public void explored() {
        explored = true;
    }

    /**
     * Gets the x component of the cell
     * @return the x component
     */
    public int getX() {
        return positionX;
    }

    /**
     * Gets the y component of the cell
     * @return the y component
     */
    public int getY() {
        return yComp;
    }

    /**
     * Gets the state of the cell's walls
     * @return the state of cell's walls
     */
    public boolean[] getWalls() {
        return walls;
    }
}





