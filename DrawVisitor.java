import java.awt.image.BufferedImage;

// implementarea visitatorului pentru desenarea formelor
public class DrawVisitor implements Visitor {

    public static final int INT = 3;
    private BufferedImage img;

    // functia visit pentru desenarea canvas-ului
    @Override
    public final void visit(final Canvas canvas) {
        img = new BufferedImage(canvas.distance2, canvas.distance1, BufferedImage.TYPE_4BYTE_ABGR);
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                img.setRGB(i, j, canvas.innerColor);
            }
        }
    }

    // functia visit pentru desenarea unei linii
    @Override
    public final void visit(final Line line) {
        img = Algorithms.bresenhamAlgorithm(
                line.points[0].x, line.points[0].y,
                line.points[1].x, line.points[1].y,
                img, line.outlineColor);
    }

    // functia visit pentru desenarea unui patrat
    @Override
    public final void visit(final Square square) {
        // desenez conturul
        img = Algorithms.bresenhamAlgorithm(
                square.points[0].x,
                square.points[0].y + square.distance1 - 1,
                square.points[0].x,
                square.points[0].y,
                img, square.outlineColor);
        img = Algorithms.bresenhamAlgorithm(
                square.points[0].x + square.distance1 - 1,
                square.points[0].y + square.distance1 - 1,
                square.points[0].x,
                square.points[0].y + square.distance1 - 1,
                img, square.outlineColor);
        img = Algorithms.bresenhamAlgorithm(
                square.points[0].x + square.distance1 - 1,
                square.points[0].y,
                square.points[0].x + square.distance1 - 1,
                square.points[0].y + square.distance1 - 1,
                img, square.outlineColor);
        img = Algorithms.bresenhamAlgorithm(
                square.points[0].x,
                square.points[0].y,
                square.points[0].x + square.distance1 - 1,
                square.points[0].y,
                img, square.outlineColor);

        // colorez interiorul patratului
        img = Algorithms.fill(
                square.points[0].x + 1,
                square.points[0].y + 1,
                img, square.outlineColor, square.innerColor);
    }

    // functia de visit pentru desenarea unui dreptunghi
    @Override
    public final void visit(final Rectangle rectangle) {
        // desenez conturul
        img = Algorithms.bresenhamAlgorithm(
                rectangle.points[0].x,
                rectangle.points[0].y + rectangle.distance1 - 1,
                rectangle.points[0].x,
                rectangle.points[0].y,
                img, rectangle.outlineColor);
        img = Algorithms.bresenhamAlgorithm(
                rectangle.points[0].x + rectangle.distance2 - 1,
                rectangle.points[0].y + rectangle.distance1 - 1,
                rectangle.points[0].x,
                rectangle.points[0].y + rectangle.distance1 - 1,
                img, rectangle.outlineColor);
        img = Algorithms.bresenhamAlgorithm(
                rectangle.points[0].x + rectangle.distance2 - 1,
                rectangle.points[0].y,
                rectangle.points[0].x + rectangle.distance2 - 1,
                rectangle.points[0].y + rectangle.distance1 - 1,
                img, rectangle.outlineColor);
        img = Algorithms.bresenhamAlgorithm(
                rectangle.points[0].x,
                rectangle.points[0].y,
                rectangle.points[0].x + rectangle.distance2 - 1,
                rectangle.points[0].y,
                img, rectangle.outlineColor);

        // colorez interiorul dreptunghiului
        img = Algorithms.fill(
                rectangle.points[0].x + 1,
                rectangle.points[0].y + 1,
                img, rectangle.outlineColor, rectangle.innerColor);
    }

    // functia de visit pentru desenarea unui cerc
    @Override
    public final void visit(final Circle circle) {
        // desenez conturul
        img = Algorithms.bresenhamCircle(
                circle.points[0].x,
                circle.points[0].y,
                circle.distance1, img, circle.outlineColor);

        // colorez interiorul cercului
        img = Algorithms.fill(
                circle.points[0].x,
                circle.points[0].y,
                img, circle.outlineColor, circle.innerColor);
    }

    // functia de visit pentru desenarea unui triunghi
    @Override
    public final void visit(final Triangle triangle) {
        // desenez conturul
        img = Algorithms.bresenhamAlgorithm(
                triangle.points[0].x,
                triangle.points[0].y,
                triangle.points[1].x,
                triangle.points[1].y,
                img, triangle.outlineColor);
        img = Algorithms.bresenhamAlgorithm(
                triangle.points[1].x,
                triangle.points[1].y,
                triangle.points[2].x,
                triangle.points[2].y,
                img, triangle.outlineColor);
        img = Algorithms.bresenhamAlgorithm(
                triangle.points[2].x,
                triangle.points[2].y,
                triangle.points[0].x,
                triangle.points[0].y,
                img, triangle.outlineColor);
        int x = (triangle.points[0].x + triangle.points[1].x + triangle.points[2].x) / INT;
        int y = (triangle.points[0].y + triangle.points[1].y + triangle.points[2].y) / INT;

        // colorez interiorul triunghiului
        img = Algorithms.fill(
                x, y,
                img, triangle.outlineColor, triangle.innerColor);
    }

    // functia de visit pentru desenarea unui romb
    @Override
    public final void visit(final Diamond diamond) {
        // desenez conturul
        img = Algorithms.bresenhamAlgorithm(
                diamond.points[0].x,
                diamond.points[0].y - diamond.distance2 / 2,
                diamond.points[0].x - diamond.distance1 / 2,
                diamond.points[0].y,
                img, diamond.outlineColor);
        img = Algorithms.bresenhamAlgorithm(
                diamond.points[0].x - diamond.distance1 / 2,
                diamond.points[0].y,
                diamond.points[0].x,
                diamond.points[0].y + diamond.distance2 / 2,
                img, diamond.outlineColor);
        img = Algorithms.bresenhamAlgorithm(
                diamond.points[0].x,
                diamond.points[0].y + diamond.distance2 / 2,
                diamond.points[0].x + diamond.distance1 / 2,
                diamond.points[0].y,
                img, diamond.outlineColor);
        img = Algorithms.bresenhamAlgorithm(
                diamond.points[0].x + diamond.distance1 / 2,
                diamond.points[0].y,
                diamond.points[0].x,
                diamond.points[0].y - diamond.distance2 / 2,
                img, diamond.outlineColor);

        // colorez interiorul rombului
        img = Algorithms.fill(
                diamond.points[0].x, diamond.points[0].y,
                img, diamond.outlineColor, diamond.innerColor);
    }

    // functia de visit pentru desenarea unui poligon
    @Override
    public final void visit(final Polygon polygon) {
        // desenez conturul
        int xc = 0;
        int yc = 0;
        for (int i = 0; i < polygon.points.length - 1; i++) {
            img = Algorithms.bresenhamAlgorithm(
                    polygon.points[i].x,
                    polygon.points[i].y,
                    polygon.points[i + 1].x,
                    polygon.points[i + 1].y,
                    img, polygon.outlineColor);
            xc += polygon.points[i].x;
            yc += polygon.points[i].y;
        }
        int n = polygon.points.length - 1;
        img = Algorithms.bresenhamAlgorithm(
                polygon.points[n].x,
                polygon.points[n].y,
                polygon.points[0].x,
                polygon.points[0].y,
                img, polygon.outlineColor);
        xc += polygon.points[n].x;
        yc += polygon.points[n].y;
        xc /= polygon.points.length;
        yc /= polygon.points.length;

        // colorez interiorul poligonului
        img = Algorithms.fill(
                xc, yc,
                img, polygon.outlineColor, polygon.innerColor);
    }

    // metoda de get pentru returnarea BufferedImage-ului construit
    public final BufferedImage getImg() {
        return img;
    }

}
