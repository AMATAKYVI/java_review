package d7.BaseChallenge;

import java.util.Arrays;
import java.util.List;

record Person(String name, String dob, Person[] kids) {

    public Person[] getKids() {
        for (Person kid : kids) {
            System.out.println("------ " + kid);
        }
        return kids;
    }
}

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

        Person jame = new Person("Jame", "2000-01-01", null);
        Person jame2 = new Person("Jame 2", "2000-01-01", null);
        Person emma = new Person("Emma", "2000-01-01", null);
        Person tony = new Person("Tony", "2000-01-01", new Person[]{jame, jame2, emma});
        Person tom = new Person("Tom", "2000-01-01", null);

        Person[] persons = {jame, jame2, emma, tony, tom};

        Person[] personsCopy = Arrays.copyOf(persons, persons.length);

        Person[] personsCopyDeep = new Person[5];

        for (int i = 0; i < personsCopyDeep.length; i++) {
            personsCopyDeep[i] = new Person(persons[i].name(), persons[i].dob(), persons[i].kids());
        }

        for (Person person : personsCopy) {
            System.out.println(person);

            if (person.kids() != null) {
                System.out.println("this is the kids:");
                person.getKids();
            }
        }
    }

}
