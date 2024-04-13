package consoleproject;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){

        while (true){
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option){
                case 1: addCustomerToList(); break;
                case 2: addCardToList(); break;
                case 3: printCustomers(); break;
                case 4: printCardsOfCustomers(); break;
                case 5: deleteCustomer(); break;
                case 6: blockCustomer(); break;
                case 7: printBlockedCustomers(); break;
                case 8: unblockCustomer(); break;
                case 9: printUnblockedCustomer(); break;
                case 10:
                    System.exit(0);
            }
        }
    }
    public static void printMenu(){
        System.out.println("1. Add a customer"+
                "\n2. Create a new Card"+
                "\n3. See the list of customers"+
                "\n4. See the list of the cards" +
                "\n5. Delete a customer"+
                "\n6. Block the customer"+
                "\n7. See the list of blocked customers"+
                "\n8. Unblock the customer" +
                "\n9. See the list of unblocked customers" +
                "\n10. Quit the programme");
    }
    public static Customer createCustomer(Scanner scanner){

        System.err.print("Name of the customer: ");
        String name = scanner.next();
        System.err.print("Surname of the customer: ");
        String surname = scanner.next();
        System.err.print("Birth date of the customer: ");
        String birthDate = scanner.next();
        Customer customer = new Customer(name, surname, birthDate);
        return customer;
    }
    public static Card createCard(Scanner scanner) {
        try {
            System.out.print("Name of the customer: ");
            String name = scanner.next();
            System.out.print("Surname of the customer: ");
            String surname = scanner.next();

            for (Customer i : Database.getCustomers()) {
                if (name.equals(i.getName()) && surname.equals(i.getSurname())) {
                    System.err.println("\nHolder name on the card: ");
                    String holderName = scanner.next();
                    System.err.print("PAN code on the card: ");
                    String PAN = scanner.next();
                    System.err.print("PIN code of the card: ");
                    long PIN = scanner.nextLong();
                    System.err.print("CVV on the card: ");
                    long CVV = scanner.nextLong();
                    Card card = new Card(i, holderName, PAN, PIN, CVV);
                    return card;
                }
            }
            throw new NullPointerException("Customer not found.");
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static void addCardToList(){
        Scanner scanner = new Scanner(System.in);
        Card card = createCard(scanner);
        Database.addCardToList(card);}

    public static void addCustomerToList(){
        Scanner scanner = new Scanner(System.in);
        Customer customer = createCustomer(scanner);
        Database.addCustomerToList(customer);
    }
    public static void deleteCustomer(){
        Scanner scanner = new Scanner(System.in);
        System.err.print("Enter name of the customer you want to delete: ");
        String name = scanner.next();
        System.err.print("Enter surname of the customer you want to delete: ");
        String surname = scanner.next();
        Database.deleteCustomer(name, surname);
    }
    public static void printCustomers(){
        Database.printCustomers();
    }
    public static void printCardsOfCustomers(){
        Database.printCardsOfCustomers();
    }
    public static void blockCustomer(){
        Scanner scanner = new Scanner(System.in);
        System.err.print("Enter name of the customer you want to block: ");
        String name = scanner.next();
        System.err.print("Enter surname of the customer you want to block: ");
        String surname = scanner.next();
        Database.blockCustomer(name, surname);
    }
    public static void printBlockedCustomers(){
        Database.printBlockedCustomers();
    }
    public static void unblockCustomer(){
        Scanner scanner = new Scanner(System.in);
        System.err.print("Enter name of the customer you want to unblock: ");
        String name = scanner.next();
        System.err.print("Enter surname of the customer you want to unblock: ");
        String surname = scanner.next();
        Database.unblockCustomer(name, surname);
    }
    public static void printUnblockedCustomer(){
        Database.printUnblockedCustomer();
    }
}

