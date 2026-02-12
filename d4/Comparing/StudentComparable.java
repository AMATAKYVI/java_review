package d4.Comparing;

public class StudentComparable implements Comparable<StudentComparable> {

    private String name;
    private int age;

    public StudentComparable(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int compareTo(StudentComparable other) {
        return this.name.compareTo(other.name);
    }

}
