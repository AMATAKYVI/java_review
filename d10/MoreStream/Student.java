package d10.MoreStream;

import java.util.Random;

public class Student {

    private static long lastStudentId = 1;
    private final static Random random = new Random();

    private final long studentId;
    private final String name;
    private final String course;
    private final int yearStarted;

    public Student(String name, String course, int yearStarted) {
        this.studentId = lastStudentId++;
        this.name = name;
        this.course = course;
        this.yearStarted = yearStarted;
    }

    public long getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public int getYearStarted() {
        return yearStarted;
    }

}
