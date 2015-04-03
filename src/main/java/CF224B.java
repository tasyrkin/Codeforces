import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF224B {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ps = br.readLine().split("\\s+");
        int cnt = 0;
        int a = Integer.parseInt(ps[cnt++]);
        int b = Integer.parseInt(ps[cnt++]);
        int w = Integer.parseInt(ps[cnt++]);
        int x = Integer.parseInt(ps[cnt++]);
        int c = Integer.parseInt(ps[cnt++]);

        int count = 0;
        int c1 = Integer.MAX_VALUE;
        int a1 = Integer.MAX_VALUE;
        int c2 = Integer.MAX_VALUE;
        int a2 = Integer.MAX_VALUE;
        int countDiff = -1;
        while (c > a) {
            count++;
            c--;
            if (countDiff >= 0) {
                countDiff++;
            }

            if (b >= x) {
                b = b - x;
            } else {
                a--;
                b = w - (x - b);
                if (c <= a) {
                    break;
                }

                if (c1 == Integer.MAX_VALUE && b >= x) {
                    c1 = c;
                    a1 = a;
                    countDiff = 0;
                } else if (c2 == Integer.MAX_VALUE && b >= x) {
                    c2 = c;
                    a2 = a;

                    int additional = (c - a) / (countDiff - 1);
                    count += additional * countDiff;
                    c -= additional * (c1 - c2);
                    a -= additional * (a1 - a2);
                }

                /*int times = b / x;
                 * if (c <= a) {
                 *  break;
                 * }
                 *
                 * int diff = c - a;
                 * int additional = diff / (times - 1);
                 * count += additional;
                 */
                // break;
            }
        }

        System.out.println(count);
    }
}
