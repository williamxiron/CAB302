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
    public OpenEndedMaze(float width, float height, String mazeName, String authorName, String dateTimeCreated, String logo) {
        super(width, height, mazeName, authorName, dateTimeCreated, logo);
    }

    public OpenEndedMaze(float width, float height, String mazeName, String authorName, String dateTimeCreated) {
        super(width, height, mazeName, authorName, dateTimeCreated);
    }

    @Override
    public void GenerationMaze() {
        super.GenerationMaze();
        //Start and endings code here
    }
}
