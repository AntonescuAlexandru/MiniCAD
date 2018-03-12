import java.awt.*;

// clasa abstracta Shape necesara implementarii celorlalte clase
public abstract class Shape implements Visitable {

    public static final int INT = 3;
    public static final int INT1 = 5;
    public static final int INT2 = 7;
    public static final int INT3 = 24;
    public static final int INT4 = 16;
    public static final int INT5 = 8;
    protected String[] shapeParameters;
    protected Point[] points;
    protected int outlineColor;
    protected int innerColor;
    protected int distance1;
    protected int distance2;

    public Shape() {
    }

    public Shape(final String[] shapeParameters) {
        this.shapeParameters = shapeParameters;
    }


    // metoda ce realizeaza conversia unei culori intr-un int
    protected final int convertColor(final String hexColor, final String opacity) {
        String string = "0x" + hexColor.substring(1, INT);
        int r = Integer.decode(string);
        string = "0x" + hexColor.substring(INT, INT1);
        int g = Integer.decode(string);
        string = "0x" + hexColor.substring(INT1, INT2);
        int b = Integer.decode(string);
        int alpha = Integer.parseInt(opacity);
        return (alpha << INT3) | (r << INT4) | (g << INT5) | b;
    }
}
