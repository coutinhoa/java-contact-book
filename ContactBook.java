import java.util.ArrayList;
import java.util.Iterator;

public class ContactBook {
    private ArrayList<Contact> contacts;

    public ContactBook() {
        contacts=new ArrayList<Contact>();
    }
    public void addContact(String name, String phoneNumber, String email) throws Exception{
        Contact contact = new Contact(name, phoneNumber, email);

        for(Contact element : contacts) {
            if (element.getName().equals(name.trim())) {
                throw new Exception("Contact already exists.");
            }
        }

        onlyDigits(phoneNumber);

        contacts.add(contact);
        contacts.size();
    }
    public Iterator<Contact> getContacts() throws Exception{
        if(contacts.size()==0){
            throw new Exception ("Contact book empty.");
        }
        return contacts.iterator();
    }

    public Contact getContactByName(String name){
        for(Contact element : contacts) {
            if (element.getName().equals(name)) {
                return element;
            }
        }
        return null;
    }

    public void removeContact(String name) throws Exception{
        Contact contact = getContactByName(name);

        if (contact == null) {
            throw new Exception("Contact doesn't exist.");
        } else {
            contacts.remove(contact);
            throw new Exception("Contact removed.");
        }
    }

    public String getPhone(String name) throws Exception{
        Contact contact = getContactByName(name);
        if (contact == null) {
            throw new Exception("Contact doesn't exist.");
        } else {
            return contact.getPhoneNumber();
        }
    }
    public String getMail(String name) throws Exception{
        Contact contact = getContactByName(name);
        if (contact == null) {
            throw new Exception("Contact doesn't exist.");
        } else {
            return contact.getEmail();
        }
    }

    public String lookNameByPhone(int phoneNumber) throws Exception{
        for(Contact element : contacts) {
            if (element.getPhoneNumber().equals(phoneNumber)) {
                return element.getName();
            }
        }
        throw new Exception("Phone number does not exist.");
    }
    public void updatePhone(String name, String newNumber) throws Exception {
        Contact contact = getContactByName(name);
        onlyDigits(newNumber);
        if (contact == null) {
            throw new Exception("Contact doesn't exist.");
        } else {
            contact.updatePhoneNumber(newNumber);
        }
    }

    public void updateEmail(String name, String newEmail) throws Exception{
        Contact contact = getContactByName(name);
        if (contact == null) {
            throw new Exception("Contact doesn't exist.");
        } else {
            contact.updateEmail(newEmail);
        }
    }

    public boolean equalPhoneNumbers() throws Exception{
        for (int i = 0; i < contacts.size(); i++) {
            for (int j = i + 1 ; j < contacts.size(); j++) {
                if (contacts.get(i).getPhoneNumber() == contacts.get(j).getPhoneNumber()) {
                    return true;
                }
            }
        }
        return false;
    }



    public boolean onlyDigits(String phoneNumber) throws Exception{
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                throw new Exception("Not a valid phone number.");
            }
        }
        return true;
    }

}
