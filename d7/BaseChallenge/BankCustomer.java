package d7.BaseChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankCustomer {

    private static int lastCustomerId = 1_000_000;

    private final String name;
    private final int customerId;
    private final List<BankAccount> accounts = new ArrayList<>();

    public BankCustomer(String name, double savingAmount, double checkingAmount) {
        this.name = name;
        this.customerId = lastCustomerId++;
        this.accounts.add(new BankAccount(BankAccount.AccountType.CHECKING, checkingAmount));
        this.accounts.add(new BankAccount(BankAccount.AccountType.SAVINGS, savingAmount));
    }

    public String getName() {
        return name;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    @Override
    public String toString() {
        String[] acccountStrings = new String[accounts.size()];
        Arrays.setAll(acccountStrings, i -> accounts.get(i).toString());

        return "Customer: %s, ID: %d, Accounts: %s".formatted(name, customerId, String.join(", ", acccountStrings));
    }
}
