public class Ui {
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

    public void errorMsg(String taskType){
        System.out.println("☹ OOPS!!! The description of a " + taskType + " cannot be empty.");
    }
    public void slashErrorMsg(){
        System.out.println("☹ OOPS!!! The description needs a '/'");
    }
    public void defaultErrorMsg(){
        System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    public void byeMsg(){
        System.out.println("Bye. Hope to see you again soon!");
    }
}
