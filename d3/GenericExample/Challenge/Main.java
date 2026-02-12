package d3.GenericExample.Challenge;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Park newYorkPark = new Park("Grand Canyon National Park", 12.321, 1231.23);

        newYorkPark.render();

        River mississipiRiver = new River("Mississipi River", new ArrayList<>());
        mississipiRiver.addPoint(new Point(12.321, 1231.23));
        mississipiRiver.addPoint(new Point(12.321, 1231.23));
        mississipiRiver.render();
    }
}
