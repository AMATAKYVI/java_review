package d8.PirateGame;

import java.util.ArrayList;
import java.util.List;

public class PirateGame extends Game<Player> {

    private String boatName;

    private static final List<List<String>> levelMap;

    static {
        levelMap = new ArrayList<>();
        System.out.println("Loading data...");

        if (levelMap.size() == 0) {
            throw new RuntimeException("Failed to load data");
        }

        System.out.println("Finised Loading Data.");
    }

    public PirateGame(String gameName) {
        super(gameName);
    }

}
