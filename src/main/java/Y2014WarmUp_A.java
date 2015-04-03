import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author  tasyrkin
 * @since   2014/05/16
 */
public class Y2014WarmUp_A {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String aw = br.readLine();
        String bw = br.readLine();

        String a = (aw == null ? "" : aw).toLowerCase();
        String b = (bw == null ? "" : bw).toLowerCase();

        String toFindr = br.readLine();

        String toFind = (toFindr == null ? "" : toFindr).toLowerCase();

        long K = Long.parseLong(br.readLine());

        long a1 = count(a, toFind);
        long b1 = count(b, toFind);

        if (a1 == K) {
            System.out.println(0);
            return;
        }

        if (b1 == K) {
            System.out.println(1);
            return;
        }

        long tmpMin = Math.min(a1, b1);
        long tmpMax = Math.max(a1, b1);

        a1 = tmpMin;
        b1 = tmpMax;

        int num = 2;
        long curr = a1 + b1;
        a1 = b1;
        b1 = curr;
        while (curr < K) {
            curr = a1 + b1;
            a1 = b1;
            b1 = curr;
            num++;
        }

        if (curr == K) {
            System.out.println(num);
        } else {
            System.out.println("Impossible");
        }

    }

    private static int count(final String a, final String toFind2) {

        if (a == null || a.length() == 0 || toFind2 == null || toFind2.length() == 0) {
            return 0;
        }

        char[] ar = a.toCharArray();
        char[] tf = toFind2.toCharArray();
        int cnt = 0;

        for (int i = 0; i < ar.length; i++) {
            int match = 0;
            for (int j = 0; i + j < ar.length && j < tf.length; j++) {
                if (ar[i + j] == tf[j]) {
                    match++;
                } else {
                    break;
                }
            }

            if (tf.length == match) {
                cnt++;
                i += toFind2.length() - 1;
            }

        }

        return cnt;

        /*int idx = 0;
         * int cnt = 0;
         * String s = a;
         * while (true) {
         *
         *  idx = s.indexOf(toFind2);
         *  if (idx == -1) {
         *      break;
         *  }
         *
         *  cnt++;
         *
         *  idx += toFind2.length();
         *
         *  if (idx >= s.length()) {
         *      break;
         *  }
         *
         *  s = s.substring(idx);
         *
         * }
         *
         * return cnt;
         */
    }

}
