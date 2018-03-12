import java.awt.*;

public final class Rectangle extends Shape {

    public static final int INT = 3;
    public static final int INT1 = 4;
    public static final int INT2 = 5;
    public static final int INT3 = 6;
    public static final int INT4 = 7;
    public static final int INT5 = 8;

    // constructor pentru Rectangle
    public Rectangle(final String[] shapeParameters) {
        super(shapeParameters);
        points = new Point[1];
        points[0] = new Point(Integer.parseInt(shapeParameters[1]),
                Integer.parseInt(shapeParameters[2]));
        distance1 = Integer.parseInt(shapeParameters[INT]);
        distance2 = Integer.parseInt(shapeParameters[INT1]);
        outlineColor = convertColor(shapeParameters[INT2], shapeParameters[INT3]);
        innerColor = convertColor(shapeParameters[INT4], shapeParameters[INT5]);
    }
    @Override
    public void accept(final Visitor v) {
        v.visit(this);
    }
}
