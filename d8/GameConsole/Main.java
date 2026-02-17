package d8.GameConsole;

public class Main {

    public static void main(String[] args) {
        // System.out.println("hello");

        var console = new GameConsoleX(new ShooterGame("Shooter Game"));

        int playerIndex = console.addPlayer();
        console.playGame(playerIndex);

    }
}
