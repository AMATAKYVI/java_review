package d3.GenericExample.Challenge;

import java.util.ArrayList;
import java.util.List;

public class Layer<T extends Mappable> {

    private List<T> layer = new ArrayList<>();

    public Layer(List<T> layer) {
        this.layer = layer;
    }

    public void add(T mappable) {
        layer.add(mappable);
    }

    public void renderLayer(Layer mappable) {
        // how to loop and render all mappables
        // first check if mappable is list
        List<Mappable> mappableList = (List<Mappable>) mappable;
        for (Mappable m : mappableList) {
            m.render();
        }
    }
}
