package CAB302.Backend;

import java.awt.*;
import java.util.ArrayList;

/**
 * Maze something
 */
public abstract class Maze {
    /** The number of rows in the maze */
    protected int rows;
    /** The number of columns in the maze */
    protected int cols;
    /** A 2D array storing cell information */
    protected Cell[][] cells;
    /** The name of the maze */
    private String mazeName;
    /** The author of the maze */
    private String authorName;
    /** The filepath to the logo */
    private String logo;
    /** When the maze was created */
    private String dateTimeCreated;
    /** When the maze was last edited */
    private String dateTimeLastEdited;

//  public boolean toggleViewSolution;

    /**
     *  Creates a maze
     * @param rows The number of rows in the maze
     * @param cols The number of columns in the maze
     * @param mazeName The name of the maze
     * @param authorName The author of the maze
     * @param dateTimeCreated When the maze was created
     * @param logo The filepath to the logo
     */
    public Maze(int rows, int cols, String mazeName, String authorName, String dateTimeCreated, String logo) {
        this.rows = rows;
        this.cols = cols;
        this.mazeName = mazeName;
        this.authorName = authorName;
        this.dateTimeCreated = dateTimeCreated;
        this.dateTimeLastEdited = dateTimeCreated;
        this.logo = logo;
//        this.toggleViewSolution = false;

        // Run after the width and height has been initialised
        this.populateCells();
    }

    /**
     * Creates a maze with no logo provided
     * @param rows The number of rows in the maze
     * @param cols The number of columns in the maze
     * @param mazeName The name of the maze
     * @param authorName The author of the maze
     * @param dateTimeCreated When the maze was created
     */
    public Maze(int rows, int cols, String mazeName, String authorName, String dateTimeCreated) {
        this(rows, cols, mazeName, authorName, dateTimeCreated, "");
    }

    private void populateCells() {
        cells = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    /**
     * Number of rows in the maze
     * @return width
     */
    public int getRows() {
        return rows;
    }

    /**
     * Number of columns in the maze
     * @return cols
     */
    public int getCols() {
        return cols;
    }

    /**
     * The name of the maze
     * @return mazeName
     */
    public String getMazeName() {
        return mazeName;
    }

    /**
     * The author of the maze
     * @return authorName
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     *
     * @return
     */
    public String getDateTimeCreated() {
        return dateTimeCreated;
    }

    /**
     * Used to get maze date and time last edited.
     */
    public String getDateTimeLastEdited() {
        return dateTimeLastEdited;
    }

    /**
     * Used to get maze logo (will return "" if maze has no logo).
     */
    public String GetLogo() {
        return logo;
    }

    /**
     * Draws the maze on the JPanel
     * @param graphics The graphical component of the JPanel
     */
    public void DrawMaze(Graphics graphics) {
        int larger = Math.max(rows, cols);
        int canvasSize = 800;
        int cellSize;

        if (larger < 25) {
            cellSize = canvasSize / 25;
        } else {
            cellSize = canvasSize / larger;
        }

        int borderWidth  = (canvasSize - cellSize * rows) / 2 + 4;
        int borderHeight = (canvasSize - cellSize * cols) / 2 + 4;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int xPos = cells[row][col].getX() * cellSize + borderWidth;
                int yPos = cells[row][col].getY() * cellSize + borderHeight;

                // Top wall
                if (cells[row][col].getWalls()[0]) {
                    graphics.drawLine(xPos, yPos, xPos + cellSize, yPos);
                }

                // Right wall
                if (cells[row][col].getWalls()[1]) {
                    graphics.drawLine(xPos + cellSize, yPos, xPos + cellSize, yPos + cellSize);
                }

                // Bottom wall
                if (cells[row][col].getWalls()[2]) {
                    graphics.drawLine(xPos, yPos + cellSize, xPos + cellSize, yPos + cellSize);
                }

                // Left wall
                if (cells[row][col].getWalls()[3]) {
                    graphics.drawLine(xPos, yPos, xPos, yPos + cellSize);
                }
            }
        }
    }

    /**
     * This will be used to edit a pre-made maze.
     */
    public void editMaze(Maze baseMaze) {

    }

    /**
     * Generates a maze
     * @param startX The starting cell's x position
     * @param startY The starting cell's y position
     */
    public void generateMaze(int startX, int startY) {
        // Create a stack array to keep track of steps taken
        ArrayList<Cell> stack = new ArrayList<Cell>();

        // Create variable for current cell, where the maze will start generating from
        Cell current = cells[startX][startY];

        while (true) {
            Cell next = current.findValidNeighbour(cells);
            if (next != null) {
                next.explored();
                stack.add(next);
                current.removeWalls(next);
                current = next;
            } else if (stack.size() > 0) {
                int lastIndex = stack.size() - 1;
                current = stack.get(lastIndex);
                stack.remove(lastIndex);
            } else {
                break;
            }
        }
    }

    /**
     * This will be used to draw out the best possible path from the start to the finish.
     */
    public void drawSolution(boolean isSolvable) {
        if (isSolvable)
        {

        }
    }

    /**
     * This will be used to check if the maze is actually completable.
     */
    public boolean isSolvable() {
        return false;
    }

    /**
     * This will be used to add a maze to a database (using a list right now, will need to change to SQLite later).
     */
    public void addToDatabase(MazeDatabase mazeDatabase)
    {

    }

    /**
     * This will be used to remove a maze from a database (using a list right now, will need to change to SQLite later).
     */
    public void removeFromDatabase(MazeDatabase mazeDatabase)
    {

    }

    /**
     * This will be used to export a maze to an image.
     */
    public void exportImage(String fileLocation) {

    }

    /**
     * This will be used to update the date and time a maze was last edited.
     */
    public void updateEditTime() {

    }

    /**
     * This will be used to calculate the percentage between the total size of the maze and the steps required to complete it.
     */
    public int percentageCompleted() {
      return 0;
    }
}




