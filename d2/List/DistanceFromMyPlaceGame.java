package d2.List;

import java.util.LinkedList;
import java.util.Scanner;

record Place(String name, double latitude, double longitude, int distanceFromMyPlace) {

    public Place(String name, double latitude, double longitude, int distanceFromMyPlace) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.distanceFromMyPlace = distanceFromMyPlace;
    }

    @Override
    public String toString() {
        return name + " (Lat: " + latitude + ", Lon: " + longitude + ", Distance: " + distanceFromMyPlace + " km)";
    }
}

public class DistanceFromMyPlaceGame {

    public static void main(String[] args) {
        LinkedList<Place> places = new LinkedList<>();
        places.add(new Place("Central Park", 40.785091, -73.968285, 5));
        places.add(new Place("Statue of Liberty", 40.689247, -74.044502, 10));
        places.add(new Place("Times Square", 40.758896, -73.985130, 3));
        places.add(new Place("Brooklyn Bridge", 40.706086, -73.996864, 7));

        // System.out.println("Places and their distances from My Place:");
        // for (Place place : places) {
        //     System.out.println(place);
        // }
        var iterator = places.listIterator();
        System.out.println("Navigating through places:");
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        printMenu();

        while (!quit) {
            System.out.println("Enter your choice (forward, backward, quit): ");
            String action = scanner.nextLine();
            switch (action.toLowerCase()) {
                case "forward":
                    if (!forward) {
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                        forward = true;
                    }
                    if (iterator.hasNext()) {
                        System.out.println("Now visiting: " + iterator.next());
                    } else {
                        System.out.println("You have reached the end of the list.");
                        forward = false;
                    }
                    break;
                case "backward":
                    if (forward) {
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }
                        forward = false;
                    }
                    if (iterator.hasPrevious()) {
                        System.out.println("Now visiting: " + iterator.previous());
                    } else {
                        System.out.println("You are at the start of the list.");
                        forward = true;
                    }
                    break;
                case "quit":
                    quit = true;
                    System.out.println("Exiting the game.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    printMenu();
                    break;
            }
        }

    }

    public static void printMenu() {
        System.out.println("forward - move forward");
        System.out.println("backward - move backward");
        System.out.println("quit - exit the game");
    }
}
