package CAB302.Backend;

/**
 * This is the abstract class for the mazes, just sets up all the basic traits the mazes require.
 */
public abstract class Maze {

    private float width;
    private float height;

    private String logo;
    private String mazeName; private String authorName;
    private String dateTimeCreated; private String dateTimeLastEdited;

    public boolean toggleViewSolution = false;

    public Maze(float width, float height, String mazeName, String authorName, String dateTimeCreated, String logo) {
        this.width = width;
        this.height = height;
        this.mazeName = mazeName;
        this.authorName = authorName;
        this.dateTimeCreated = dateTimeCreated;
        this.dateTimeLastEdited = dateTimeCreated;
        this.logo = logo;
    }

    public Maze(float width, float height, String mazeName, String authorName, String dateTimeCreated) {
        this.width = width;
        this.height = height;
        this.mazeName = mazeName;
        this.authorName = authorName;
        this.dateTimeCreated = dateTimeCreated;
        this.dateTimeLastEdited = dateTimeCreated;
        this.logo = "";
    }

    /**
     * Used to get maze width.
     */
    public float GetWidth() {
        return width;
    }

    /**
     * Used to get maze height.
     */
    public float GetHeight() {
        return height;
    }

    /**
     * Used to get maze name.
     */
    public String GetMazeName() {
        return mazeName;
    }

    /**
     * Used to get maze author name.
     */
    public String GetAuthorName() {
        return authorName;
    }

    /**
     * Used to get maze date and time created.
     */
    public String GetDateTimeCreated() {
        return dateTimeCreated;
    }

    /**
     * Used to get maze date and time last edited.
     */
    public String GetDateTimeLastEdited() {
        return dateTimeLastEdited;
    }

    /**
     * Used to get maze logo (will return "" if maze has no logo).
     */
    public String GetLogo() {
        return logo;
    }

    /**
     * This will be used to draw a maze from scratch.
     */
    public void DrawMaze() {

    }

    /**
     * This will be used to edit a pre-made maze.
     */
    public void EditMaze(Maze baseMaze) {

    }

    /**
     * This will be used to randomly generate a maze (ending will be generated in the child classes).
     */
    public void GenerationMaze() {

    }

    /**
     * This will be used to draw out the best possible path from the start to the finish.
     */
    public void DrawSolution(boolean isSolvable) {
        if (isSolvable)
        {

        }
    }

    /**
     * This will be used to check if the maze is actually completable.
     */
    public boolean IsSolvable() {
        return false;
    }

    /**
     * This will be used to add a maze to a database (using a list right now, will need to change to SQLite later).
     */
    public void AddToDataBase(MazeDatabase mazeDataBase)
    {

    }

    /**
     * This will be used to remove a maze from a database (using a list right now, will need to change to SQLite later).
     */
    public void RemoveFromDataBase(MazeDatabase mazeDataBase)
    {

    }

    /**
     * This will be used to export a maze to an image.
     */
    public void ExportMazeToImage(String fileLocation) {

    }

    /**
     * This will be used to update the date and time a maze was last edited.
     */
    public void UpdateDateTimeLastEdited() {

    }

    /**
     * This will be used to calculate the percentage between the total size of the maze and the steps required to complete it.
     */
    public int CalculateStepCompletionPercentage() {
      return 0;
    }

}




