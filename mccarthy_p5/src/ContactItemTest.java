import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ContactItemTest {
    @Test
    public void creatingContactFailsWithNoInfo() {
        ContactItem newItem = new ContactItem();
        newItem.setFirstName("");
        newItem.setLastName("");
        newItem.setPhoneNumber("");
        newItem.setEmailAddress("");

        assertEquals(0, newItem.checkForValue(newItem.getFirstName() + newItem.getLastName() + newItem.getPhoneNumber() + newItem.getEmailAddress()));
    }

    @Test
    public void creatingContactSucceedsWithOnlyFirstName() {
        ContactItem newItem = new ContactItem();
        newItem.setFirstName("test");
        newItem.setLastName("");
        newItem.setPhoneNumber("");
        newItem.setEmailAddress("");

        assertEquals(1, newItem.checkForValue(newItem.getFirstName() + newItem.getLastName() + newItem.getPhoneNumber() + newItem.getEmailAddress()));
    }

    @Test
    public void creatingContactSucceedsWithOnlyLastName() {
        ContactItem newItem = new ContactItem();
        newItem.setFirstName("");
        newItem.setLastName("test");
        newItem.setPhoneNumber("");
        newItem.setEmailAddress("");

        assertEquals(1, newItem.checkForValue(newItem.getFirstName() + newItem.getLastName() + newItem.getPhoneNumber() + newItem.getEmailAddress()));
    }

    @Test
    public void creatingContactSucceedsWithOnlyPhoneNumber() {
        ContactItem newItem = new ContactItem();
        newItem.setFirstName("test");
        newItem.setLastName("");
        newItem.setPhoneNumber("954-555-5555");
        newItem.setEmailAddress("");

        assertEquals(1, newItem.checkForValue(newItem.getFirstName() + newItem.getLastName() + newItem.getPhoneNumber() + newItem.getEmailAddress()));
    }

    @Test
    public void creatingContactSucceedsWithOnlyEmail() {
        ContactItem newItem = new ContactItem();
        newItem.setFirstName("");
        newItem.setLastName("");
        newItem.setPhoneNumber("");
        newItem.setEmailAddress("test@fbi.gov");

        assertEquals(1, newItem.checkForValue(newItem.getFirstName() + newItem.getLastName() + newItem.getPhoneNumber() + newItem.getEmailAddress()));
    }

    @Test
    public void creatingEmailFailsWithInvalidInput() {
        ContactItem contactItem = new ContactItem();
        contactItem.setEmailAddress("test");
        ContactApp app = new ContactApp();
        assertEquals(false, app.checkEmailValidity(contactItem.getEmailAddress()));
    }
}
