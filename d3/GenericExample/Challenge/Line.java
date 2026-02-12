package d3.GenericExample.Challenge;

import java.util.ArrayList;
import java.util.List;

public class Line implements Mappable {

    private List<Double> lngAndLat = new ArrayList<>();

    public Line(List<Double> lngAndlat2) {
        this.lngAndLat = lngAndlat2;
    }

    public void addPoint(Point point) {
        lngAndLat.add(point.getLng());
        lngAndLat.add(point.getLat());
    }

    @Override

    public void render() {
        System.out.println("Line");
    }

}
