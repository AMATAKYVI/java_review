package d3.Mapping;

enum UtilityType {
    ELECTRICAL,
    FIBER_OPTIC,
    GAS,
    WATER
}

public class UtilityLine implements Mappable {

    private String name;
    private UtilityType type;

    public UtilityLine(String name, UtilityType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getLabel() {
        return name + " (" + type + ")";
    }

    @Override
    public Geometry getShape() {
        return Geometry.LINE;
    }

    @Override
    public String getMarker() {
        return switch (type) {
            case ELECTRICAL ->
                Color.RED.name() + " " + LineMarker.SOLID.name();
            case FIBER_OPTIC ->
                Color.BLUE.name() + " " + LineMarker.DASHED.name();
            case GAS ->
                Color.ORANGE.name() + " " + LineMarker.DOTTED.name();
            case WATER ->
                Color.CYAN.name() + " " + LineMarker.SOLID.name();
        };
    }

    @Override
    public String toJSON() {
        return """
            "type":"%s", "label":"%s", "marker":"%s"
            """.formatted(getShape(), getLabel(), getMarker());
    }
}
