import java.util.Arrays;
import java.util.Scanner;

public class CF284E {

    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            int i1 = sc.nextInt() - 1;
            int i2 = sc.nextInt() - 1;

            int gcd = gcd(a[i1], a[i2]);
            a[i1] /= gcd;
            a[i2] /= gcd;

            int j = 2;
            main:
            while (gcd > 1) {
                for (; j * j <= gcd; j++) {
                    if (gcd % j == 0) {
                        res++;
                        gcd /= j;
                        continue main;
                    }
                }

                gcd /= gcd;
                res++;

            }
        }

        System.out.println(res);

        System.out.println(Arrays.toString(a));

    }

    private static int gcd(final int a, final int b) {
        if (a < b) {
            return gcd(b, a);
        }

        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

}
