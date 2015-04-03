import java.util.Scanner;

public class CF279D {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        int[][] factor = new int[4][4];
        factor[0] = fact(x1, 0);
        factor[1] = fact(y1, 1);
        factor[2] = fact(x2, 2);
        factor[3] = fact(y2, 3);

        int res = Integer.MAX_VALUE;
        if (factor[0][0] == factor[2][0]) {
            if (factor[1][0] == factor[3][0]) {
                int step = steps(factor[0][2], factor[0][3], factor[2][2], factor[2][3]);
                step += steps(factor[1][2], factor[1][3], factor[3][2], factor[3][3]);
                res = step;
            }
        }

        if (factor[0][0] == factor[3][0]) {
            if (factor[1][0] == factor[2][0]) {
                int step = steps(factor[0][2], factor[0][3], factor[3][2], factor[3][3]);
                step += steps(factor[1][2], factor[1][3], factor[2][2], factor[2][3]);
                res = Math.min(step, res);
            }
        }

        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    private static int[] fact(int x, final int idx) {
        int[] res = new int[4];
        while (true) {
            if (x % 2 != 0 && x % 3 != 0) {
                break;
            }

            if (x % 2 == 0) {
                res[2]++;
                x = x / 2;
            }

            if (x % 3 == 0) {
                res[3]++;
                x = x / 3;
            }

        }

        res[0] = x;

        return res;
    }

    private static int steps(int two1, int three1, int two2, int three2) {
        if (two1 > two2) {
            two1 -= two2;
            two2 = 0;
        } else {
            two2 -= two1;
            two1 = 0;
        }

        if (three1 > three2) {
            three1 -= three2;
            three2 = 0;
        } else {
            three2 -= three1;
            three1 = 0;
        }

        if (two1 > 0) {
            if (three1 > 0) {
                return 2 * three1 + two1;
            }

            if (three2 > 0) {
                return three2 + Math.abs(two1 - three2);
            }

            return two1;
        }

        if (two2 > 0) {
            if (three2 > 0) {
                return 2 * three2 + two2;
            }

            if (three1 > 0) {
                return three1 + Math.abs(two2 - three1);
            }

            return two2;
        }

        if (three1 > 0) {
            return 2 * three1;
        }

        if (three2 > 0) {
            return 2 * three2;
        }

        return 0;
    }
}
