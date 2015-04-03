import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author  tasyrkin
 * @since   2014/01/05
 */
public class CF166D_1 {

    public static final long MOD = 1405695061L;
    public static final long PRIME = 31;

    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();
        char[] badGood = sc.nextLine().toCharArray();
        int k = Integer.parseInt(sc.nextLine());

        long[] pows = new long[arr.length];
        long[] hs = new long[arr.length];
        pows[0] = 1;
        hs[0] = arr[0] - 'a' + 1;

        // System.out.println(0 + ": " + hs[0]);
        for (int i = 1; i < pows.length; i++) {
            pows[i] = (pows[i - 1] * PRIME) % MOD;
            hs[i] = (hs[i - 1] + ((arr[i] - 'a' + 1) * pows[i]) % MOD) % MOD;
        }

        long result = 0;
        int lenNumBad = 0;
        for (int len = 1; len <= arr.length; len++) {
            lenNumBad += badGood[arr[len - 1] - 'a'] == '1' ? 0 : 1;

            int currNumBad = lenNumBad;

            Set<Long> metHash = new HashSet<Long>();

            long hash = (hs[len - 1] * pows[arr.length - 1]) % MOD;
            if (hash < 0) {
                hash += MOD;
            }

            if (!metHash.contains(hash)) {
                metHash.add(hash);

                // System.out.println(String.format("hash [%s-%s]: %s", 0, len + 1, hash));
                if (currNumBad <= k) {
                    result++;
                }
            }

            for (int start = 1; start <= arr.length - len; start++) {
                int minusBad = badGood[arr[start - 1] - 'a'] == '1' ? 0 : 1;
                int plusBad = badGood[arr[start + len - 1] - 'a'] == '1' ? 0 : 1;

                currNumBad += plusBad - minusBad;

                hash = ((hs[start + len - 1] - hs[start - 1]) * pows[arr.length - start - 1]) % MOD;
                if (hash < 0) {
                    hash += MOD;
                }

                if (!metHash.contains(hash)) {

                    // System.out.println(String.format("hash [%s-%s]: %s", start, start + len + 1, hash));
                    metHash.add(hash);
                    if (currNumBad <= k) {
                        result++;
                    }
                }

            }
        }

        System.out.println(result);
    }
}
