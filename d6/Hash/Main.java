package d6.Hash;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println("--------");
        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");
        // printData("emails", emails);
        // printData("phones", phones);
        // printData("Merged", ContactData.mergeData(emails, phones));

        //Set
        Set<Contact> emailsSet = new HashSet<>(emails);
        Set<Contact> phonesSet = new HashSet<>(phones);
        // printData("emailsSet", emailsSet);
        //  printData("phonesSet", phonesSet);
        // printData("MergedSet", ContactData.mergeData(emailsSet, phonesSet));

        Set<Contact> unionAB = new HashSet<>( // emailsSet.stream().map(c -> c.mergeContactData(new Contact(c.getName()))).toList()
                );
        unionAB.addAll(emailsSet);
        printData("unionAB", unionAB);

        //intersection
        Set<Contact> intersectionAB = new HashSet<>(emailsSet);
        intersectionAB.retainAll(phonesSet);
        printData("intersectionAB", intersectionAB);

        //difference
        Set<Contact> differenceAB = new HashSet<>(emailsSet);
        differenceAB.removeAll(phonesSet);
        printData("differenceAB", differenceAB);

    }

    public static void printData(String header, Collection<Contact> contacts) {
        System.out.println("--------");
        System.out.println(header);
        System.out.println("--------");
        contacts.forEach(System.out::println);
    }
}
