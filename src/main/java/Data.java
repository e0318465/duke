import java.io.*;
import java.util.ArrayList;

public class Data{
    public static ArrayList<Task> loadTask(ArrayList<Task> log) {
        try {
            FileInputStream fileIn = new FileInputStream("./dukeData");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            log = (ArrayList<Task>) objectIn.readObject();  //Writes into data
            objectIn.close();
            fileIn.close();
        }
        catch (FileNotFoundException f) {   //Creates a new file if there are none found
            //System.out.println("New file created");
            File file = new File("./dukeData");
        }
        catch (IOException i) {
            System.out.println("IO Exception detected");
            i.printStackTrace();
        }
        catch (ClassNotFoundException c) {
            System.out.println("Class Not Found");
            c.printStackTrace();
        }
        return log;
    }

    public static void saveTask(ArrayList<Task> taskList) {
        try {
            FileOutputStream fileOut = new FileOutputStream("./dukeData");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(taskList);
            objectOut.close();
            fileOut.close();
            //System.out.println("Saved data");
        }

        catch (IOException i) {
            System.out.println("IO Exception detected");
            i.printStackTrace();
        }
    }
}