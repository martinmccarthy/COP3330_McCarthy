import java.util.Formatter;
import java.util.Scanner;
import java.io.*;

public class TaskList {
    private Formatter taskList;
    private Scanner readList;

    public void viewList() {
        try{
            readList = new Scanner(new File("task-list.txt"));
        }
        catch(Exception e) {
            System.out.println("could not find file");
        }

        while(readList.hasNext()) {
            String s = readList.nextLine();
            System.out.println(s);
        }

        taskList.close();
    }

    public void addAnItem() {

    }

    public void createTaskList() {
        try {
            taskList = new Formatter("task-list.txt");
            taskList.format("%s", "Current Tasks\n" + "-------------");
        }
        catch(Exception e) {
            System.out.println("error");
        }

        taskList.close();
    }

    public void closeTaskList() {
        taskList.close();
    }
}
