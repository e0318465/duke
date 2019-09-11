import java.util.Scanner;

/**
 * Deals with making sense of the user command.
 * Captures the input by users and split it
 * according to the command, description and time.
 */
public class Parser {
    protected Scanner scan = new Scanner( System.in );
    protected String input;

    /**
     * Takes in user input.
     *
     * @return the full input keyed in by the user
     */
    public String scanInput(){
        return this.input = scan.nextLine();
    }

    /**
     * Splits the user input to obtain the first word.
     * First word may consist of deadline, event, list, etc.
     *
     * @return the first word of the input
     */
    public String firstCommand(){
        String[] command = input.split(" ", 2);
        return command[0];
    }

    /**
     * Splits the user input to obtain everything else apart from the first word.
     *
     * @return description of input
     */
    public String secondCommand(){
        String[] command = input.split(" ", 2);
        return command[1];
    }

    /**
     * Splits the description for tasks assigned to deadline.
     * The task assigned to deadline may be things like
     * "return book".
     *
     * @return the description for task assigned to deadline
     */
    public String firstTaskBy(){
        String[] taskBy = secondCommand().split("/by ", 2);
        return taskBy[0];
    }

    /**
     * Splits the description for tasks assigned to deadline.
     * The date and time assigned to deadline may look like,
     * "2/12/2019 1800".
     *
     * @return the date and time for task assigned to deadline
     */
    public String secondTaskBy(){
        String[] taskBy = secondCommand().split("/by", 2);
        return taskBy[1];
    }

    /**
     * Splits the date and time for tasks assigned to deadline.
     * Date will be in this format, "2/12/2019".
     *
     * @return the date for task assigned to deadline
     */
    public String firstDay(){
        String[] day = secondTaskBy().split(" ", 2);
        return day[0];
    }

    /**
     * Splits the date and time for tasks assigned to deadline.
     * Time will be in this format, "1800".
     *
     * @return the time for task assigned to deadline
     */
    public String secondDay(){
        String[] day = secondTaskBy().split(" ", 2);
        return day[1];
    }

    /**
     * Splits the event to description and day. This returns the
     * description of the event, for example, "project meeting".
     *
     * @return the description of event
     */
    public String firstEvent(){
        String[] eventBy = secondCommand().split("/at", 2);
        return eventBy[0];
    }

    /**
     * Splits the event to description and day. This returns the
     * day and time of the event, for example, "Mon 2-4pm".
     *
     * @return the day and time of event
     */
    public String secondEvent(){
        String[] eventBy = secondCommand().split("/at", 2);
        return eventBy[1];
    }

    /**
     * Splits the day and time of event. This returns the
     * day of the event, for example, "Mon".
     *
     * @return the day of event
     */
    public String time1(){
        String[] time = secondEvent().split(" ", 2);
        return time[0];
    }

    /**
     * Splits the day and time of event. This returns the
     * time of the event, for example, "2-4pm".
     *
     * @return the time of event
     */
    public String time2(){
        String[] time = secondEvent().split(" ", 2);
        return time[1];
    }

    /**
     * Delete task according to number.
     * Converts string to integer
     *
     * @return the task number
     */
    public int deleteTask(){
        return Integer.parseInt(secondCommand());
    }
}
