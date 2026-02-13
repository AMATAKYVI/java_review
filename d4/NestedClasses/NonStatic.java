package d4.NestedClasses;

import java.util.Comparator;

public class NonStatic extends StaticNestedEmployee {

    private String store;

    public NonStatic(String name, int employeeId, int yearStarted) {
        super(name, employeeId, yearStarted);
    }

    public NonStatic(String name, int employeeId, int yearStarted, String store) {
        super(name, employeeId, yearStarted);
        this.store = store;
    }

    public class StoreComparator<T extends NonStatic> implements Comparator<NonStatic> {

        @Override
        public int compare(NonStatic o1, NonStatic o2) {
            return o1.store.compareTo(o2.store);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", store=" + store;
    }
}
