import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    int totalContacts;
    String listName;

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getListName() {
        return listName;
    }

    void createContactList() {
        try {
            File contactList = new File(listName);
            System.out.println("new contact list has been created");
            FileWriter writer = new FileWriter(contactList, false);
            writer.write("Current Contacts\n" +
                    "-------------\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error occurred");
            e.printStackTrace();
        }

        totalContacts = 0;
    }

    void viewContactList() {
        try{
            File file = new File(listName);
            Scanner reader = new Scanner(file);
            while(reader.hasNext()) {
                String line = reader.nextLine();
                System.out.println(line);
            }
        } catch(FileNotFoundException e) {
            System.out.println("Error occurred, could not open file for viewing");
            e.printStackTrace();
        }
    }

    void addAnItem(String firstName, String lastName, String phoneNumber, String emailAddress) {
        String testForNull = firstName + lastName + phoneNumber + emailAddress;
        if(testForNull.length() == 0) {
            System.out.println("Empty contact, item not created.");
            return;
        }

        ContactItem newItem = new ContactItem();
        totalContacts++;

        newItem.setFirstName(firstName);
        newItem.setLastName(lastName);
        newItem.setPhoneNumber(phoneNumber);
        newItem.setEmailAddress(emailAddress);

        String itemString = totalContacts + ")" + " " + newItem.createContactItem() + "\n";
        printNewItemToList(itemString);
    }

    void printNewItemToList(String itemString) {
        try {
            File file = new File(listName);
            FileWriter writer = new FileWriter(file, true);
            writer.write(itemString);

            writer.close();
        }
        catch(IOException e) {
            System.out.println("could not write to file");
            e.printStackTrace();
        }
    }

    public void editContactList(int contactToEdit, String newContactString) {
        ArrayList<String> lines = new ArrayList<String>();

        File file = new File(listName);

        String line = "";

        char c = (char)contactToEdit;
        try{
            Scanner reader = new Scanner(file);
            while(reader.hasNext()) {
                line = reader.nextLine();
                if(line.charAt(0) == c) {
                    line = newContactString;
                }
                lines.add(line);
            }
            FileWriter writer = new FileWriter(listName);
            for(String str: lines) {
                writer.write(str + System.lineSeparator());
            }
            reader.close();
            writer.close();
        }
        catch(Exception e) {
            System.out.println("could not write to/read file");
            e.printStackTrace();
        }
    }
}