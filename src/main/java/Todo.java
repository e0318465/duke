import java.io.Serializable;

public class Todo extends Task implements Serializable {
    public Todo(String description) {   //command[1]
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();    //[T]<task toString>
    }
}