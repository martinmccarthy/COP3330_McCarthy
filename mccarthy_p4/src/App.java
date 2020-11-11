public class App {
    public static void branchUserInput(int userInput) {
        if(userInput == 1) {
            TaskList taskList = new TaskList();
            System.out.println("new task list has been created");

            taskList.createOperationMenu();

            int secondUserInput = taskList.getMenuInput();

        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.createMainMenu();

        int userInput = menu.getMenuInput();
        branchUserInput(userInput);
    }
}
