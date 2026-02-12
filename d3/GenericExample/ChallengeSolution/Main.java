package d3.GenericExample.ChallengeSolution;

public class Main {

    public static void main(String[] args) {

        var nationalParks = new Park[]{
            new Park("Grand Canyon National Park", "0492.32, -1231.23"),
            new Park("Yellowstone National Park", "12.32, -3.23"),
            new Park("Yosemite National Park", "77.32, -3524.23"),};

        Layer<Park> layer = new Layer<>(nationalParks);
        layer.renderLayer();

        var majorUSRiver = new River[]{
            new River("Mississipi River", "12.32, -1231.23", "12.32, -1231.23", "12.32, -1231.23"),
            new River("Cascade River", "123.23, 123.534", "35.24, 36.45", "35.24, 36.45"),};

        Layer<River> layer2 = new Layer<>(majorUSRiver);
        layer2.addElements(
                new River("Lake Ohying", "23.32, 23.23", "23.4, 32.3")
        );

        layer2.renderLayer();
    }
}
