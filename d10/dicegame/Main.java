package d10.dicegame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final Random random = new Random();
    public static final Scanner scanner = new Scanner(System.in);

    // public Main() {
    // }
    public static void main(String[] args) {

        // Scanner scanner = new Scanner(System.in);
        int[] dice = {1, 2, 3, 4, 5, 6};
        //var[] diceRoll3 = {null, null, null};
        int higher = 12;
        int lower = 6;
//         while (true) {
// //let say system roll three dice and let the user either bet higher or lower
// // depend on user input the system will give the result

//             // int userInput = scanner.nextInt();
//             // if (userInput == 1) {
//             //     higher = 12;
//             //     lower = 6;
//             // }
//         }
        // int randomCount = 5 - current
        List<Integer> currentDice = new ArrayList<>();
        // for (int i = 0; i < 3; i++) {
        //     currentDice.add(dice[random.nextInt(6)]);
        // }
        // System.out.println(currentDice);
        int rolls = 0;
        do {
            rollDice(currentDice);
            currentDice.clear();
        } while (!pickLosers(currentDice));
        System.out.println("Game Over. Real game would score and continue.");
    }

    private static void rollDice(List<Integer> currentDice) {
        int randomCount = 5 - currentDice.size();
        var newDice = random.ints(randomCount, 1, 7).sorted().boxed().toList();

        currentDice.addAll(
                newDice
        );

        System.out.println("You are dice " + currentDice);
    }

    private static boolean pickLosers(List<Integer> currentDice) {
        String prompt = """
               Press Enter to Score.
               Type "ALL" to reroll all dice.
               List numbers (separated by spaces) to reroll those dice:
               """;

        System.out.println(prompt + " ---> ");
        String userInput = scanner.nextLine();
        if (userInput.isBlank()) {
            return true;
        }

        try {
            removeDice(currentDice, userInput.split(" "));
        } catch (Exception e) {

            e.printStackTrace(System.out);
            System.out.println("Bad input, try again!");
        }

        return false;

    }

    private static void removeDice(List<Integer> currentDice, String[] selected) {
        if (selected.length == 1 && selected[0].contains("ALL")) {
            currentDice.clear();
        } else {
            for (String removed : selected) {
                currentDice.remove(Integer.valueOf(removed));
            }
            System.out.println("keeping " + currentDice);
        }
    }
}
