import java.util.Scanner;

public class Parser {
    protected Scanner scan = new Scanner( System.in );
    protected String input;

    public String scanInput(){  //deadline return book /by 7/6/2019 1700
        return this.input = "bye";
//        return this.input = scan.nextLine();
    }

    public String firstCommand(){   //deadline or event
        String[] command = input.split(" ", 2);
        return command[0];
    }
    public String secondCommand(){   //description for deadline or event
        String[] command = input.split(" ", 2);
        return command[1];
    }
    public String firstTaskBy(){   // return book
        String[] taskBy = secondCommand().split("/by ", 2); //taskBy[0] & taskBy[1] - "return book" & "by 2/12/2019 1800"
        return taskBy[0];
    }
    public String secondTaskBy(){   // 7/6/2019 1700
        String[] taskBy = secondCommand().split("/by", 2); //taskBy[0] & taskBy[1] - "return book" & "by 2/12/2019 1800"
        return taskBy[1];
    }
    public String firstDay(){   // 7/6/2019
        String[] day = secondTaskBy().split(" ", 2);
        return day[0];
    }
    public String secondDay(){   // 1700
        String[] day = secondTaskBy().split(" ", 2);
        return day[1];
    }

    public String firstEvent(){ //project meeting
        String[] eventBy = secondCommand().split("/at", 2);
        return eventBy[0];
    }
    public String secondEvent(){    //Mon 2-4pm
        String[] eventBy = secondCommand().split("/at", 2);
        return eventBy[1];
    }
    public String time1(){  //Mon
        String[] time = secondEvent().split(" ", 2);
        return time[0];
    }
    public String time2(){  //2-4pm
        String[] time = secondEvent().split(" ", 2);
        return time[1];
    }

    public int deleteTask(){
        return Integer.parseInt(secondCommand());
    }
}
