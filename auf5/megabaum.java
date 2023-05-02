package auf5;

public class megabaum  {

    private static int counter = 0;
    final static int omga = 30; // 5 - 79
    final static double pRadius = .006;
    final static double ax1 = 400;
    final static double ax2 = 1400;
    final static double laenge1 = 100;
    final static double laenge2 = 60;
    final static double gamma = 0;
    final static boolean green = true;

    public static void main(String[] args) {
        StdDraw.setPenColor(StdDraw.BROWN);
        StdDraw.setCanvasSize(1920, 1080);
        StdDraw.setXscale(0, 1920);
        StdDraw.setYscale(0, 1080);
        StdDraw.show(0);
        tree1(gamma, laenge1, ax1, 100);
        StdDraw.show(0);
        tree2(gamma, laenge2, ax2, 100);
        StdDraw.show(0);
    }
    public static void tree1(double gamma, double laenge, double ax, double ay) {
        if (laenge < 1){
            return;
        }

        double winkl = Math.toRadians(gamma);
        System.out.println("winkl: " + winkl);
        double omega = Math.toRadians(omga);

        double s = laenge * Math.sin(winkl);
        double c = laenge * Math.cos(winkl);
        double u = laenge * Math.cos(omega);
        double v = laenge * Math.sin(omega);

        double BX = ax + c;
        double BY = ay + s;
        double CX = ax + c - s;
        double CY = ay + s + c;
        double DX = ax - s;
        double DY = ay + c;
        double EX = DX + u * Math.cos(winkl + omega);
        double EY = DY + u * Math.sin(winkl + omega);

        if (laenge < 3){
            if (green)
                StdDraw.setPenColor(StdDraw.GREEN);
            else
                StdDraw.setPenColor(getColor());

            StdDraw.setPenRadius(pRadius / 2);
        }
        else {
            StdDraw.setPenColor(StdDraw.BROWN);
            StdDraw.setPenRadius(pRadius);
        }

        StdDraw.line(ax, ay, DX, DY);
        StdDraw.line(BX, BY, CX, CY);
        StdDraw.line(CX, CY, EX, EY);

        tree1(gamma + omga, u, DX, DY);
        tree1(gamma-(90 - omga), v, EX, EY);
    }

    public static void tree2(double gamma, double laenge, double ax, double ay) {
        if (laenge < 1){
            return;
        }


        double minOmga = 0;
        double maxOmga = 90;
        double rdmOmga = minOmga + (Math.random() * (maxOmga - minOmga));


        double winkl = Math.toRadians(gamma);
        System.out.println("winkl: " + winkl);
        double omega = Math.toRadians(rdmOmga);

        double s = laenge * Math.sin(winkl);
        double c = laenge * Math.cos(winkl);
        double u = laenge * Math.cos(omega);
        double v = laenge * Math.sin(omega);

        double r = Math.random() * 2 + 1;

        double BX = ax + c;
        double BY = ay + s;
        double CX = ax + c - s * r;
        double CY = ay + s + c * r;
        double DX = ax - s * r;
        double DY = ay + c * r;
        double EX = DX + u * Math.cos(winkl + omega);
        double EY = DY + u * Math.sin(winkl + omega);

        if (laenge < 3){
            if (green)
                StdDraw.setPenColor(StdDraw.GREEN);
            else
                StdDraw.setPenColor(getColor());

            StdDraw.setPenRadius(pRadius / 2);
        }
        else {
            StdDraw.setPenColor(StdDraw.BROWN);
            StdDraw.setPenRadius(pRadius);
        }

        StdDraw.line(ax, ay, DX, DY);
        StdDraw.line(BX, BY, CX, CY);

        tree2(gamma + rdmOmga, u, DX, DY);
        tree2(gamma - (90 - rdmOmga), v, EX, EY);
    }

    private static java.awt.Color getColor() {
        counter++;
        float f = (float) (counter % 360) / 360;
        return java.awt.Color.getHSBColor(f, 0.5f, 0.8f);
    }
}
