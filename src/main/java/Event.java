public class Event extends Task {
    protected String at;

    public Event(String description, String at) {   //eventBy[0], time[1]
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at: " + at + ")";   //[E]<task toString> (at: Mon 2-4pm)
    }
}