import java.awt.*;

public final class Polygon extends Shape {

    // constructor pentru Polygon
    public Polygon(final String[] shapeParameters) {
        super(shapeParameters);
        int n = Integer.parseInt(shapeParameters[1]);
        points = new Point[n];
        int k = 2;
        for (int i = 0; i < n; i++) {
            points[i] = new Point(Integer.parseInt(shapeParameters[k]),
                    Integer.parseInt(shapeParameters[k + 1]));
            k += 2;
        }
        outlineColor = convertColor(shapeParameters[k], shapeParameters[k + 1]);
        k += 2;
        innerColor = convertColor(shapeParameters[k], shapeParameters[k + 1]);
    }
    @Override
    public void accept(final Visitor v) {
        v.visit(this);
    }
}
