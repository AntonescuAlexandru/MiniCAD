import java.awt.*;

public final class Canvas extends Shape {

    public static final int Y = 3;
    public static final int INT = 4;

    // constructor pt canvas
    public Canvas(final String[] shapeParameters) {
        super(shapeParameters);
        points = new Point[1];
        points[0] = new Point(2, Y);
        distance1 = Integer.parseInt(shapeParameters[1]);
        distance2 = Integer.parseInt(shapeParameters[2]);
        innerColor = convertColor(shapeParameters[Y], shapeParameters[INT]);
    }
    @Override
    public void accept(final Visitor v) {
        v.visit(this);
    }
}
