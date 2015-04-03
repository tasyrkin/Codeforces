import java.util.Scanner;

public class CF275A {
    public static void main(final String[] args) {

        Scanner sc = new Scanner(System.in);

        long l = sc.nextLong();
        long r = sc.nextLong();

        for (long i = l; i <= r; i++) {
            for (long j = i + 1; j <= r; j++) {
                for (long k = j + 1; k <= r; k++) {
                    if (gcd(i, j) == 1 && gcd(j, k) == 1 && gcd(i, k) > 1) {
                        System.out.println(i + " " + (j) + " " + (k));
                        return;
                    }
                }
            }
        }

        System.out.println(-1);
    }

    private static long gcd(final long n1, final long n2) {
        if (n1 < n2) {
            return gcd(n2, n1);
        }

        if (n2 == 0) {
            return n1;
        }

        return gcd(n2, n1 % n2);
    }
}
