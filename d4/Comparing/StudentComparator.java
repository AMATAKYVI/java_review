package d4.Comparing;

import java.util.Comparator;

public class StudentComparator implements Comparator<String> {

    private String name;

    public StudentComparator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
