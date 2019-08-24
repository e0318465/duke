public class Deadline extends Task {
    protected String by;

    public Deadline(String description, String by) {    //taskBy[0], day[1]
        super(description);
        this.by = by;   //day
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by: " + by + ")";  //[D]<task toString> (by: Sunday)
    }
}