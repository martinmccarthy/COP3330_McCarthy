import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static TaskList taskList = new TaskList();

    public static int handleUserInput(int userInput, int totalOptions)
    {
        ArrayList<Integer> possibleInputs = new ArrayList<>();
        for(int i = 1; i <= totalOptions; i++) {
            possibleInputs.add(i);
        }
        for (int i = 0; i < possibleInputs.toArray().length; i++) {
            if (userInput == possibleInputs.get(i)) {
                return 1;
            }
        }

        return -1;
    }

    public static int getMenuInput(int totalOptions) {
        System.out.print("> ");
        int userInput = scanner.nextInt();
        scanner.nextLine();

        int acceptableAnswer = handleUserInput(userInput, totalOptions);

        while(acceptableAnswer < 0) {
            System.out.println("Invalid input, enter a proper answer: ");
            userInput = scanner.nextInt();
            scanner.nextLine();
            acceptableAnswer = handleUserInput(userInput, totalOptions);
        }

        return userInput;
    }

    public static void printOperationMenu() {
        System.out.println("List Operation Menu\n---------");

        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) mark an item as complete");
        System.out.println("6) unmark an item as complete");
        System.out.println("7) save the current list");
        System.out.println("8) quit to the main menu\n");
    }

    public static void printMainMenu() {
        System.out.println("Main Menu\n---------");

        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit\n");
    }

    public static void branchFromMenu(int userInput) {
        if(userInput == 1) {
            taskList.createTaskList();
        }
        int operationInput = 0;
        while(operationInput != 8) {
            printOperationMenu();
            operationInput = getMenuInput(8);
            if(operationInput == 1) {
                taskList.viewList();
            }
            if(operationInput == 2) {

            }
        }
        taskList.closeTaskList();
    }

    public static void main(String[] args) {

        int quitChoice = 0;
        while(quitChoice != 1) {
            printMainMenu();
            int mainMenuInput = getMenuInput(3);
            if(mainMenuInput == 1 || mainMenuInput == 2) {
                branchFromMenu(mainMenuInput);
            }
            else if(mainMenuInput == 3) {
                quitChoice = 1;
            }
        }
    }
}
