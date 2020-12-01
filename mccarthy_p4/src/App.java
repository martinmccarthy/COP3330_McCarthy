import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.time.LocalDate;

public class App {
    static TaskItem taskItem = new TaskItem();
    public static TaskList taskList = new TaskList();
    private static Scanner input = new Scanner(System.in);

    static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");

    private static int returnValue;
    private static int totalTasks = 0;

    public static void userMenuChoice(int totalOptions) {
        try {
            System.out.print("\n> ");
            String inputString = input.nextLine();
            int userChoice = Integer.parseInt(inputString);
            if (userChoice < 1 || userChoice > totalOptions) {
                System.out.println("Error. Input out of bounds");
                userMenuChoice(totalOptions);
            }
            else {
                returnValue = userChoice;
            }
        }
        catch (NumberFormatException ex) {
            System.out.println("Invalid input. You have to enter an integer");
            userMenuChoice(totalOptions);
        }
    }


    public static void branchToOperationMenu() {
        while(returnValue != 8) {
            printListOperationMenu();
            userMenuChoice(8);
            if(returnValue == 1) {
                printTaskList();
            }
            else if(returnValue == 2) {
                insertNewItem();
            }
            else if(returnValue == 3) {
                editAnItem();
            }
            else if(returnValue == 4) {
                deleteAnItem();
            }
            else if(returnValue == 5) {
                markAnItemComplete();
            }
            else if(returnValue == 6) {
                unmarkAnItemComplete();
            }
            else if(returnValue == 7) {
                taskList.renameFile(getNewListName());
            }
        }
    }

    public static void printMenu() {
        System.out.println("Main Menu\n" +
                "---------\n" +
                "\n" +
                "1) create a new list\n" +
                "2) load an existing list\n" +
                "3) quit");
    }

    public static void printListOperationMenu() {
        System.out.println("List Operation Menu\n" +
                "---------\n" +
                "\n" +
                "1) view the list\n" +
                "2) add an item\n" +
                "3) edit an item\n" +
                "4) remove an item\n" +
                "5) mark an item as completed\n" +
                "6) unmark an item as completed\n" +
                "7) save the current list\n" +
                "8) quit to the main menu");
    }

    public static void printTaskList() {
        taskList.readTaskList();
    }

    public static String getNewListName() {
        String listName = input.nextLine();
        if(listName.length() == 0) {
            getNewListName();
        }
        return listName;
    }

    public static String getDueDateInput() {
        String dueDate = "";
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            dueDate = input.nextLine();
            LocalDate returnDate = LocalDate.parse(dueDate, formatter);
            dueDate = returnDate.toString();
            if(taskItem.dateCheck(dueDate) != 0) {
                input.nextLine();
                getDueDateInput();
            }
        }
        catch (Exception e) {
            System.out.print("Invalid date input, re-enter with format YYYY-MM-DD: ");
            getDueDateInput();
        }

        return dueDate;
    }

    public static String getDescriptionInput() {
        return input.nextLine();
    }

    public static String getTitleInput() {
        String title = input.nextLine();
        if(taskItem.titleCheck(title) != 0) {
            input.nextLine();
            getTitleInput();
        }

        return title;
    }

    public static int taskChoice(int possibleChoices) {
        try {
            String inputString = input.nextLine();
            int userChoice = Integer.parseInt(inputString);
            if (userChoice < 0 || userChoice > possibleChoices) {
                System.out.println("Error. Input out of bounds");
                taskChoice(possibleChoices);
            }
            else {
                return userChoice;
            }
        }
        catch (NumberFormatException ex) {
            System.out.println("Invalid input. You have to enter an integer");
            taskChoice(possibleChoices);
        }
        return 0;
    }

    public static void editAnItem() {
        if(totalTasks > 0) {
            printTaskList();

            System.out.print("Which task will you edit?");
            int taskToEdit = taskChoice(totalTasks);

            System.out.println("Enter a new title for task " + taskToEdit);
            String newTitle = getTitleInput();
            System.out.println("Enter a new description for task " + taskToEdit);
            String newDesc = getDescriptionInput();
            System.out.println("Enter a new due date (YYYY-MM-DD) for task " + taskToEdit);
            String newDate = getDueDateInput();

            taskList.editATask(taskToEdit, newTitle, newDesc, newDate);
        }
        else
            System.out.println("There are no tasks to edit");
    }

    public static void insertNewItem() {

        System.out.print("Task title: ");
        String title = getTitleInput();
        System.out.print("Task description: ");
        String description = getDescriptionInput();
        System.out.print("Task due date (YYYY-MM-DD): ");
        String dueDate = getDueDateInput();

        taskItem.setTitle(title);
        taskItem.setDescription(description);
        taskItem.setDueDate(dueDate);
        taskItem.setTaskNumber(totalTasks);

        String fullTask = taskItem.concatTaskItem();
        taskItem.addToTaskList(fullTask);
        totalTasks++;
    }

    public static void deleteAnItem() {
        if(totalTasks > 0) {
            printTaskList();
            System.out.println("Which task will you remove?");
            int taskToDelete = taskChoice(totalTasks);

            taskList.deleteTask(taskToDelete);
        }
        else {
            System.out.println("there are no tasks to delete!");
        }
    }

    public static void unmarkAnItemComplete() {
        if(totalTasks > 0) {
            printTaskList();
            System.out.println("Which task will you unmark as complete");
            int taskToUnmark = taskChoice(totalTasks);

            taskList.unmarkTaskAsComplete(taskToUnmark);
        }
        else {
            System.out.println("there are no tasks to unmark");
        }
    }

    public static void markAnItemComplete() {
        if(totalTasks > 0) {
            printTaskList();
            System.out.println("Which task will you mark as complete");
            int taskToMark = taskChoice(totalTasks);

            taskList.markTaskAsComplete(taskToMark);
        }
        else {
            System.out.println("there are no tasks to mark");
        }
    }

    public static void main(String[] args) {
        while(returnValue != 3) {
            printMenu();
            userMenuChoice(3);
            if(returnValue == 1) {
                taskList.setFileName("task-list.txt");
                taskList.createTaskList();
                branchToOperationMenu();
            }
            else if(returnValue == 2) {
                System.out.println("Enter the file name to load: ");
                String fileToLoad = input.nextLine();
                taskList.setFileName(fileToLoad);
                totalTasks = taskList.getTotalTasks();
                branchToOperationMenu();
            }
        }
    }
}