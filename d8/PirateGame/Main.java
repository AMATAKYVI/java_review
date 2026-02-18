package d8.PirateGame;

class Pirate implements Player {

    private String name;

    public Pirate(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }
}

public class Main {

    public static void main(String[] args) {

        System.out.println("game");

        Game<Player> game = new PirateGame("Pirate Game");
        game.addPlayer(new Pirate("Pirate 1"));
        game.addPlayer(new Pirate("Pirate 2"));
        game.addPlayer(new Pirate("Pirate 3"));

    }
}
