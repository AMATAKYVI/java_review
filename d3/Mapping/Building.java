package d3.Mapping;

enum UsageType {
    RESIDENTIAL,
    COMMERCIAL,
    INDUSTRIAL,
    GOVERNMENT
}

public class Building implements Mappable {

    private String name;
    private UsageType usage;

    public Building(String name, UsageType usage) {
        this.name = name;
        this.usage = usage;
    }

    @Override
    public String getLabel() {
        return name + " (" + usage + ")";
    }

    @Override
    public Geometry getShape() {
        return Geometry.POINT;
    }

    @Override
    public String getMarker() {
        return switch (usage) {
            case RESIDENTIAL ->
                Color.GREEN.name() + " " + PointMarker.CIRCLE.name();
            case COMMERCIAL ->
                Color.BLUE.name() + " " + PointMarker.SQUARE.name();
            case INDUSTRIAL ->
                Color.ORANGE.name() + " " + PointMarker.TRIANGLE.name();
            case GOVERNMENT ->
                Color.BLACK.name() + " " + PointMarker.PUSH_PIN.name();
        };
    }

    @Override
    public String toJSON() {
        return """
            "type":"%s", "label":"%s", "marker":"%s"
            """.formatted(getShape(), getLabel(), getMarker());
    }
}
