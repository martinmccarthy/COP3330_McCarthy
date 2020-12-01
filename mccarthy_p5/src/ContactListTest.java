import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactListTest {
    @Test
    public void creatingItemIncreasesTotalCount() {
        ContactList contactList = new ContactList();
        contactList.setListName("test.txt");
        contactList.createContactList();
        assertEquals(0, contactList.totalContacts);
        contactList.addAnItem("test", "", "", "");
        assertEquals(1, contactList.totalContacts);
    }

    @Test
    public void deletingAnItemDecreasesTotalCount() {
        ContactList contactList = new ContactList();
        contactList.setListName("test.txt");
        contactList.createContactList();
        contactList.addAnItem("test", "", "", "");
        assertEquals(1, contactList.totalContacts);
        contactList.deleteTask(1);
        assertEquals(0, contactList.totalContacts);
    }

}
