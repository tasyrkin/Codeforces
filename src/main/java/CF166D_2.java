import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author  tasyrkin
 * @since   2014/01/05
 */
public class CF166D_2 {

    public static final long[] MODS = {1009, 1033, 1039};
    public static final long[] PRIMES = {31, 37, 41};

    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();
        char[] badGood = sc.nextLine().toCharArray();
        int k = Integer.parseInt(sc.nextLine());

        long[][] pows = new long[arr.length][MODS.length];
        long[][] hs = new long[arr.length][MODS.length];

        for (int i = 0; i < MODS.length; i++) {
            pows[0][i] = 1;
            hs[0][i] = arr[0] - 'a' + 1;
        }

        // System.out.println(0 + ": " + hs[0]);
        for (int i = 1; i < pows.length; i++) {
            for (int j = 0; j < MODS.length; j++) {
                pows[i][j] = (pows[i - 1][j] * PRIMES[j]) % MODS[j];
                hs[i][j] = (hs[i - 1][j] + ((arr[i] - 'a' + 1) * pows[i][j]) % MODS[j]) % MODS[j];
            }
        }

        long result = 0;
        int lenNumBad = 0;
        for (int len = 1; len <= arr.length; len++) {
            lenNumBad += badGood[arr[len - 1] - 'a'] == '1' ? 0 : 1;

            int currNumBad = lenNumBad;

            Set<String> metHash = new HashSet<String>();

            StringBuffer hashSb = new StringBuffer();
            for (int i = 0; i < MODS.length; i++) {
                long hash = (hs[len - 1][i] * pows[arr.length - 1][i]) % MODS[i];
                if (hash < 0) {
                    hash += MODS[i];
                }

                hashSb.append(hash + ",");
            }

            if (!metHash.contains(hashSb.toString())) {
                metHash.add(hashSb.toString());

                // System.out.println(String.format("hash [%s-%s]: %s", 0, len + 1, hash));
                if (currNumBad <= k) {
                    result++;
                }
            }

            for (int start = 1; start <= arr.length - len; start++) {
                int minusBad = badGood[arr[start - 1] - 'a'] == '1' ? 0 : 1;
                int plusBad = badGood[arr[start + len - 1] - 'a'] == '1' ? 0 : 1;

                currNumBad += plusBad - minusBad;

                hashSb = new StringBuffer();
                for (int i = 0; i < MODS.length; i++) {
                    long hash = ((hs[start + len - 1][i] - hs[start - 1][i]) * pows[arr.length - start - 1][i])
                            % MODS[i];
                    if (hash < 0) {
                        hash += MODS[i];
                    }

                    hashSb.append(hash + ",");
                }

                if (!metHash.contains(hashSb.toString())) {

                    // System.out.println(String.format("hash [%s-%s]: %s", start, start + len + 1, hash));
                    metHash.add(hashSb.toString());
                    if (currNumBad <= k) {
                        result++;
                    }
                }

            }
        }

        System.out.println(result);
    }
}
