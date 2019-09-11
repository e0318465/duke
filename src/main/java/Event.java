import java.io.Serializable;

/**
 * Allows users to set Event for their schedule,
 * input to be in the format: <code> /at </code>
 * to represent the event and time respectively.
 */
public class Event extends Task implements Serializable {
    protected String date;

    /**
     * Creates a new task under event
     * @param description elaborate on the event
     * @param date day and time of the event
     */
    public Event(String description, String date) {   //eventBy[0], time[1]
        super(description);
        this.date = date;
    }

    /**
     * Overrides toString to print in a preferred format
     * @return the String description
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at: " + date + ")";   //[E]<task toString> (at: Mon 2-4pm)
    }
}