import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {
    private String fileName;
    public int totalTasks = 0;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    void addAnItem(String title, String description, String dueDate) {
        String testForNull = title + description + dueDate;
        if(testForNull.length() == 0) {
            System.out.println("Empty task, item not created.");
            return;
        }

        TaskItem newItem = new TaskItem();
        totalTasks++;

        newItem.setTitle(title);
        newItem.setDescription(description);
        newItem.setDueDate(dueDate);

        String itemString = totalTasks + ")" + " " + newItem.concatTaskItem() + "\n";
        newItem.addToTaskList(itemString);
    }



    public void deleteTask(int taskToDelete) {
        ArrayList<String> lines = new ArrayList<String>();

        try {
            File fileToEdit = new File(fileName);
            Scanner reader = new Scanner(fileToEdit);
            String line = "";
            while(reader.hasNext()) {
                line = reader.nextLine();
                if(line.contains(taskToDelete + ")")) {
                    line = line.replace(line, "");
                }
                lines.add(line);
            }
            FileWriter writer = new FileWriter(fileName);

            for(String str: lines) {
                writer.write(str + System.lineSeparator());
            }

            reader.close();
            writer.close();
        }
        catch (Exception e) {
            System.out.println("could not read file");
            e.printStackTrace();
        }
    }

    public void unmarkTaskAsComplete(int taskToUnmark) {
        ArrayList<String> lines = new ArrayList<String>();

        try {
            File fileToEdit = new File(fileName);
            Scanner reader = new Scanner(fileToEdit);
            String line = "";
            while(reader.hasNext()) {
                line = reader.nextLine();
                if(line.contains(taskToUnmark + ")")) {
                    line = line.replace("***",  "");
                }
                lines.add(line);
            }
            FileWriter writer = new FileWriter(fileName);

            for(String str: lines) {
                writer.write(str + System.lineSeparator());
            }

            reader.close();
            writer.close();
        }
        catch (Exception e) {
            System.out.println("could not read file");
            e.printStackTrace();
        }
    }

    public void markTaskAsComplete(int taskToMark) {
        ArrayList<String> lines = new ArrayList<String>();

        try {
            File fileToEdit = new File(fileName);
            Scanner reader = new Scanner(fileToEdit);
            String line = "";
            while(reader.hasNext()) {
                line = reader.nextLine();
                if(line.contains(taskToMark + ")")) {
                    line = line.replace(line, "***" + line);
                }
                lines.add(line);
            }
            FileWriter writer = new FileWriter(fileName);

            for(String str: lines) {
                writer.write(str + System.lineSeparator());
            }

            reader.close();
            writer.close();
        }
        catch (Exception e) {
            System.out.println("could not read file");
            e.printStackTrace();
        }
    }

    public void readTaskList() {
        try{
            File fileToRead = new File(fileName);
            Scanner reader = new Scanner(fileToRead);

            while(reader.hasNext()) {
                String printLine = reader.nextLine();
                System.out.println(printLine);
            }

            reader.close();
        }
        catch (Exception e) {
            System.out.println("");
        }
    }

    public int getTotalTasks () {
        ArrayList<Integer> possibleTasks = new ArrayList<>();
        try{
            File fileToRead = new File(fileName);
            Scanner reader = new Scanner(fileToRead);

            reader.nextLine();
            reader.nextLine();

            String infoToPull;
            while(reader.hasNext()) {
                infoToPull = reader.next();
                int nextTask = Integer.parseInt(infoToPull);
                possibleTasks.add(nextTask);
                reader.nextLine();
            }

            reader.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("could not read file");
        }

        return possibleTasks.toArray().length;
    }

    public void editATask(int taskToEdit, String newTitle, String newDesc, String newDate) {
        ArrayList<String> lines = new ArrayList<String>();

        try {
            File fileToEdit = new File(fileName);
            Scanner reader = new Scanner(fileToEdit);
            String line = "";
            while(reader.hasNext()) {
                line = reader.nextLine();
                if(line.contains(taskToEdit + ")")) {
                    line = line.replace(line, taskToEdit + ") [" + newDate + "] " + newTitle + ": " + newDesc);
                }
                lines.add(line);
            }
            FileWriter writer = new FileWriter(fileName);
            for(String str: lines) {
                writer.write(str + System.lineSeparator());
            }

            reader.close();
            writer.close();
        }
        catch (Exception e) {
            System.out.println("could not read file");
            e.printStackTrace();
        }
    }

    public int renameFileCheck(String newFileName) {
        if(newFileName.length() == 0)
        {
            return 1;
        }

        return 0;
    }

    public void renameFile(String newFileName) {
        try{
            File oldFile = new File(fileName);
            File renamedFile = new File(newFileName);
            oldFile.renameTo(renamedFile);
            fileName = newFileName;
        }
        catch(Exception e) {
            System.out.println("file name already exists");
        }
    }

    public void writeToFile(String taskToAdd) {
        try{
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(taskToAdd + "\n");
            writer.close();
        }
        catch(IOException e) {
            System.out.println("error in adding task");
            e.printStackTrace();
        }
    }

    public void createTaskList() {
        try {
            File newFile = new File(fileName);

            FileWriter writer = new FileWriter(newFile, false);
            System.out.println("new task list has been created\n");
            writer.write("Current Tasks\n" +
                    "-------------\n");
            writer.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}