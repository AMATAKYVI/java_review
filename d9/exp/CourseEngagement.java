package d9.exp;

import java.time.LocalDate;

record Course(String courseId, String name, String subject) {

    @Override
    public final String toString() {
        return "Course{"
                + "courseId='" + courseId + '\''
                + ", name='" + name + '\''
                + ", subject='" + subject + '\''
                + '}';
    }
}

public class CourseEngagement {

    private Course course;
    private LocalDate enrollmentDate;
    private String engagementType;
    private int lastLecture;
    private LocalDate lastAciityDate;

    public CourseEngagement(Course course, LocalDate enrollmentDate, String engagementType, int lastLecture, LocalDate lastAciityDate) {
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.engagementType = engagementType;
        this.lastLecture = lastLecture;
        this.lastAciityDate = lastAciityDate;
    }

    public Course getCourse() {
        return course;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public LocalDate getLastAciityDate() {
        return lastAciityDate;
    }

}
