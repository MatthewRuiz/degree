public class PhoneBookEntry1 {
    private String name;
    private String phoneNumber;

    // constructor
    public PhoneBookEntry1(String a, String b) {
        name = a;
        phoneNumber = b;
    }
    
    public PhoneBookEntry1()
    {
    }

    // getters
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // setters
    public void setName(String a) {
        name = a;
    }

    public void setPhoneNumber(String a) {
        phoneNumber = a;
    }
}