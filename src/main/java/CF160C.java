import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;

public class CF160C {

    /**
     * @param   args
     *
     * @throws  java.io.IOException
     */
    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");
        int m = Integer.parseInt(parts[0]);
        parts = br.readLine().split("\\s+");

        int[] ms = new int[m];
        int minm = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            ms[i] = Integer.parseInt(parts[i]);
            if (minm > ms[i]) {
                minm = ms[i];
            }
        }

        parts = br.readLine().split("\\s+");

        int n = Integer.parseInt(parts[0]);

        // Map<Integer, Integer> ns = new HashMap<Integer, Integer>();
        int[] ns = new int[n];
        parts = br.readLine().split("\\s+");
        for (int i = 0; i < n; i++) {
            int price = Integer.parseInt(parts[i]);
            ns[i] = price;
        }

        Arrays.sort(ns);

        int sum = 0;
        int currInBasket = 0;
        int freeItems = 0;
        for (int i = ns.length - 1; i >= 0; i--) {
            if (currInBasket < minm) {
                sum += ns[i];
                currInBasket++;
            } else if (currInBasket == minm) {
                if (freeItems < 2) {
                    freeItems++;
                } else {
                    currInBasket = 0;
                    freeItems = 0;
                    sum += ns[i];
                }
            }
        }

        System.out.println(sum);
    }

}
