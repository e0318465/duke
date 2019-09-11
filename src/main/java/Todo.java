import java.io.Serializable;

/**
 * Creates a task.
 */
public class Todo extends Task implements Serializable {
    /**
     * Creates a task.
     *
     * @param description task to be completed
     */
    public Todo(String description) {   //command[1]
        super(description);
    }

    /**
     * Overrides toString to print in a preferred format
     * @return the String description
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();    //[T]<task toString>
    }
}