package CAB302.Backend;

/**
 * Open Ended Mazes are mazes that have their start and end specified with a hole in the boarder wall
 */
public class OpenEndedMaze extends Maze {
    /**
     * Open Ended Mazes are mazes that have their start and end specified with a hole in the boarder wall
     *
     * @version 1.0
     * @author Kirk Reeve
     *
     * @param width This is the width of the entire maze (0-100).
     * @param height This is the width of the entire maze (0-100).
     * @param logo This is a string containing the folder location of a logo image to be included in the maze (optional).
     */
    public OpenEndedMaze(int width, int height, String mazeName, String authorName, String dateTimeCreated, String logo) {
        super(width, height, mazeName, authorName, dateTimeCreated, logo);
    }

    public OpenEndedMaze(int width, int height, String mazeName, String authorName, String dateTimeCreated) {
        super(width, height, mazeName, authorName, dateTimeCreated);
    }

    @Override
    public void generateMaze(int StartX, int StartY) {
        super.generateMaze(StartX, StartY);

        //Start and endings code here
        Cell start = super.cells[0][0];
        start.removeWall(3);

        Cell end = super.cells[super.rows - 1][super.cols - 1];
        end.removeWall(1);
    }

    public void GenerationMaze() {
        generateMaze(0,0);
    }
}
