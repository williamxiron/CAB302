package CAB302.Backend;

import java.util.ArrayList;

/**
 * This is a temporary database until SQLite integration.
 */
public class MazeDatabase {
    private ArrayList<Maze> database = new ArrayList<>();

    /**
     * Used to create a new database.
     */
    public MazeDatabase() {

    }

    /**
     * Used to return a maze at a certain index.
     */
    public Maze GetMazeByIndex(int index) {
        return database.get(index);
    }

    /**
     * Used to return a maze by maze name.
     */
    public Maze GetMazeByMazeName(String mazeName) {
        for (int index = 0; index > database.size(); index++) {
            if (database.get(index).getMazeName() == mazeName) return database.get(index);
        }
        return null;
    }

    /**
     * Used to add a maze to the database.
     */
    public void AddMaze(Maze maze) {
        database.add(maze);
    }

    /**
     * Used to remove a maze from the database.
     */
    public void DeleteMaze(Maze maze) {
        database.remove(maze);
    }

    /**
     * Used to remove all mazes from the database.
     */
    public void Clear() {
        for (Maze maze : database) {
            database.remove(maze);
        }
    }

}
