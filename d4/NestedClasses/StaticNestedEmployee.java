package d4.NestedClasses;

import java.util.Comparator;

public class StaticNestedEmployee {

    private String name;
    private int employeeId;
    private int yearStarted;

    public static class EmployeeComparator<T extends StaticNestedEmployee> implements Comparator<StaticNestedEmployee> {

        @Override
        public int compare(StaticNestedEmployee o1, StaticNestedEmployee o2) {

            return o1.getYearStarted() - o2.getYearStarted();
        }

    }

    public StaticNestedEmployee(String name, int employeeId, int yearStarted) {
        this.name = name;
        this.employeeId = employeeId;
        this.yearStarted = yearStarted;
    }

    public String getName() {
        return name;
    }

    public int getYearStarted() {
        return yearStarted;
    }

    @Override
    public String toString() {
        return "StaticNestedEmployee{"
                + "name='" + name + '\''
                + ", employeeId=" + employeeId
                + ", yearStarted=" + yearStarted
                + '}';
    }

}
