package d3.Mapping;

enum Geometry {
    POINT, LINE, POLYGON
}

enum Color {
    RED, BLUE, ORANGE, BLACK, GREEN, CYAN
}

enum LineMarker {
    DASHED, SOLID, DOTTED
}

enum PointMarker {
    CIRCLE, SQUARE, TRIANGLE, PUSH_PIN
}

public interface Mappable {

    String JSON_PROPERTY = """
        "property": {%s}
        """;

    String getLabel();

    Geometry getShape();

    String getMarker();

    default String toJSON() {
        return """
            "type":"%s", "label":"%s", "marker":"%s"
            """.formatted(getShape(), getLabel(), getMarker());
    }

    static void mapIt(Mappable mappable) {

        System.out.println(JSON_PROPERTY.formatted(mappable.toJSON()));
    }

}
