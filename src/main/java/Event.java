public class Event extends Task {
    protected String date;

    public Event(String description, String date) {   //eventBy[0], time[1]
        super(description);
        this.date = date;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at: " + date + ")";   //[E]<task toString> (at: Mon 2-4pm)
    }
}