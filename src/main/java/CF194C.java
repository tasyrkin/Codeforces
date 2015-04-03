import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF194C {
    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long mon = getMonets(n);
        System.out.println(mon);
    }

    private static long getMonets(final long n) {
        if (pow3(n) || n == 1 || n == 2) {
            return 1;
        }

        int lessPow3 = getLessPow3(n);
        int pow3NotDiv = -1;
        int pow3Div = -1;
        int pow3NotDiv2 = -1;
        for (int i = lessPow3; i >= 0; i--) {
            long pow = (long) Math.pow(3, i);
            if (gcd(n, pow) == pow) {
                pow3Div = i;
                break;
            } else {
                if (pow3NotDiv == -1) {
                    pow3NotDiv = i;
                }
            }
        }

        if (pow3NotDiv == -1) {
            pow3NotDiv = pow3Div + 1;
        }

        pow3NotDiv2 = pow3Div + 1;

        long numOfPow3NotDiv = (long) Math.pow(3, pow3NotDiv);
        if (n < numOfPow3NotDiv) {
            return 1;
        }

        long numFromPow = n / numOfPow3NotDiv;
        long num = getMonets(n - (numOfPow3NotDiv * numFromPow));

        // long numOfPow3Div = (long) Math.pow(3, pow3Div);

        // if (n % numOfPow3Div != 0) {
        numFromPow *= (pow3NotDiv - pow3NotDiv2 > 0 ? (long) Math.pow(3, pow3NotDiv - pow3NotDiv2) : 1);
        // }

        return num + numFromPow;
    }

    private static long gcd(final long a, final long b) {
        if (a < b) {
            return gcd(b, a);
        }

        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    private static int getLessPow3(long n) {
        int pow3 = 0;
        while (n > 0) {
            pow3++;
            n /= 3;
        }

        --pow3;

        return pow3;
    }

    private static boolean pow3(long n) {
        while (n > 0) {
            if (n % 3 != 0) {
                return false;
            }

            n /= 3;
        }

        return true;
    }

}
