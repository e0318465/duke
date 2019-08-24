import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");

        ArrayList<String> array = new ArrayList<>();
        ArrayList<String> checkbox = new ArrayList<>();

        String input;
        Scanner scan = new Scanner( System.in );
        input = scan.nextLine();
        int counter = 0;
        while(!input.equals("bye")){
            Task t = new Task(input);
            //List all saved contents in array
            if(input.equals("list")){
                System.out.println("Here are the tasks in your list:");
                for(int i=0; i<array.size(); i++)
                    System.out.println((i+1) + "." + checkbox.get(i) + " " + array.get(i));
            }

            //Check for whether user wants to mark as done or add more input
            else{
                //Done, deadline, event, to do
                String[] command = input.split(" ", 2);
                switch(command[0]) {
                    case "done":
                        t.markAsDone(); //Task
                        String digit = input.replace("done ", "");  //Cut "done 1" to "1"
                        int num = Integer.parseInt(digit);  //Save 1 as int
                        checkbox.set(num-1, "[" + t.getStatusIcon() + "]");      //set checkbox array as checked for tat task
                        System.out.println("Nice! I've marked this task as done: ");
                        System.out.println("[" + t.getStatusIcon()+ "] " + array.get(num-1));   //[check] task
                        break;

                    case "todo":
                        array.add(counter, command[1]);
                        checkbox.add(counter, "[T][" + t.markAsUncompleted() + "]");
                        counter++;
                        System.out.println("Got it. I've added this task: ");
                        System.out.println("[T][" + t.markAsUncompleted() + "] " + command[1]);
                        System.out.println("Now you have " + array.size() + " tasks in the list.");
                        break;

                    case "deadline":
                        String[] taskBy = command[1].split("/", 2);
                        String[] day = taskBy[1].split(" ", 2);
                        System.out.println("Got it. I've added this task: ");
                        System.out.println("[D][" + t.markAsUncompleted() + "] " + taskBy[0] + "(" + day[0] + ": " + day[1] + ")");
                        array.add(counter, taskBy[0]);
                        checkbox.add(counter, "[D][" + t.markAsUncompleted() + "]");
                        counter++;
                        System.out.println("Now you have " + array.size() + " tasks in the list.");
                        break;

                    case "event":
                        String[] eventBy = command[1].split("/", 2);
                        String[] time = eventBy[1].split(" ", 3);
                        System.out.println("Got it. I've added this task: ");
                        System.out.println("[E][" + t.markAsUncompleted() + "] " + eventBy[0] + "(" + time[0] + ": " + time[1]+ " "+time[2] + ")");
                        array.add(counter, eventBy[0]);
                        checkbox.add(counter, "[E][" + t.markAsUncompleted() + "]");
                        counter++;
                        System.out.println("Now you have " + array.size() + " tasks in the list.");
                        break;
                    default:
                        break;
                }
            }
            input = scan.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}