import java.awt.*;

public final class Triangle extends Shape {

    public static final int INT = 3;
    public static final int INT1 = 4;
    public static final int INT2 = 5;
    public static final int INT3 = 6;
    public static final int INT4 = 7;
    public static final int INT5 = 8;
    public static final int INT6 = 9;
    public static final int INT7 = 10;

    // constructor Triangle
    public Triangle(final String[] shapeParameters) {
        super(shapeParameters);
        points = new Point[2 + 1];
        points[0] = new Point(Integer.parseInt(shapeParameters[1]),
                Integer.parseInt(shapeParameters[2]));
        points[1] = new Point(Integer.parseInt(shapeParameters[INT]),
                Integer.parseInt(shapeParameters[INT1]));
        points[2] = new Point(Integer.parseInt(shapeParameters[INT2]),
                Integer.parseInt(shapeParameters[INT3]));
        outlineColor = convertColor(shapeParameters[INT4],
                shapeParameters[INT5]);
        innerColor = convertColor(shapeParameters[INT6],
                shapeParameters[INT7]);
    }
    @Override
    public void accept(final Visitor v) {
        v.visit(this);
    }

}
