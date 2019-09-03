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

        String input = parser.scanInput();

        while(!input.equals("bye")){

            if(input.equals("list")){
                System.out.println("Here are the tasks in your list:");
                int i=0;
                for(Task thisTask : tasks) {
                    System.out.println((i + 1) + "." + thisTask);
                    i++;
                }
            }

            else{
                switch(parser.firstCommand()) {
                    case "done":
                        if(input.equals("done")) {
                            ui.errorMsg("done");
                            break;
                        }

                        int choice = Integer.parseInt(parser.secondCommand());
                        tasks.get(choice-1).markAsDone();
                        System.out.println("Nice! I've marked this task as done: ");
                        System.out.println(tasks.get(choice-1).toString());
                        Storage.saveTask(tasks);
                        break;

                    case "todo":
                        if(input.equals("todo")) {
                            ui.errorMsg("todo");
                            break;
                        }

                        Task todo = new Todo(parser.secondCommand());
                        taskList.add(todo);
                        Storage.saveTask(tasks);
                        break;

                    case "deadline":
                        if(input.equals("deadline")){
                            ui.errorMsg("deadline");
                            break;
                        }
                        if(!parser.secondCommand().contains("/")){
                            ui.slashErrorMsg();
                            break;
                        }

                        try{
                            Date due = simpleDateFormat.parse(parser.secondDay());
                            Task deadlineDate = new Deadline(parser.firstTaskBy(), due);
                            tasks.add(deadlineDate);
                            System.out.println("Got it. I've added this task: ");
                            System.out.println(deadlineDate);   //Auto called Task toString (we override toString to give output we want)
                            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                            Storage.saveTask(tasks);
                        } catch(ParseException except){
                            System.out.println("☹ Deadline to be in this format: DD/MM/YYYY HHmm");
                        }
                        break;

                    case "event":
                        if(input.equals("event")) {
                            ui.errorMsg("event");
                            break;
                        }
                        if(!parser.secondCommand().contains("/")){
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
                        taskList.delete(parser.deleteTask());   //delete task according to number
                        Storage.saveTask(tasks);
                        break;

                    case "find":
                        taskList.find(parser.secondCommand());
                        break;

                    default:
                        ui.defaultErrorMsg();
                        break;
                }
            }
            input = parser.scanInput();
        }
        ui.byeMsg();
    }
}