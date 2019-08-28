import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task implements Serializable {
    protected Date date;    //Date saved in Date.java
    protected String dateFormat;    //Save the format as a String
    protected SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMMM yyyy h:mm a");    //Date format for output

    public Deadline(String description, Date date) {    //taskBy[0], day[1]
        super(description);
        this.date = date;
        dateFormat = simpleDateFormat.format(date);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by: " + dateFormat + ")";  //[D]<task toString> (by: 2nd of December 2019, 6pm)
    }
}