import java.util.ArrayList;

public class TaskList {
    protected ArrayList<Task> doTask;

    public TaskList(ArrayList<Task> curList){
        this.doTask = curList;
    }

    public void add(Task addTask) {
        this.doTask.add(addTask);
        System.out.println("Got it. I've added this task: ");
        System.out.println(addTask.toString());
        System.out.println("Now you have " + doTask.size() + " tasks in the list.");
    }

    public void delete(int deleteTask) {
        System.out.println("Noted. I've removed this task: ");
        System.out.println(doTask.get(deleteTask-1));
        this.doTask.remove(deleteTask-1);
        System.out.println("Now you have " + doTask.size() + " tasks in the list.");
    }

    public void find(String command){
        ArrayList<Task> searchResult = new ArrayList<>();
        int count = 1;
        for (Task curTask : doTask){
            if(curTask.description.contains(command))
                searchResult.add(curTask);
        }
        System.out.println("Here are the matching tasks in your list:");
        for (Task search : searchResult) {
            System.out.print(count + "." + search + "\n");
            count++;
        }
    }

    public void list() {
        System.out.println("Here are the tasks in your list:");
        int i = 0;
        for (Task thisTask : doTask) {
            System.out.println((i + 1) + "." + thisTask);
            i++;
        }
    }

    public void done(String secondCommand) {
        int choice = Integer.parseInt(secondCommand);
        doTask.get(choice - 1).markAsDone();
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println(doTask.get(choice - 1).toString());
        Storage.saveTask(doTask);
    }

    public void todo(String secondCommand) {
        Task todo = new Todo(secondCommand);
        add(todo);
        Storage.saveTask(doTask);
    }
}
