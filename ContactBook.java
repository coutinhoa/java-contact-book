import java.util.ArrayList;
import java.util.Iterator;

public class ContactBook {
    private ArrayList<Contact> contacts;

    public ContactBook() {
        contacts=new ArrayList<Contact>();
    }
    public void addContact(String name, Integer phoneNumber, String email) throws Exception{
        Contact contact = new Contact(name, phoneNumber, email);

        for(Contact element : contacts) {
            if (element.getName().equals(name.trim())) {
                throw new Exception("Contact already exists.");
            }
        }

        contacts.add(contact);
        contacts.size();
    }
    public Iterator<Contact> getContacts() throws Exception{
        if(contacts.size()==0){
            throw new Exception ("Contact book empty.");
        }
        return contacts.iterator();
    }

    public void removeContact(String name) throws Exception{
        for(Contact element : contacts) {
            if (element.getName().equals(name)) {
                contacts.remove(element);
                throw new Exception("Contact removed.");
            }
        }
        throw new Exception("Contact doesn't exist.");
    }

    public int getPhone(String name) throws Exception{
        for(Contact element : contacts) {
            if (element.getName().equals(name)) {
                return element.getPhoneNumber();
            }
        }
        throw new Exception("Contact doesn't exist.");
    }
    public String getMail(String name) throws Exception{
        for(Contact element : contacts) {
            if (element.getName().equals(name)) {
                return element.getEmail();
            }
        }
        throw new Exception("Contact doesn't exist.");
    }

    public String lookNameByPhone(int phoneNumber) throws Exception{
        for(Contact element : contacts) {
            if (element.getPhoneNumber()==phoneNumber) {
                return element.getName();
            }
        }
        throw new Exception("Phone number does not exist.");
    }

    public void updatePhone(String name, int newNumber) throws Exception{
        for(Contact element : contacts) {
            if (element.getName().equals(name)) {
                element.updatePhoneNumber(newNumber);
            }
        }
        throw new Exception("Contact doesn't exist.");
    }

    public void updateEmail(String name, String newEmail) throws Exception{
        for(Contact element : contacts) {
            if (element.getName().equals(name)) {
                element.updateEmail(newEmail);
            }
        }
        throw new Exception("Contact doesn't exist.");
    }

}
