package d3.GenericExample.ChallengeSolution;

import java.util.ArrayList;
import java.util.List;

public class Layer<T extends Mappable> {

    private List<T> layerElement;

    public Layer(T[] layer) {
        this.layerElement = new ArrayList<>(List.of(layer));
    }

    public void addElements(T... elements) {
        layerElement.addAll(List.of(elements));
    }

    public void renderLayer() {

        for (T element : layerElement) {
            element.render();
        }

    }
}
