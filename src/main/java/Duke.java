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

        Task[] tasks = new Task[100];

        String input;
        Scanner scan = new Scanner( System.in );
        input = scan.nextLine();
        int counter = 0;
        while(!input.equals("bye")){
            if(input.equals("list")){       //List all tasks
                System.out.println("Here are the tasks in your list:");
                for(int j=0; j<counter; j++)
                    System.out.println((j+1) + "." + tasks[j].toString());
            }

            else{                           //Check for other commands
                //Done, to do, deadline, event
                String[] command = input.split(" ", 2);
                switch(command[0]) {
                    case "done":
                        int choice = Integer.parseInt(command[1]);
                        tasks[choice-1].markAsDone();
                        System.out.println("Nice! I've marked this task as done: ");
                        System.out.println(tasks[choice-1].toString());
                        break;

                    case "todo":
                        tasks[counter] = new Todo(command[1]);
                        System.out.println("Got it. I've added this task: ");
                        System.out.println(tasks[counter].toString());
                        counter++;
                        System.out.println("Now you have " + counter + " tasks in the list.");
                        break;

                    case "deadline":
                        String[] taskBy = command[1].split("/", 2); //"return book" & "by Sunday"
                        String[] day = taskBy[1].split(" ", 2);     //"by" & "Sunday"

                        tasks[counter] = new Deadline(taskBy[0], day[1]);
                        System.out.println("Got it. I've added this task: ");
                        System.out.println(tasks[counter].toString());
                        counter++;
                        System.out.println("Now you have " + counter + " tasks in the list.");
                        break;

                    case "event":
                        String[] eventBy = command[1].split("/", 2);
                        String[] time = eventBy[1].split(" ", 2);

                        tasks[counter] = new Event(eventBy[0], time[1]);
                        System.out.println("Got it. I've added this task: \n" + tasks[counter].toString());
                        counter++;
                        System.out.println("Now you have " + counter + " tasks in the list.");
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