package consoleproject;
import java.util.Objects;
import java.util.Scanner;

public class Database {
    private static Customer[] customers = new Customer[100];

    private static Card[] cards = new Card[100];
    private static int lastIndex1 = 0;
    private static int lastIndex2 = 0;
    private static int newIndex1 = 0;
    private static int newIndex2 = 0;

    public static void addCardToList(Card card) {
        cards[lastIndex1++] = card;
    }
    public static void addCustomerToList(Customer customer) {
        customers[lastIndex2++] = customer;
    }
    public  static void printCardsOfCustomers(){
        for (Card card : cards){
            if (card != null){
                System.err.println(card.getHolderName() + " " + card.getPAN() + " " + card.getPIN() + " " + card.getCVV());
            }
        }
    }
    public static void printCustomers() {
        for (Customer customer : customers) {
            if (customer != null) {
                System.err.println(customer.getName() + " " + customer.getSurname());
            }
        }
    }
    public static Card[] getCards() {
        return cards;
    }
    public static void setCards(Card[] cards) {
        Database.cards = cards;
    }

    public static Customer[] getCustomers() {
        return customers;
    }

    public static void setCustomers(Customer[] customers) {
        Database.customers = customers;
    }
    public static void deleteCustomer(String name, String surname) {
        String fullName = name + " " + surname;
        Customer[] customers = Database.getCustomers();
        Customer[] new_customers = new Customer[lastIndex2 - 1];
        for (int i = 0, k = 0; i < lastIndex2; i++) {
            if (customers[i] != null) {
                if (!Objects.equals(customers[i].getFullName(), fullName)) {

                    new_customers[k] = customers[i];
                    k++;
                }
            }
            for (Customer new_customer : new_customers) {
                if (new_customer != null) {
                    System.err.println(new_customer.getName() + " " + new_customer.getSurname());
                }
            }
        }
    }
    private static Customer[] blockedCustomers = new Customer[100];
    private static Customer[] unblockedCustomers = new Customer[100];
    public static Customer[] getBlockedCustomers() {
        return blockedCustomers;
    }

    public static void setBlockedCustomers(Customer[] blockedCustomers) {
        Database.blockedCustomers = blockedCustomers;
    }

    public static void blockCustomer(String name, String surname){
        String fullName = name + " " + surname;
        for (Customer customer : customers) {
            if (customer != null && customer.getFullName().equals(fullName)) {
                blockedCustomers[newIndex1++] = customer;
                return;
            }
        }
    }

    public static void printBlockedCustomers(){
        for (Customer blockedCustomer : blockedCustomers){
            if (blockedCustomer != null){
                System.err.println(blockedCustomer.getName() + " " + blockedCustomer.getSurname());
            }
        }
    }
    public static void unblockCustomer(String name, String surname){
        String fullName = name + " " + surname;
        for (int i = 0; i < newIndex1; i++) {
            if (blockedCustomers[i] != null && blockedCustomers[i].getFullName().equals(fullName)){
                unblockedCustomers[newIndex2++] = blockedCustomers[i];
                for (int j = i; j < newIndex1 - 1; j++) {
                    blockedCustomers[j] = blockedCustomers[j + 1];
                }
                blockedCustomers[newIndex1 - 1] = null;
                newIndex1--;
                return;
            }
        }
    }

    public static void printUnblockedCustomer(){
        for (Customer unblockedCustomer : unblockedCustomers){
            if (unblockedCustomer != null){
                System.err.println(unblockedCustomer.getName() + " " + unblockedCustomer.getSurname());
            }
        }
    }
}