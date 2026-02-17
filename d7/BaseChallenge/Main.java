package d7.BaseChallenge;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // System.out.println("Hello world!");

        // BankAccount account = new BankAccount(BankAccount.AccountType.CHECKING, 1000.0);
        // System.out.println(account);
        // BankAccount account2 = new BankAccount(BankAccount.AccountType.SAVINGS, 2000.0);
        // System.out.println(account2);
        BankCustomer customer = new BankCustomer("John Doe", 1000.0, 2000.0);
        System.out.println(customer);

        List<BankAccount> accounts = customer.getAccounts();
        accounts.clear();
        for (BankAccount account : accounts) {
            System.out.println(account);
        }

        accounts.add(new BankAccount(BankAccount.AccountType.CHECKING, 10000000));

        for (BankAccount account : accounts) {
            System.out.println(account);
        }
    }

}
