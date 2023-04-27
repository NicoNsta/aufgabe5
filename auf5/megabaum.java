package auf5;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class megabaum  {

    public static void main(String[] args) {
        StdDraw.setCanvasSize(888, 500);
        StdDraw.setXscale(0, 888);
        StdDraw.setYscale(0, 500);
        StdDraw.setPenRadius(.005);
        StdDraw.show(0);
        test(0, 80, 310, 150);
        StdDraw.show(0);

    }
    public static void test(double w, double l, double ax, double ay) {
        System.out.println("leange: " + l + " winkl: " + w);
        if (l < 6){
            return;
        }

        StdDraw.setPenColor(StdDraw.BROWN);
        double winkl = Math.toRadians(w);
        double omega = Math.toRadians(30);

        double s = l * Math.sin(winkl);
        double c = l * Math.cos(winkl);
        double u = l * Math.cos(winkl);
        double v = l * Math.sin(winkl);

        double BX = ax + c;
        double BY = ay + s;
        double CX = ax + c - s;
        double CY = ay + s + c;
        double DX = ax - s;
        double DY = ay + c;
        double EX = DX + u * Math.cos(winkl + omega);
        double EY = DY + u * Math.sin(winkl + omega);

        StdDraw.line(ax, ay, BX, BY);
        StdDraw.line(ax, ay, DX, DY);
        StdDraw.line(BX, BY, CX, CY);
        StdDraw.line(DX, DY, CX, CY);

        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(EX, EY);
            test(w+30,u , DX, DY);

    }
}
