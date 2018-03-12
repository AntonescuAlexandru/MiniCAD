import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) throws IOException {

            // instantiez un obiect de tip Scanner pentru citire
            Scanner scanner = new Scanner(new File(args[0]));
            int n = Integer.parseInt(scanner.nextLine());
            Shape[] shapes = new Shape[n];

            // citesc fiecare linie si o transmit ca si parametru metodei createShape
            // pentru a instantia un obiect de tipul specificat printre parametrii
            for (int i = 0; i < n; i++) {
                String[] shapeParameters = scanner.nextLine().split(" ");
                shapes[i] = ShapeFactory.FACTORY.createShape(shapeParameters[0], shapeParameters);
            }

            // instantiez un vizitator de tipul DrawVisitor si vizitez fiecare Shape
            DrawVisitor visitor = new DrawVisitor();
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].accept(visitor);
        }
            // creez imaginea finala in format png
            File output = new File("drawing.png");
            ImageIO.write(visitor.getImg(), "PNG", output);
            scanner.close();


    }
}
