import java.util.Scanner;

public class CF284C {

    private static class Point {
        double x;
        double y;

        public Point(final double x, final double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);

        Point A = new Point(sc.nextInt(), sc.nextInt());
        Point B = new Point(sc.nextInt(), sc.nextInt());

        if (A.x > B.x) {
            Point tmp = A;
            A = B;
            B = tmp;
        }

        int n = sc.nextInt();

        int diff = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            Point C;
            Point D;

            if (a == 0) {
                C = new Point(0, (double) -c / b);
                D = new Point(1, (double) -c / b);
            } else if (b == 0) {
                C = new Point((double) -c / a, 0);
                D = new Point((double) -c / a, 1);
            } else {
                C = new Point(0, ((double) -c) / b);
                D = new Point(1, ((double) -(c + a)) / b);
            }

            double res1 = mult(C, A, D);
            double res2 = mult(C, B, D);

            if (res1 < 0 && res2 > 0) {
                diff++;
            }

            if (res1 > 0 && res2 < 0) {
                diff++;
            }

        }

        System.out.println(diff);
    }

    private static double mult(final Point c, final Point a, final Point d) {

        double x1 = a.x - c.x;
        double y1 = a.y - c.y;

        double x2 = d.x - c.x;
        double y2 = d.y - c.y;

        return x1 * y2 - x2 * y1;
    }

}
