import java.awt.*;

public final class Square extends Shape {

    public static final int INT = 3;
    public static final int INT1 = 4;
    public static final int INT2 = 5;
    public static final int INT3 = 6;
    public static final int INT4 = 7;

    // constructor Square
    public Square(final String[] shapeParameters) {
        super(shapeParameters);
        points = new Point[1];
        points[0] = new Point(Integer.parseInt(shapeParameters[1]),
                Integer.parseInt(shapeParameters[2]));
        distance1 = Integer.parseInt(shapeParameters[INT]);
        outlineColor = convertColor(shapeParameters[INT1], shapeParameters[INT2]);
        innerColor = convertColor(shapeParameters[INT3], shapeParameters[INT4]);
    }
    @Override
    public void accept(final Visitor v) {
        v.visit(this);
    }
}
