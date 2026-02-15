package d6.Hash;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class LinkedHashSetExp {

    public static void main(String[] args) {

        List<Contact> phones = ContactData.getData("phone");
        Set<Contact> phoneSet = new LinkedHashSet<>(phones);
        Main.printData("phoneSet", phoneSet);

        NavigableSet<Contact> phoneNavSet = new TreeSet<>(phones);
        Main.printData("phoneNavSet", phoneNavSet);

        Contact daffy = new Contact("Daffy Good ");

    }

}
