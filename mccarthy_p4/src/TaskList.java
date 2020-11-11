import java.util.Scanner;

public class TaskList {
    private Menu menu = new Menu();

    public int getMenuInput() {
        Scanner scan = new Scanner(System.in);

        System.out.print("> ");
        int userInput = scan.nextInt();
        scan.nextLine();

        int acceptableAnswer = menu.handleUserInput(userInput, 8);

        while(acceptableAnswer < 0) {
            System.out.println("Invalid input, enter a proper answer: ");
            userInput = scan.nextInt();
            scan.nextLine();
            acceptableAnswer = menu.handleUserInput(userInput, 8);
        }

        return userInput;
    }

    public void createOperationMenu() {
        System.out.println("List Operation Menu\n---------");
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) mark an item as complete");
        System.out.println("6) unmark an item as complete");
        System.out.println("7) save the current list");
        System.out.println("8) quit to the main menu");
    }
}
