package d8.GameConsole;

import java.util.function.Predicate;

public record GameAction(char key, String prompt, Predicate<Integer> action) {

}
