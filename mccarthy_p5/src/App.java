import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu() {
        App app = new App();
        int choice = 0;
        while(choice != 3) {
            app.printApplicationSelect();
            choice = app.getUserOption(3);
            if(choice == 1) {
                app.openTaskApp();
            }
            else if(choice == 2) {
                app.openContactApp();
            }
            else if(choice == 3) {
                return;
            }
        }
    }

    public void printApplicationSelect() {
        System.out.println("Select Your Application\n" +
                "-----------------------\n" +
                "\n" +
                "1) task list\n" +
                "2) contact list\n" +
                "3) quit");
    }

    public int getUserOption(int totalOptions) {
        Scanner input = new Scanner(System.in);
        int option = -1;
        while(option < 1 || option > totalOptions) {
            try {
                System.out.print("> ");
                option = Integer.parseInt(input.nextLine());
                if(option > totalOptions || option < 1) {
                    System.out.println("Invalid selection, try again");
                }
            }
            catch(NumberFormatException e) {
                System.out.println("Invalid selection, try again");
            }
        }
        return option;
    }

    public void printMainMenu() {
        System.out.println("\nMain Menu\n" +
                "---------\n" +
                "\n" +
                "1) create a new list\n" +
                "2) load an existing list\n" +
                "3) quit");
    }

    public void openTaskApp() {
        TaskApp taskApp = new TaskApp();

    }

    public void openContactApp() {
        ContactApp contactApp = new ContactApp();
        contactApp.openContactListMenu();
    }

    public String getStringInput() {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        return input;
    }
}
