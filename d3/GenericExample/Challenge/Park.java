package d3.GenericExample.Challenge;

public class Park extends Point {

    private double lng, lat;
    private String parkName;

    public Park(String parkName, double lng, double lat) {
        super(lng, lat);
        this.lng = lng;
        this.lat = lat;
        this.parkName = parkName;
    }

    @Override
    public void render() {
        System.out.println(parkName + " as Point ([" + lng + ", " + lat + "])");
    }

    @Override
    public String toString() {
        return "Park{"
                + "lng=" + lng
                + ", lat=" + lat
                + '}';
    }
}
