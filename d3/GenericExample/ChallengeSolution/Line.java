package d3.GenericExample.ChallengeSolution;

import java.util.Arrays;

public abstract class Line implements Mappable {

    private double[][] locations;

    public Line(String... locations) {
        this.locations = new double[locations.length][];
        int index = 0;
        for (var l : locations) {
            this.locations[index++] = Mappable.stringToLatLon(l);
        }

    }

    @Override
    public void render() {
        System.out.println("Render " + this
                + " as Line (" + locations()
                + ")"
        );
    }

    private String locations() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (double[] location : locations) {
            sb.append(Arrays.toString(location));
            sb.append(", ");
        }
        sb.setLength(sb.length() - 2); // remove the last ", "
        sb.append("]");
        return sb.toString();
    }
}
