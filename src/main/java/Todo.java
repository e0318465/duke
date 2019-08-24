public class Todo extends Task {
    public Todo(String description) {   //command[1]
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();    //[T]<task toString>
    }
}