import java.io.Serializable;

/**
 * The main class for the multiple subclasses.
 */
public class Task implements Serializable {
    protected String description;
    protected boolean isDone;

    /**
     * Creates a task from input.
     *
     * @param description saves the description into task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Gets the symbol which represents whether
     * a task is completed or not.
     *
     * @return a tick or cross
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * Marks the item as done, giving it a tick
     * when getStatusIcon is called.
     */
    public void markAsDone(){
        this.isDone = true;
    }

    /**
     * Overrides toString to print in a preferred format
     * @return the String description
     */
    @Override
    public String toString(){
        return "[" + getStatusIcon() + "] " + this.description;
    }
}
