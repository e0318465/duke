import java.io.Serializable;

public class Deadline extends Task implements Serializable {
    protected String day;

    public Deadline(String description, String day) {    //taskBy[0], day[1]
        super(description);
        this.day = day;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by: " + day + ")";  //[D]<task toString> (by: Sunday)
    }
}