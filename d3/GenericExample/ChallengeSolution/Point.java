package d3.GenericExample.ChallengeSolution;

import java.util.Arrays;

public abstract class Point implements Mappable {

    private double[] location = new double[2];

    public Point(String location) {
        this.location = Mappable.stringToLatLon(location);
    }

    @Override
    public void render() {
        System.out.println("Render " + this
                + " as Point (" + location[0] + ", " + location[1] + ")"
        );
    }

    private String location() {
        return Arrays.toString(location);
    }
}
