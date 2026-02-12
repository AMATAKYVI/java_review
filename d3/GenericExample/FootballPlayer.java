package d3.GenericExample;

public class FootballPlayer implements Player {

    private String name;
    private int jerseyNumber;

    @Override
    public String getName() {
        return name;
    }

    ;

        @Override
    public int score() {
        return jerseyNumber;
    }

    ;


    public FootballPlayer(String name, int jerseyNumber) {
        this.name = name;
        this.jerseyNumber = jerseyNumber;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    @Override
    public String toString() {
        return name + " (#" + jerseyNumber + ")";
    }

}
