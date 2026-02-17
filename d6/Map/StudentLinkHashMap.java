package d6.Map;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

record Course(String courseId, String name, String subject) {

}

record Purchase(String courseId, int studentId, double price, int yr, int dayOfYear) {

    public LocalDate date() {
        return LocalDate.ofYearDay(yr, dayOfYear);
    }
}

public class StudentLinkHashMap {

    public static int lastId = 1;
    private String name;
    private int id;
    private List<Course> courseList;

    public StudentLinkHashMap(String name, List<Course> courseList) {
        this.name = name;
        this.courseList = courseList;
        id = lastId++;
    }

    public StudentLinkHashMap(String name, Course course) {
        this(name, new ArrayList<>(List.of(course)));
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void addCourse(Course course) {
        courseList.add(course);
    }

    public String toString() {
        String[] courseNames = new String[courseList.size()];
        Arrays.setAll(courseNames, i -> courseList.get(i).name());
        return "[%d] : %s".formatted(id, String.join(", ", courseNames));
    }

}
