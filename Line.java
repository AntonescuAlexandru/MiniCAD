import java.awt.*;

public final class Line extends Shape {

    public static final int INT = 3;
    public static final int INT1 = 4;
    public static final int INT2 = 5;
    public static final int INT3 = 6;

    public Line() {
    }

    // constructor pentru Line
    public Line(final String[] shapeParameter) {
        super(shapeParameter);
        points = new Point[2];
        points[0] = new Point(Integer.parseInt(shapeParameters[1]),
                Integer.parseInt(shapeParameters[2]));
        points[1] = new Point(Integer.parseInt(shapeParameters[INT]),
                Integer.parseInt(shapeParameters[INT1]));
        outlineColor = convertColor(shapeParameters[INT2], shapeParameters[INT3]);
    }
    @Override
    public void accept(final Visitor v) {
        v.visit(this);
    }
}
