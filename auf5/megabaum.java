package auf5;
public class megabaum  {

    private static int counter = 0;
    final static int g = 30;
    public static void main(String[] args) {
        StdDraw.setCanvasSize(888, 500);
        StdDraw.setXscale(0, 888);
        StdDraw.setYscale(0, 500);
        StdDraw.setPenRadius(.004);
        StdDraw.show(0);
        StdDraw.setPenColor(StdDraw.BROWN);
        test(0, 80, 310, 150);
        StdDraw.show(0);

    }
    public static void test(double w, double l, double ax, double ay) {
        if (l < 1){
            return;
        }

        double winkl = Math.toRadians(w);
        System.out.println("winkl: " + winkl);
        double omega = Math.toRadians(g);

        double s = l * Math.sin(winkl);
        double c = l * Math.cos(winkl);
        double u = l * Math.cos(omega);
        double v = l * Math.sin(omega);

        double BX = ax + c;
        double BY = ay + s;
        double CX = ax + c - s;
        double CY = ay + s + c;
        double DX = ax - s;
        double DY = ay + c;
        double EX = DX + u * Math.cos(winkl + omega);
        double EY = DY + u * Math.sin(winkl + omega);

        if (l < 3){
//            StdDraw.setPenColor(StdDraw.GREEN);
            StdDraw.setPenColor(getColor());
            StdDraw.setPenRadius(.002);
        }
        else {
            StdDraw.setPenColor(StdDraw.BROWN);
            StdDraw.setPenRadius(.004);
        }

        StdDraw.line(ax, ay, DX, DY);
        StdDraw.line(BX, BY, CX, CY);
        StdDraw.line(CX, CY, EX, EY);

            test(w + g, u, DX, DY);
            test(w-(90 - g), v, EX, EY);
    }

    private static java.awt.Color getColor() {
        counter++;
        float f = (float) (counter % 360) / 360;
        return java.awt.Color.getHSBColor(f, 0.5f, 0.8f);
    }
}
