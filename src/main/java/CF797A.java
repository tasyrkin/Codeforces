import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class CF797A {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        final LinkedList<Integer> primes = getPrimes(n);

        final LinkedList<Integer> dividers = new LinkedList<>();
        int num = n;
        for (int prime : primes) {
            if (num > 1) {
                while (num % prime == 0) {
                    num /= prime;
                    dividers.add(prime);
                }
            } else break;
        }

        if (dividers.size() >= k) {
            int diff = dividers.size() - k;
            Integer agg = null;
            StringBuilder sb = new StringBuilder();
            for (int divider : dividers) {
                if (diff == 0) {
                    if (agg != null) {
                        agg *= divider;
                        sb.append(agg);
                        agg = null;
                    } else {
                        if (sb.length() > 0) sb.append(" ");
                        sb.append(divider);
                    }
                    //break;
                } else {
                    if (agg == null) {
                        agg = divider;
                    } else {
                        agg *= divider;
                    }
                    diff--;
                }
            }
            System.out.println(sb.toString());
        } else {
            System.out.println(-1);
        }

    }

    private static LinkedList<Integer> getPrimes(final int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                if ((long) i * i <= n) {
                    for (int j = i * i; j <= n; j += i) {
                        primes[j] = false;
                    }
                }
            }
        }
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) result.add(i);
        }

        return result;
    }
}
