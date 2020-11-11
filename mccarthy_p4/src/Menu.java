import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public int handleUserInput(int userInput, int totalOptions)
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


    public int getMenuInput() {
        Scanner scan = new Scanner(System.in);

        System.out.print("> ");
        int userInput = scan.nextInt();
        scan.nextLine();

        int acceptableAnswer = handleUserInput(userInput, 3);

        while(acceptableAnswer < 0) {
            System.out.println("Invalid input, enter a proper answer: ");
            userInput = scan.nextInt();
            scan.nextLine();
            acceptableAnswer = handleUserInput(userInput, 3);
        }

        return userInput;
    }

    public void createMainMenu() {
        System.out.println("Main Menu\n---------");

        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit");
    }
}
