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
                for(int i=0; i<array.size(); i++)
                    System.out.println((i+1) + ".[" + checkbox.get(i) + "] " + array.get(i));
            }

            //Check for whether user wants to mark as done or add more input
            else{
                //To mark as done
                if(input.length()>4 && input.substring(0,4).equals("done")){
                    t.markAsDone(); //Task
                    String digit = input.replace("done ", "");  //Cut "done 1" to "1"
                    int num = Integer.parseInt(digit);  //Save 1 as int
                    checkbox.set(num-1, t.getStatusIcon());      //set checkbox array as checked for tat task
                    System.out.println("Nice! I've marked this task as done: ");
                    System.out.println("[" + t.getStatusIcon()+ "] " + array.get(num-1));   //[check] task
                }
                //To add more tasks into array
                else{
                    array.add(counter, input);
                    checkbox.add(counter, t.markAsUncompleted());
                    counter++;
                    System.out.println("added: " + input);
                }
            }
            input = scan.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}