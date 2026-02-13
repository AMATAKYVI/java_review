package d4.NestedClasses;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<StaticNestedEmployee> employees = new ArrayList<>();

        employees.add(new StaticNestedEmployee("John", 1, 2000));
        employees.add(new StaticNestedEmployee("Jane", 2, 2001));
        employees.add(new StaticNestedEmployee("Jack", 3, 2002));
        employees.add(new StaticNestedEmployee("Jill", 4, 2003));
        employees.add(new StaticNestedEmployee("Joe", 5, 2004));

        employees.sort(new StaticNestedEmployee.EmployeeComparator());
        for (StaticNestedEmployee employee : employees) {
            System.out.println(employee + " ");
        }

    }
}
