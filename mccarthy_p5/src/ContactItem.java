public class ContactItem {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    public int checkForValue(String testString) {
        if(testString.equals("")) {
            return 0;
        }
        return 1;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String createContactItem() {
        String contactString = "";
        contactString = "Name: " + firstName + " " + lastName +
                "\n" + "Phone: " + phoneNumber +
                "\n" + "Email: " + emailAddress;

        return contactString;
    }
}
