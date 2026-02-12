package d3.GenericExample.Challenge;

import java.util.ArrayList;
import java.util.List;

public class River extends Line {

    private List<Double> lngAndlat = new ArrayList<>();

    private String riverName;

    public River(String riverName, List<Double> lngAndlat) {
        super(lngAndlat);
        this.lngAndlat = lngAndlat;
        this.riverName = riverName;
    }

    @Override
    public void render() {
        // System.out.println(lngAndlat);
        //format it by pair and put []
        System.out.print("River: " + riverName + " as Line (");
        for (int i = 0; i < lngAndlat.size(); i += 2) {
            System.out.print("[" + lngAndlat.get(i) + ", " + lngAndlat.get(i + 1) + "]");
        }
        System.out.println(")");
        // System.out.println("" + riverName + " as Line " + lngAndlat);
    }

    @Override
    public String toString() {
        return "River{"
                + "lngAndlat=" + lngAndlat
                + '}';
    }
}
