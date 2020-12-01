import java.time.format.DateTimeFormatter;
import java.time.LocalDate;


public class TaskApp extends App {

    public static TaskList taskList = new TaskList();

    public void openTaskListMenu() {
        int menuChoice = 0;

        while(menuChoice != 3) {
            printMainMenu();
            menuChoice = getUserOption(3);
            if(menuChoice == 1) {
                createNewTaskList();
            }
            else if(menuChoice == 2) {
                loadTaskList();
            }
            else if(menuChoice == 3) {
                return;
            }
        }
    }

    public void createNewTaskList() {
        TaskList taskList = new TaskList();
        taskList.setFileName("new-task-list.txt");
        taskList.createTaskList();
        int choice = 0;

        while(choice != 8) {
            printListOperationMenu();
            choice = getUserOption(8);
            if(choice == 8)
                return;
            else
                branchFromTaskList(choice, taskList);
        }
    }

    public void loadTaskList() {
        TaskList taskList = new TaskList();
        System.out.print("Enter file name to open: ");
        String fileName = getStringInput();
        taskList.setFileName(fileName);
        taskList.totalTasks = taskList.getTotalTasks();

        int choice = 0;
        while(choice != 8) {
            printListOperationMenu();
            choice = getUserOption(8);
            if(choice == 8) {
                return;
            }
            else
                branchFromTaskList(choice, taskList);
        }
    }

    public void printListOperationMenu() {
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

    public void branchFromTaskList(int choice, TaskList list) {
        taskList = list;
        switch(choice) {
            case 1:
                list.readTaskList();
                break;
            case 2:
                /* items in taskItems are stored in order listed in menu input, 0 = title, 1 = desc, 2 = due date */
                String[] taskItems = getTaskInput();
                list.addAnItem(taskItems[0], taskItems[1], taskItems[2]);
                break;
            case 3:
                if(list.totalTasks == 0) {
                    System.out.println("There are no contacts to edit, try adding some!");
                    break;
                }
                list.readTaskList();
                System.out.print("\nWhich contact will you edit? ");
                int taskToEdit = getUserOption(list.totalTasks);

                String[] newTaskInfo = getTaskInput();
                list.editATask(taskToEdit, newTaskInfo[0], newTaskInfo[1], newTaskInfo[2]);
                break;
            case 4:
                if(list.totalTasks > 0) {
                    list.readTaskList();
                    System.out.println("Which task will you remove?");
                    int taskToDelete = getUserOption(list.totalTasks);

                    list.deleteTask(taskToDelete);
                }
                else {
                    System.out.println("There are no tasks to delete, try adding some!");
                }
                break;
            case 5:
                if(list.totalTasks > 0) {
                    list.readTaskList();
                    System.out.println("Which task will you mark as complete?");
                    int taskToMark = getUserOption(list.totalTasks);

                    list.markTaskAsComplete(taskToMark);
                }
                break;
            case 6:
                if(list.totalTasks > 0) {
                    list.readTaskList();
                    System.out.println("Which task will you unmark as complete?");
                    int taskToUnmark = getUserOption(list.totalTasks);
                    list.unmarkTaskAsComplete(taskToUnmark);
                }
                break;
            case 7:
                System.out.print("Enter list name: ");
                list.renameFile(getNewListName());
                break;
            default:
                System.out.println("an unknown error occurred");
                break;
        }
    }

    String getNewListName() {
        String listName = getStringInput();
        if(listName.length() == 0) {
            System.out.print("Invalid file name, try again: ");
            getNewListName();
        }

        return listName;
    }

    String[] getTaskInput() {
        System.out.print("Task title: ");
        String title = getTitleInput();
        System.out.print("Description: ");
        String description = getStringInput();
        System.out.print("Task due date: (YYYY-MM-DD): ");
        String dueDate = getDueDateInput();

        return new String[] {title, description, dueDate};
    }

    public String getTitleInput() {
        String title = getStringInput();
        if(TaskItem.titleCheck(title) != 0) {
            System.out.print("Invalid title entry, try again: ");
            getTitleInput();
        }

        return title;
    }

    public String getDueDateInput() {
        String dueDate = "";
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            dueDate = getStringInput();
            LocalDate returnDate = LocalDate.parse(dueDate, formatter);
            dueDate = returnDate.toString();
            if(TaskItem.dateCheck(dueDate) != 0) {
                getDueDateInput();
            }
        }
        catch (Exception e) {
            System.out.print("Invalid date input, re-enter with format YYYY-MM-DD: ");
            getDueDateInput();
        }

        return dueDate;
    }
}
