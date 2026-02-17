package d8.GameConsole;

import java.util.*;

public class ShooterGame extends Game<Shooter> {

    public ShooterGame(String gameName) {
        super(gameName);
    }

    @Override
    public Shooter createNewPlayer(String name) {
        return new Shooter(name);
    }

    @Override
    public Map<Character, GameAction> getGameActions(int playerIndex) {

        Map<Character, GameAction> map = new LinkedHashMap<>();
        map.put('Q', new GameAction('Q', "Quit Game", i -> this.quitGame(i)));
        map.put('F', new GameAction('F', "Find Prize", i -> this.getPlayer(i).findPrize()));
        map.put('W', new GameAction('W', "Use Weapon", i -> this.getPlayer(i).useWeapon("Rifle")));

        return map;
    }

    public boolean findPrize(int index) {
        return getPlayer(index).findPrize();
    }

    public boolean useWeapon(int index, String weapon) {
        return getPlayer(index).useWeapon(weapon);
    }

}
