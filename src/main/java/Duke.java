import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Duke {
    public static void main(String[] args){
        Ui ui = new Ui();
        Parser parser = new Parser();
        TaskList taskList;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");    //Date format which user needs to input as
        ArrayList<Task> tasks = new ArrayList<>();
        tasks = Storage.loadTask(tasks);
        taskList = new TaskList(tasks); //curList
        ui.dukeMsg();

        parser.scanInput();

        while(!parser.firstCommand().equals("bye")) {
            switch (parser.firstCommand()) {
                case "list":
                    taskList.list();
                    break;

                case "done":
                    if (parser.secondCommand().equals("")) {
                        ui.errorMsg("done");
                        break;
                    }

                    taskList.done(parser.secondCommand());
                    break;

                case "todo":
                    if (parser.secondCommand().equals("")) {
                        ui.errorMsg("todo");
                        break;
                    }
                    taskList.todo(parser.secondCommand());
                    break;

                case "deadline":
                    if (parser.secondCommand().equals("")) {
                        ui.errorMsg("deadline");
                        break;
                    }
                    if (!parser.secondCommand().contains("/")) {
                        ui.slashErrorMsg();
                        break;
                    }

                    try {
                        Date due = simpleDateFormat.parse(parser.secondDay());
                        Task deadlineDate = new Deadline(parser.firstTaskBy(), due);
                        tasks.add(deadlineDate);
                        System.out.println("Got it. I've added this task: ");
                        System.out.println(deadlineDate);   //Auto called Task toString (we override toString to give output we want)
                        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                        Storage.saveTask(tasks);
                    } catch (ParseException except) {
                        System.out.println("☹ Deadline to be in this format: DD/MM/YYYY HHmm");
                    }
                    break;

                case "event":
                    if (parser.secondCommand().equals("")) {
                        ui.errorMsg("event");
                        break;
                    }
                    if (!parser.secondCommand().contains("/")) {
                        ui.slashErrorMsg();
                        break;
                    }

                    Task event = new Event(parser.firstEvent(), parser.time2());
                    tasks.add(event);
                    System.out.println("Got it. I've added this task: \n" + event.toString());
                    System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    Storage.saveTask(tasks);
                    break;

                case "delete":
                    taskList.delete(parser.deleteTask());
                    Storage.saveTask(tasks);
                    break;

                case "find":
                    taskList.find(parser.secondCommand());
                    break;

                default:
                    ui.defaultErrorMsg();
                    break;
            }
            parser.scanInput();
        }
        ui.byeMsg();
    }
}