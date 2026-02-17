package d7.UnmodifiableViews;

import java.util.ArrayList;
import java.util.List;

record Student(String name) {

}

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        StringBuilder billsNotes = new StringBuilder("Bill Struggles with generics");

        List<Student> students = new ArrayList<>(List.of(new Student("John"), new Student("Jane")));

        students.forEach(System.out::println);
    }
}
