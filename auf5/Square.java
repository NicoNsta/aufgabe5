package auf5;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Square {

    private static double  scaleX(double x) { return width  * (x - xmin) / (xmax - xmin); }
    private static double  scaleY(double y) { return height * (ymax - y) / (ymax - ymin); }
    private static double factorX(double w) { return w * width  / Math.abs(xmax - xmin);  }
    private static double factorY(double h) { return h * height / Math.abs(ymax - ymin);  }
    private static double xmin, ymin, xmax, ymax;
    private static final int DEFAULT_SIZE = 512;
    private static int width  = DEFAULT_SIZE;
    private static int height = DEFAULT_SIZE;
    private static boolean defer = false;
    private static BufferedImage offscreenImage, onscreenImage;
    private static Graphics2D offscreen, onscreen;
    private static JFrame frame;
    private double x, y, size, angle;

    public Graphics2D Square(double x, double y, double size, double angle) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.angle = angle;
        return offscreen;
    }
}