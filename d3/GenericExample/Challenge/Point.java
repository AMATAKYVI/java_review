package d3.GenericExample.Challenge;

public class Point implements Mappable {

    private double lng, lat;

    @Override
    public void render() {
        System.out.println("Point");
    }

    public Point(double lng, double lat) {
        this.lng = lng;
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public double[] getLngAndLat() {
        return new double[]{lng, lat};
    }

    public double getLat() {
        return lat;
    }

    @Override
    public String toString() {
        return "Point{"
                + "lng=" + lng
                + ", lat=" + lat
                + '}';
    }

}
