package d8.GameConsole;

public record Shooter(String name) implements Player {

    boolean findPrize() {
        System.out.println("prize. found!");
        return false;
    }

    boolean useWeapon(String weapon) {
        System.out.println("You shot your " + weapon);
        return false;
    }
}
