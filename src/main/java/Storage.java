import java.io.*;
import java.util.ArrayList;

/**
 * Deals with loading tasks from the file and saving tasks in the file.
 */
public class Storage {

    /**
     * Loads task list from ./dukeDate
     * If there are no files found, it creates a new file.
     *
     * @return the loaded taskList
     */
    public static ArrayList<Task> loadTask(ArrayList<Task> log) {
        try {
            FileInputStream fileIn = new FileInputStream("./dukeData");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            //Writes into data
            log = (ArrayList<Task>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        }
        //Creates a new file if there are none found
        catch (FileNotFoundException f) {
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

    /**
     * Saves file into ./dukeData
     *
     * @param taskList the list that is to be saved
     */
    public static void saveTask(ArrayList<Task> taskList) {
        try {
            FileOutputStream fileOut = new FileOutputStream("./dukeData");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(taskList);
            objectOut.close();
            fileOut.close();
        }

        catch (IOException i) {
            System.out.println("IO Exception detected");
            i.printStackTrace();
        }
    }
}