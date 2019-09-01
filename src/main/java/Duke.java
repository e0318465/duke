import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args){
        ArrayList<Task> tasks = new ArrayList<>();
        tasks = Data.loadTask(tasks);

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");    //Date format which user needs to input as

        String input;
        Scanner scan = new Scanner( System.in );
        input = scan.nextLine();
        while(!input.equals("bye")){
            if(input.equals("list")){       //List all tasks
                System.out.println("Here are the tasks in your list:");
                int i=0;
                for(Task thisTask : tasks) {
                    System.out.println((i + 1) + "." + thisTask);
                    i++;
                }
            }

            else{   //Check for other commands
                //Done, to do, deadline, event
                String[] command = input.split(" ", 2);
                switch(command[0]) {
                    case "done":
                        if(input.equals("done")) {
                            System.out.println("☹ OOPS!!! The description of a done cannot be empty.");
                            break;
                        }

                        int choice = Integer.parseInt(command[1]);
                        tasks.get(choice-1).markAsDone();
                        System.out.println("Nice! I've marked this task as done: ");
                        System.out.println(tasks.get(choice-1).toString());
                        Data.saveTask(tasks);
                        break;

                    case "todo":
                        if(input.equals("todo")) {
                            System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                            break;
                        }

                        Task todo = new Todo(command[1]);
                        tasks.add(todo);
                        System.out.println("Got it. I've added this task: ");
                        System.out.println(todo.toString());
                        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                        Data.saveTask(tasks);
                        break;

                    case "deadline":
                        if(input.equals("deadline")){
                            System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
                            break;
                        }
                        if(!command[1].contains("/")){
                            System.out.println("☹ OOPS!!! The description of a deadline needs a '/' to separate description and day");
                            break;
                        }

                        String[] taskBy = command[1].split("/", 2); //taskBy[0] & taskBy[1] - "return book" & "by 2/12/2019 1800"
                        if(!taskBy[1].contains("by")){
                            taskBy[1] = "by " + taskBy[1];
                        }

                        String[] day = taskBy[1].split(" ", 2);     //"by" & "2/12/2019 1800"
                        try{
                            Date due = simpleDateFormat.parse(day[1]);
                            Task deadlineDate = new Deadline(taskBy[0], due);
                            tasks.add(deadlineDate);
                            System.out.println("Got it. I've added this task: ");
                            System.out.println(deadlineDate);   //Auto called Task toString (we override toString to give output we want)
                            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                            Data.saveTask(tasks);
                        } catch(ParseException except){
                            System.out.println("☹ Deadline to be in this format: DD/MM/YYYY HHmm");
                        }
                        break;

                    case "event":
                        if(input.equals("event")) {
                            System.out.println("☹ OOPS!!! The description of an event cannot be empty.");
                            break;
                        }
                        if(!command[1].contains("/")){
                            System.out.println("☹ OOPS!!! The description of an event needs a '/' to separate description and time");
                            break;
                        }

                        String[] eventBy = command[1].split("/", 2);
                        if(!eventBy[1].contains("at")){
                            eventBy[1] = "at " + eventBy[1];
                        }
                        String[] time = eventBy[1].split(" ", 2);

                        Task event = new Event(eventBy[0], time[1]);
                        tasks.add(event);
                        System.out.println("Got it. I've added this task: \n" + event.toString());
                        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                        Data.saveTask(tasks);
                        break;

                    case "delete":
                        int lineToDelete = Integer.parseInt(command[1]);
                        System.out.println("Noted. I've removed this task: ");
                        System.out.println(tasks.get(lineToDelete-1));
                        tasks.remove(lineToDelete-1);
                        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                        Data.saveTask(tasks);
                        break;

                    case "find":
                        ArrayList<Task> searchResult = new ArrayList<>();
                        int count = 1;
                        for (Task curTask : tasks){
                            if(curTask.description.contains(command[1])){
                                searchResult.add(curTask);
                            }
                        }
                        if(searchResult.size() == 0){
                            System.out.println("No match found");
                            break;
                        }
                        System.out.println("Here are the matching tasks in your list:");
                        for (Task search : searchResult) {
                            System.out.print(count + "." + search + "\n");
                            count++;
                        }
                        break;

                    default:
                        System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                        break;
                }
            }
            input = scan.nextLine();
        }

        System.out.println("Bye. Hope to see you again soon!");
    }
}