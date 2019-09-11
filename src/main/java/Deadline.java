import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Allows users to set Deadline for their tasks,
 * input to be in the format: <code> /by </code>
 * to represent the task and date respectively.
 *
 * Date can also be formatted to a preferred style
 */

public class Deadline extends Task implements Serializable {
    protected Date date;
    //Save the format as a String
    protected String dateFormat;
    //Date format for output
    protected SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMMM yyyy h:mm a");

    /**
     * Creates a new task under deadline
     *
     * @param description explanation of task
     * @param date the date and time that the task is suppose to be completed by
     */
    public Deadline(String description, Date date) {
        super(description);
        this.date = date;
        //Converts the date input to output in a certain style
        dateFormat = simpleDateFormat.format(date);
    }

    /**
     * Overrides toString to print in a preferred format
     * @return the String description
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by: " + dateFormat + ")";
    }
}