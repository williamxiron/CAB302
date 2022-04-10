package CAB302.Backend;

/**
 * Close Ended Mazes are mazes that have their start and end specified with an image
 */
public class CloseEndedMaze extends Maze{
    private String startImage; private String endImage;

    /**
     * Close Ended Mazes are mazes that have their start and end specified with an image
     *
     * @version 1.0
     * @author Kirk Reeve
     *
     * @param width This is the width of the entire maze (0-100).
     * @param height This is the width of the entire maze (0-100).
     * @param startImage This is a string containing the folder location of the maze start image, maze start images are used to specify where a closed ended maze starts.
     * @param endImage This is a string containing the folder location of the maze end image, maze end images are used to specify where a closed ended maze ends.
     * @param logo This is a string containing the folder location of a logo image to be included in the maze (optional).
     */
    public CloseEndedMaze(float width, float height, String startImage, String endImage, String mazeName, String authorName, String dateTimeCreated, String logo) {
        super(width, height, mazeName, authorName, dateTimeCreated, logo);
        this.startImage = startImage;
        this.endImage = endImage;
    }

    public CloseEndedMaze(float width, float height, String mazeName, String authorName, String dateTimeCreated, String startImage, String endImage) {
        super(width, height, mazeName, authorName, dateTimeCreated);
        this.startImage = startImage;
        this.endImage = endImage;
    }

    /**
     * Used to get maze start image.
     */
    public String GetStartImage() {
        return startImage;
    }

    /**
     * Used to get maze end image.
     */
    public String GetEndImage() {
        return endImage;
    }

    @Override
    public void GenerationMaze() {
        super.GenerationMaze();
        //Start and endings code here
    }
}
