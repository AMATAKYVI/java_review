package d2.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

record GroceryItem(String name, double price) {

    public GroceryItem(String name, double price) {

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

class BankAccount {

    private String accountNumber;
    private Double balance;
    private String accountHolderName;

    public BankAccount(String accountNumber, Double balance, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolderName = accountHolderName;
    }

    public void withdraw(Double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
    }

    public void deposit(Double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative");
        }
        balance += amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    @Override
    public String toString() {
        return "BankAccount{"
                + "accountNumber='" + accountNumber + '\''
                + ", balance=" + balance
                + ", accountHolderName='" + accountHolderName + '\''
                + '}';
    }
}

public class ConsoleShoppingGame {

    public static void main(String[] args) {

        BankAccount amatakAccount = new BankAccount("123456789", 1000.0, "Amatak Yvi");
        System.out.println(amatakAccount);
        ArrayList<GroceryItem> shoppingList = new ArrayList<>(
                List.of(
                        new GroceryItem("Milk", 2.99),
                        new GroceryItem("Bread", 1.99),
                        new GroceryItem("Eggs", 3.49),
                        new GroceryItem("Cheese", 4.99),
                        new GroceryItem("Butter", 1.49),
                        new GroceryItem("Jam", 2.49),
                        new GroceryItem("Fruits", 5.99),
                        new GroceryItem("Vegetables", 4.99),
                        new GroceryItem("Meat", 9.99),
                        new GroceryItem("Fish", 7.99)
                )
        );

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> cart = new ArrayList<>();
        while (true) {
            System.out.println("Welcome to the Console Shopping Game!");
            System.out.println("Your current balance is: $" + amatakAccount.getBalance());
            System.out.println("Here is your shopping list:");
            System.out.println("Make your selection by entering the corresponding number: " + " and here your cart items you purchase: " + cart);
            for (int i = 0; i < shoppingList.size(); i++) {
                System.out.println(i + 1 + ". " + shoppingList.get(i));
            }
            int selection = scanner.nextInt();
            if (selection < 1 || selection > shoppingList.size()) {
                System.out.println("Invalid selection. Please try again.");
                continue;
            }
            GroceryItem selectedItem = shoppingList.get(selection - 1);
            if (amatakAccount.getBalance() < selectedItem.price()) {
                System.out.println("Insufficient funds.");
                continue;
            }
            amatakAccount.withdraw(selectedItem.price());
            cart.add(selectedItem.name());
            System.out.println("You have purchased " + selectedItem.name() + " for $" + selectedItem.price());
            System.out.println("Your current balance is: $" + amatakAccount.getBalance());
            System.out.println("Do you want to continue shopping? (yes/no)");
            String continueShopping = scanner.next();
            if (!continueShopping.equalsIgnoreCase("yes")) {
                System.out.println("Thank you for shopping! Your final cart items: " + cart);
                System.out.println("Your final balance is: $" + amatakAccount.getBalance());
                break;
            }
        }
    }
}
