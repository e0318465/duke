import java.util.ArrayList;

/**
 * Methods to implement functions like add, delete, find and list.
 */
public class TaskList {
    protected ArrayList<Task> doTask;

    /**
     * Gets the list from task.
     *
     * @param curList task list
     */
    public TaskList(ArrayList<Task> curList){
        this.doTask = curList;
    }

    /**
     * Adds a task and prints the details.
     *
     * @param addTask task to be added
     */
    public void add(Task addTask) {
        this.doTask.add(addTask);
        System.out.println("Got it. I've added this task: ");
        System.out.println(addTask.toString());
        System.out.println("Now you have " + doTask.size() + " tasks in the list.");
    }

    /**
     * Deletes a task and prints the details..
     *
     * @param deleteTask task to be deleted
     */
    public void delete(int deleteTask) {
        System.out.println("Noted. I've removed this task: ");
        System.out.println(doTask.get(deleteTask-1));
        this.doTask.remove(deleteTask-1);
        System.out.println("Now you have " + doTask.size() + " tasks in the list.");
    }

    /**
     * Finds a keyword in task and prints the details.
     *
     * @param command keyword to be searched in taskList
     */
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

    /**
     * Prints the details.
     */
    public void list() {
        System.out.println("Here are the tasks in your list:");
        int i = 0;
        for (Task thisTask : doTask) {
            System.out.println((i + 1) + "." + thisTask);
            i++;
        }
    }

    /**
     * Marks a task as done and prints the details.
     *
     * @param secondCommand the task number
     */
    public void done(String secondCommand) {
        int choice = Integer.parseInt(secondCommand);
        doTask.get(choice - 1).markAsDone();
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println(doTask.get(choice - 1).toString());
        Storage.saveTask(doTask);
    }

    /**
     * Adds a new task to be done.
     *
     * @param secondCommand the description of the task to be done
     */
    public void todo(String secondCommand) {
        Task todo = new Todo(secondCommand);
        add(todo);
        Storage.saveTask(doTask);
    }
}
