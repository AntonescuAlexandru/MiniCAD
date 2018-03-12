import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import static java.lang.Math.abs;

public final class Algorithms {

    public static final int INT = 10;

    private Algorithms() {
    }

    // Algoritmul lui Bresenham pentru trasarea liniilor
    public static BufferedImage bresenhamAlgorithm(final int x1, final int y1,
                                                   final int x2, final int y2,
                                                   final BufferedImage img, final int color) {

        BufferedImage image = img;
        int x = x1;
        int y = y1;
        int deltaX = abs(x2 - x1);
        int deltaY = abs(y2 - y1);
        int s1 = sign(x2 - x1);
        int s2 = sign(y2 - y1);
        boolean interchanged = false;

        if (deltaY > deltaX) {
            int aux;
            aux = deltaX;
            deltaX = deltaY;
            deltaY = aux;
            interchanged = true;
        } else {
            interchanged = false;
        }

        int error = 2 * deltaY - deltaX;

        for (int i = 0; i <= deltaX; i++) {
            if (!(x < 0 || x >= image.getWidth() || y < 0 || y >= image.getHeight())) {
                image.setRGB(x, y, color);
            }
            while (error > 0) {
                if (interchanged) {
                    x = x + s1;
                } else {
                    y = y + s2;
                }
                error = error - 2 * deltaX;
            }

            if (interchanged) {
                y = y + s2;
            } else {
                x = x + s1;
            }

            error = error + 2 * deltaY;

        }
        return image;
    }

    // functia de sign
    private static int sign(final int x) {
        if (x < 0) {
            return -1;
        } else {
            if (x > 0) {
                return 1;
            }
        }
        return 0;
    }

    // algoritmul lui Bresenham pentru desenarea cercurilor
    // (am folosit modelul de pe geeksforgeeks.org)
    public static BufferedImage bresenhamCircle(final int xc, final int yc, final int radius,
                                                final BufferedImage img, final int color) {
        BufferedImage image = img;
        int x = 0;
        int y = radius;
        int d = 3 - 2 * radius;

        while (y >= x) {
            image = setCirclePoints(xc, yc, x, y, image, color);
            x++;
            if (d > 0) {
                y--;
                d = d + 4 * (x - y) + INT;
            } else {
                d = d + 4 * x + 6;
            }
            image = setCirclePoints(xc, yc, x, y, image, color);
        }

        return image;
    }

    // functia de setat pixelii pentru alg. lui Bresenham de desenat cercuri
    public static BufferedImage setCirclePoints(final int xc, final int yc,
                                                final int x, final int y,
                                                final BufferedImage img, final int color) {
        BufferedImage image = img;
        if ((xc + x) < image.getWidth() && (yc + y) < image.getHeight()) {
            image.setRGB(xc + x, yc + y, color);
        }
        if ((xc - x) >= 0 && (yc + y) < image.getHeight()) {
            image.setRGB(xc - x, yc + y, color);
        }
        if ((xc + x) < image.getWidth() && (yc - y) >= 0) {
            image.setRGB(xc + x, yc - y, color);
        }
        if ((xc - x) >= 0 && (yc - y) >= 0) {
            image.setRGB(xc - x, yc - y, color);
        }
        if ((xc + y) < image.getWidth() && (yc + x) < image.getHeight()) {
            image.setRGB(xc + y, yc + x, color);
        }
        if ((xc - y) >= 0 && (yc + x) < image.getHeight()) {
            image.setRGB(xc - y, yc + x, color);
        }
        if ((xc + y) < image.getWidth() && (yc - x) >= 0) {
            image.setRGB(xc + y, yc - x, color);
        }
        if ((xc - y) >= 0 && (yc - x) >= 0) {
            image.setRGB(xc - y, yc - x, color);
        }

        return image;
    }

    // algoritmul de floodfill pentru umplerea formelor
    public static BufferedImage fill(final int x, final int y,
                                     final BufferedImage img,
                                     final int outlineColor, final int innerColor) {
        BufferedImage image = img;

        LinkedList<Point> queue = new LinkedList<Point>();

        queue.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point p = queue.remove();
            if (!(p.x < 0 || p.x >= image.getWidth() || p.y < 0 || p.y >= image.getHeight())) {
                if (image.getRGB(p.x, p.y) != outlineColor
                        && image.getRGB(p.x, p.y) != innerColor) {
                    image.setRGB(p.x, p.y, innerColor);
                    queue.add(new Point(p.x - 1, p.y));
                    queue.add(new Point(p.x + 1, p.y));
                    queue.add(new Point(p.x, p.y - 1));
                    queue.add(new Point(p.x, p.y + 1));
                }
            }
        }
        return image;
    }

}
