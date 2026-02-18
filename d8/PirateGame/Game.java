package d8.PirateGame;

import java.util.ArrayList;
import java.util.List;

public abstract class Game<T extends Player> {

    private String gameName;
    private List<T> players = new ArrayList<>();

    public Game(String gameName) {
        this.gameName = gameName;
    }

    public String getGameName() {
        return gameName;
    }

    public void addPlayer(T player) {
        players.add(player);
    }

}
