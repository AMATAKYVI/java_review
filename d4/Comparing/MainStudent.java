package d4.Comparing;

import java.util.ArrayList;
import java.util.List;

public class MainStudent {

    public static void main(String[] args) {

        int studentCount = 10;
        List<StudentTester> students
                = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            students.add(new StudentTester());
        }

        // students.add(new LPAStudent());
        //printList(students);
        List<LPAStudent> LPAstudents
                = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            LPAstudents.add(new LPAStudent());
        }
        printList(LPAstudents);
    }

    public static <T> void printList(List<T> students) {
        for (var student : students) {
            System.out.println(student);
        }
        System.out.println();
    }
}
