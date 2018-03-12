// clasa de tip Factory pentru implementarea factory pattern
// si totodata si sigleton pattern
public final class ShapeFactory implements Factory {
    public static final ShapeFactory FACTORY = new ShapeFactory();

    private ShapeFactory() {
    }

    @Override
    public Shape createShape(final String type, final String[] shapeParameters) {
        switch (type) {
            case "CANVAS":
                return new Canvas(shapeParameters);
            case "LINE":
                return new Line(shapeParameters);
            case "SQUARE":
                return new Square(shapeParameters);
            case "RECTANGLE":
                return new Rectangle(shapeParameters);
            case "TRIANGLE":
                return new Triangle(shapeParameters);
            case "DIAMOND":
                return new Diamond(shapeParameters);
            case "CIRCLE":
                return new Circle(shapeParameters);
            case "POLYGON":
                return new Polygon(shapeParameters);
            default:
                return null;
        }
    }
}
