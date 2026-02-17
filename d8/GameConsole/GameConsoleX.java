package d8.GameConsole;

import java.util.Scanner;

public class GameConsoleX<T extends Game<? extends Player>> {

    private final T game;

    private static final Scanner scanner = new Scanner(System.in);

    public GameConsoleX(T game) {
        this.game = game;
    }

    public int addPlayer() {

        System.out.println("enter name: ");
        String name = scanner.nextLine();
        System.out.println("welcome");
        return game.addPlayer(name);

    }

    public void playGame(int index) {
        boolean done = false;

        while (!done) {
            var gameActions = game.getGameActions(index);
            System.out.println("Select from one below: ");

            for (Character c : gameActions.keySet()) {

                String prompt = gameActions.get(c).prompt();
                System.out.println(c + ": " + prompt);
            }
            System.out.println("Enter next action: ");

            char nextMove = scanner.nextLine().toUpperCase().charAt(0);
            GameAction gameAction = gameActions.get(nextMove);

            if (gameAction != null) {
                System.out.println("-----");
                done = game.executeGameAction(index, gameAction);

                if (!done) {
                    System.out.println("-----");
                }
            }
        }
    }
}
