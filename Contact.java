public class Contact {

    private String name;
    private int phoneNumber;
    private String email;
    public Contact(String name, Integer phoneNumber, String email) {
        this.name = name;
        this.phoneNumber =phoneNumber;
        this.email= email;
    }
    public String getName() {return name;}
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail() {
        return email;
    }

    public void updatePhoneNumber(int phoneNumber) {this.phoneNumber= phoneNumber;}
    public void updateEmail(String email) {this.email= email;}
}
