package d16;

public class BankAccount {

    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount) {

        try {
            Thread.sleep(100);
        } catch (Exception e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }
        synchronized (this) {
            double originalBalance = balance;
            balance = (int) (originalBalance + amount);
            System.out.println("Deposit: " + amount + ", balance: " + balance);
        }

    }

    public synchronized void withdraw(int amount) {
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }

        double originalBalance = balance;
        if (amount <= balance) {
            balance = (int) (originalBalance - amount);
            System.out.println("Withdraw: " + amount + ", balance: " + balance);
        } else {
            System.out.println("Not enough balance!");
        }
    }

    public int getBalance() {
        return balance;
    }
}
