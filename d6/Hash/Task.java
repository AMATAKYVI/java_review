package d6.Hash;

enum Role {
    MANAGER, DEVELOPER, TESTER, LEAD;

    @Override
    public String toString() {
        return name();
    }
}

record Person(String name, int age, Role role) {

    public String toString() {
        return "Person{"
                + "name='" + name + '\''
                + ", age=" + age
                + ", role=" + role
                + '}';
    }
}

enum Status {
    TODO, IN_PROGRESS, DONE
}

enum Priority {
    LOW, MEDIUM, HIGH
}

public class Task implements Comparable<Task> {

    @Override
    public int compareTo(Task o) {
        // sort by project name and description
        int result = this.projectName.compareTo(o.projectName);
        if (result != 0) {
            return result;
        }
        result = this.description.compareTo(o.description);
        if (result != 0) {
            return result;
        }
        return 0;
    }

    private String projectName;
    private Person person;
    private String description;
    private Status status;
    private Priority priority;

    public Task(String projectName, Person person, String description, Status status, Priority priority) {
        this.projectName = projectName;
        this.person = person;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{"
                + "projectName='" + projectName + '\''
                + ", person=" + person
                + ", description='" + description + '\''
                + ", status=" + status
                + ", priority=" + priority
                + '}';
    }

}
