package d6.Hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashExp {

    public static void main(String[] args) {
        System.out.println("--------");

        String aText = "hello";
        String bText = "hello";
        String cText = "Hello";

        System.out.println(aText.equals(bText));
        System.out.println(aText.equals(cText));

        // System.out.println(aText.hashCode());
        // System.out.println(bText.hashCode());
        // System.out.println(cText.hashCode());
        List<String> hello = Arrays.asList(aText, bText, cText);

        System.out.println("--------");

        hello.forEach(s -> System.out.println(s.hashCode()));
        Set<String> mySet = new HashSet<>();
        mySet.add(aText);
        mySet.add(bText);
        mySet.add(cText);
        System.out.println("--------");

        mySet.forEach(s -> System.out.println(s.hashCode()));

    }
}
