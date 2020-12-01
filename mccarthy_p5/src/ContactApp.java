import java.util.StringTokenizer;

public class ContactApp extends App {
    public void openContactListMenu() {
        int menuChoice = 0;

        while(menuChoice != 3) {
            printMainMenu();
            menuChoice = getUserOption(3);
            if(menuChoice == 1) {
                createNewContactList();
            }
            else if(menuChoice == 3) {
                return;
            }
        }
        /*ContactList contactList = new ContactList();
        printContactMenu();
        int choice = getUserOption(6);
        branchFromContactList(choice);*/
    }

    public void createNewContactList() {
        ContactList contactList = new ContactList();
        contactList.setListName("new-contact-list.txt");
        contactList.createContactList();
        int choice = 0;

        while(choice != 6) {
            printContactMenu();
            choice = getUserOption(6);
            if(choice == 6)
                return;
            else
                branchFromContactList(choice, contactList);
        }
    }

    public void printContactMenu() {
        System.out.println("List Operation Menu\n" +
                "---------\n" +
                "\n" +
                "1) view the list\n" +
                "2) add an item\n" +
                "3) edit an item\n" +
                "4) remove an item\n" +
                "5) save the current list\n" +
                "6) quit to the main menu");
    }

    public void branchFromContactList(int choice, ContactList list) {
        switch(choice) {
            case 1:
                list.viewContactList();
                break;
            case 2:
                /* items in contactItems are stored in order listed in menu input, 0 = fName, 1 = lName, 2 = phne#, 3 = email */
                String[] contactItems = getContactInput();
                list.addAnItem(contactItems[0], contactItems[1], contactItems[2], contactItems[3]);
                break;
            case 3:
                if(list.totalContacts == 0) {
                    System.out.println("There are no contacts to edit, try adding some!");
                    break;
                }
                list.viewContactList();
                System.out.print("\nWhich contact will you edit? ");
                int taskToEdit = getUserOption(list.totalContacts);

                String[] newContactInfo = getContactInput();
                String newContactString = "Name: " + newContactInfo[0] + " " + newContactInfo[1] +
                        "\n" + "Phone: " + newContactInfo[2] +
                        "\n" + "Email: " + newContactInfo[3];

                list.editContactList(taskToEdit, newContactString);
                break;
            case 4:
                System.out.println("remove an item");
                break;
            case 5:
                System.out.println("save the current list");
                break;
            default:
                System.out.println("an unknown error occurred");
                break;
        }
    }

    public String[] getContactInput() {
        System.out.print("First name: ");
        String firstName = getStringInput();
        System.out.print("Last name: ");
        String lastName = getStringInput();
        System.out.print("Phone number (xxx-xxx-xxxx): ");
        String phoneNumber = getPhoneNumber();
        System.out.print("Email address: x@y.z: ");
        String emailAddress = getEmailAddress();

        return new String[] {firstName, lastName, phoneNumber, emailAddress};
    }

    public String getPhoneNumber() {
        String phoneNumber = getStringInput();
        int length = phoneNumber.length();
        if(length != 12 && length != 0){
            System.out.println(phoneNumber.length());
            System.out.println("Invalid input, re-enter (xxx-xxx-xxxx): ");
            getPhoneNumber();
        }

        if(length == 0) {
            return "";
        }

        String delims = "[-]+";
        String[] tokens = phoneNumber.split(delims);
        for(int i = 0; i < tokens.length; i++) {
            if((i == 0 || i == 1) && tokens[i].length() != 3) {
                System.out.println("Invalid input, please re-enter (xxx-xxx-xxxx): ");
                getPhoneNumber();
            }
            try {
                int check = Integer.parseInt(tokens[i]);
                if(check > 9999) {
                    System.out.println("Invalid input, please re-enter (xxx-xxx-xxxx): ");
                    getPhoneNumber();
                }
            } catch(NumberFormatException e) {
                System.out.println("Invalid input, please re-enter (xxx-xxx-xxxx): ");
                e.printStackTrace();
                getPhoneNumber();
            }
        }
        return phoneNumber;
    }

    public boolean checkEmailValidity(String email) {
        /*  */
        if(email.length() == 0) {
            return true;
        }
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

        return email.matches(regex);
    }

    public String getEmailAddress() {
        String email = getStringInput();
        if(checkEmailValidity(email) != true) {
            System.out.println("Invalid input, please re-enter (x@y.z): ");
            getEmailAddress();
        }

        return email;
    }
}
