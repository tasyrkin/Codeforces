import java.util.Scanner;

public class CF275B {
    public static void main(final String[] args) {

        Scanner sc = new Scanner(System.in);
        int cnt1 = sc.nextInt();
        int cnt2 = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        long xy = findMin(cnt1, cnt2, x, y);
        long yx = findMin(cnt2, cnt1, y, x);

        long res = Math.min(xy, yx);

        // System.out.println(xy + "," + yx);

        System.out.println(res);
    }

    private static long findMin(final long cnt1, long cnt2, final long x, final long y) {
        long minNum = -1;
        long kx = cnt1 / (x - 1);
        if (cnt1 % (x - 1) == 0) {
            minNum = (kx) * x - 1;
            kx--;
        } else {
            minNum = kx * x + (cnt1 - kx * (x - 1));
        }

        cnt2 -= kx;
        if (cnt2 <= 0) {
            return minNum;
        } else {
            long yfact = minNum / y;
            if ((yfact + 1) * y - minNum - 1 >= cnt2) {
                return minNum + cnt2;
            } else {
                cnt2 -= (yfact + 1) * y - minNum - 1;
                minNum += (yfact + 1) * y - minNum;

                long ky = cnt2 / (y - 1);
                if (cnt2 % (y - 1) == 0) {
                    minNum += ky * y - 1;
                } else {
                    minNum += ky * y + (cnt2 - ky * (y - 1));
                }

                return minNum;
            }
        }
    }
}
