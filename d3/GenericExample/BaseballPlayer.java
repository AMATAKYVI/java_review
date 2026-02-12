package d3.GenericExample;

interface Player {

    public String getName();

    public int score();
}

public record BaseballPlayer(String name, int battingAverage) implements Player {

    public BaseballPlayer(String string, double d) {
        this(string, (int) (d * 1000));
    }

    @Override
    public int score() {
        return battingAverage;
    }

    @Override
    public String getName() {
        return name;
    }

}
