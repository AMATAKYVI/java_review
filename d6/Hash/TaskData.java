package d6.Hash;

public class TaskData {

    public static void main(String[] args) {

        //five projects
        String[] projectsName = {"Fly Dragon", "Dynomite Boat", "Ride a Bike", "Fly a Plane", "Fly a Helicopter"};

        //description
        String[] description = {"We fly the dragon off the map", "Boat at the speed of light", "Bike that can take you off the ground", "Just regular plane", "No wings, but can fly helicopters"};

        //five developers Person
        Person[] developers = new Person[5];
        developers[0] = new Person("John", 23, Role.DEVELOPER);
        developers[1] = new Person("Bob", 53, Role.DEVELOPER);
        developers[2] = new Person("Alice", 34, Role.DEVELOPER);
        developers[3] = new Person("Mark", 26, Role.DEVELOPER);
        developers[4] = new Person("Tom", 45, Role.DEVELOPER);

        // loop this to task
        for (int i = 0; i < projectsName.length; i++) {
            Task task = new Task(projectsName[i], developers[i], description[i], Status.TODO, Priority.LOW);
            System.out.println(task);
        }

    }
}
