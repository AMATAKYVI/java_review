package d5.LambdaExp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    record Person(String name, int age) {

        @Override
        public String toString() {
            return "Person{"
                    + "name='" + name + '\''
                    + ", age=" + age
                    + '}';
        }
    }

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("Lucy", 23),
                new Person("AJohn", 25),
                new Person("Jane", 22)
        ));

        people.forEach(p -> System.out.println(p));
        people.sort((o1, o2) -> o1.name.compareTo(o2.name));
        people.forEach(p -> System.out.println(p));

    }
}
