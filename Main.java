import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ContactBook book= new ContactBook();

        while(true) {
            String command = scanner.nextLine();

            if(command.equals("Goodbye!")) {
                scanner.close();
                return;
            } else if (command.equals("AC")) {
                String name = scanner.nextLine();
                String phoneNumber = scanner.nextLine();
                String email = scanner.nextLine();
                try{
                    book.addContact(name, phoneNumber, email);
                    System.out.println("Contact added.");}
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (command.equals("LC")) {
                try {
                    Iterator<Contact> iterator = book.getContacts();
                    while (iterator.hasNext()) {
                        Contact current = iterator.next();
                        System.out.println("Registered people:");
                        System.out.println(current.getName() + ";" + current.getPhoneNumber() + ";" + current.getEmail());
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }else if(command.equals("RC")){
                String nameRemoved = scanner.nextLine();
                try {
                    book.removeContact(nameRemoved);}
                catch (Exception e) {
                    System.out.println(e.getMessage());}
            }else if(command.equals("GP")){
                String name = scanner.nextLine();
                try {
                    System.out.print(book.getPhone((name)));}
                catch (Exception e) {
                    System.out.println(e.getMessage());}
            }else if(command.equals("GE")){
                String name = scanner.nextLine();
                try {
                    System.out.print(book.getMail((name)));}
                catch (Exception e) {
                    System.out.println(e.getMessage());}
            }else if(command.equals("GN")){
                int phone = scanner.nextInt();
                try {
                    System.out.print(book.lookNameByPhone(phone));}
                catch (Exception e) {
                    System.out.println(e.getMessage());}
            }else if(command.equals("SP")){
                String name = scanner.nextLine();
                String newPhone = scanner.nextLine();
                try {
                    book.updatePhone(name, newPhone);
                    System.out.println("Contact updated");}
                catch (Exception e) {
                    System.out.println(e.getMessage());}
            }else if(command.equals("SE")){
                String name = scanner.nextLine();
                String newEmail = scanner.nextLine();
                try {
                    book.updateEmail(name, newEmail);
                    System.out.println("Contact updated");}
                catch (Exception e) {
                    System.out.println(e.getMessage());}
            } else if (command.equals("EP")) {
                if(book.equalPhoneNumbers()){
                    System.out.println("There are contacts that share phone numbers.");
                }else{
                    System.out.println("All contacts have different phone numbers.");
                }
            }
        }
    }
}