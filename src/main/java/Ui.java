/**
 * Deals with interactions with the user.
 */
public class Ui {

    /**
     * Outputs the welcome message.
     */
    public void dukeMsg(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

    /**
     * Outputs the error message.
     */
    public void errorMsg(String taskType){
        System.out.println("☹ OOPS!!! The description of a " + taskType + " cannot be empty.");
    }

    /**
     * Outputs the error message for missing "/".
     */
    public void slashErrorMsg(){
        System.out.println("☹ OOPS!!! The description needs a '/'");
    }

    /**
     * Outputs the error message for invalid user input.
     */
    public void defaultErrorMsg(){
        System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    /**
     * Outputs the goodbye message.
     */
    public void byeMsg(){
        System.out.println("Bye. Hope to see you again soon!");
    }
}
