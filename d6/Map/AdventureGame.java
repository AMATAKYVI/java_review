package d6.Map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdventureGame {

    private static final String GAME_LOCATIONS = """
            0: You are sitting in front of a computer learning Java
            1: You are standing at the end of a road before a small brick building
            2: You are at the top of a hill
            3: You are inside a building, a well house for a small stream
            4: You are in a valley beside a stream
            5: You are in the forest
            """;

    private enum Compass {
        N,
        S,
        E,
        W;

        private static final String[] directions = {"North", "South", "East", "West"};

        public String toString() {
            return directions[this.ordinal()];
        }

    }

    private record Location(String description, Map<Compass, Integer> exits) {

    }

    private String lastPlace;

    private Map<String, Location> adventureMap = new HashMap<>();

    public AdventureGame() {
        for (String line : GAME_LOCATIONS.split("\n")) {
            String[] parts = line.split(":");
            String location = parts[0].trim();
            String description = parts[1].trim();
            adventureMap.put(location, new Location(description, new HashMap<>()));
        }
    }

    private Map<Compass, String> loadDirections(String nextPlaces) {
        Map<Compass, String> directions = new HashMap<>();
        List<String> nextSteps = Arrays.asList(nextPlaces.split(","));
        for (int i = 0; i < nextSteps.size(); i++) {
            directions.put(Compass.values()[i], nextSteps.get(i));
        }
        return directions;
    }

    @Override
    public String toString() {
        return adventureMap.toString();
    }

    private void nextPlaces(Location location) {

    }

    private void visit(Location location) {
//        location.nextPlaces.forEach((k, v) -> {
//            System.out.println("Go " + k + " you will go to " + v);
//        });
    }
}
