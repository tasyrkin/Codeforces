import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author  tasyrkin
 * @since   2013/07/09
 */
public class SimpleTask {
    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] primes = new boolean[n + n / 2];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;

        List<Integer> primeList = new ArrayList<Integer>();
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                primeList.add(i);
                if ((long) i * (long) i < primes.length) {
                    for (int j = i * i; j < primes.length; j += i) {
                        primes[j] = false;
                    }
                }
            }
        }

        Integer[] primesArr = primeList.toArray(new Integer[0]);
        StringBuffer sb = new StringBuffer();

        for (int k = 4; k <= n; k++) {
            long tmp = k * k - 1;

            for (int pidx = 0; pidx < primesArr.length; pidx++) {
                if (primesArr[pidx] > k) {
                    break;
                }

                int prim = (int) (tmp / primesArr[pidx]);
                long check = prim * primesArr[pidx];

                if (check == tmp) {
                    int idx = Arrays.binarySearch(primesArr, prim);
                    if (idx >= 0) {
                        if (sb.length() > 0) {
                            sb.append(" ");
                        }

                        sb.append(k);
                        break;
                    }
                }
            }
        }

        System.out.println(sb.toString());
    }
}
