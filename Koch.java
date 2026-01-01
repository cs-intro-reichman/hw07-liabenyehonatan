/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

    public static void main(String[] args) {
        snowFlake(Integer.parseInt(args[0]));
        StdDraw.show();
    }

    public static void curve(int n, double x1, double y1, double x5, double y5) {

        if (n == 0) {
            StdDraw.line(x1, y1, x5, y5);
            return;
        }

        double x2 = x1 + (x5 - x1) / 3.0;
        double y2 = y1 + (y5 - y1) / 3.0;

        double x4 = x1 + 2.0 * (x5 - x1) / 3.0;
        double y4 = y1 + 2.0 * (y5 - y1) / 3.0;

        double x3 = 0.5 * (x1 + x5) + (Math.sqrt(3.0) / 6.0) * (y1 - y5);
        double y3 = 0.5 * (y1 + y5) + (Math.sqrt(3.0) / 6.0) * (x5 - x1);

        curve(n - 1, x1, y1, x2, y2);
        curve(n - 1, x2, y2, x3, y3);
        curve(n - 1, x3, y3, x4, y4);
        curve(n - 1, x4, y4, x5, y5);
    }

    public static void snowFlake(int n) {

        StdDraw.setYscale(0, 1.1);
        StdDraw.setXscale(0, 1.1);
        StdDraw.enableDoubleBuffering();

        double x1 = 0.1, y1 = 0.3;
        double x2 = 0.9, y2 = 0.3;
        double x3 = 0.5, y3 = 0.3 + 0.8 * Math.sqrt(3) / 2.0;

        curve(n, x1, y1, x2, y2);
        curve(n, x2, y2, x3, y3);
        curve(n, x3, y3, x1, y1);
    }
}