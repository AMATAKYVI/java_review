package d4.AnnonymousClass;

import java.util.List;

record Employee(String name, int id, int salary) {

}

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee("John", 1, 1000),
                new Employee("Jane", 2, 2000),
                new Employee("Jack", 3, 3000)
        );

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
