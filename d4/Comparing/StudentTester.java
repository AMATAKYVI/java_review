package d4.Comparing;

import java.util.Random;

public class StudentTester {

    private String name;
    private String course;
    private int yearStarted;

    protected static Random random = new Random();

    private static String[] firstNames = {"Ann", "Bill", "Cathy", "Diane", "Ed", "Fiona", "George", "Helen", "Iris", "Jack"};

    private static String[] courses = {"Biology", "Chemistry", "Computer Science", "English", "French", "Geography", "History", "Maths", "Physics", "Spanish"};

    public StudentTester() {
        int lastNameIndex = random.nextInt(65, 91);
        name = firstNames[random.nextInt(5)];
        course = courses[random.nextInt(3)];
        yearStarted = random.nextInt(2000, 2020);

    }

    @Override
    public String toString() {
        return "Student{"
                + "name='" + name + '\''
                + ", course='" + course + '\''
                + ", yearStarted=" + yearStarted
                + '}';
    }

    public int getYearStarted() {
        return yearStarted;
    }
}
