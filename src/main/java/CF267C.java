import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;

public class CF267C {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int k = Integer.parseInt(parts[2]);
        int[] arr = new int[n];
        parts = br.readLine().split("\\s+");

        long first = 0;
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
            if (i < m) {
                first += arr[i];
            }
        }

        long[] dp1 = new long[n];
        long[] dp2 = new long[n];
        dp1[0] = first;
        for (int i = 1; i < parts.length; i++) {
            dp1[i] = dp1[i - 1] + (i + m < parts.length ? arr[i + m] : 0) - arr[i - 1];
            if (i > n - m) {
                dp1[i] = -1;
            }
        }

        System.out.println(Arrays.toString(dp1));

        boolean isFirst = false;
        for (int i = 2; i <= k; i++) {
            long[] curr = isFirst ? dp1 : dp2;
            long[] prev = isFirst ? dp2 : dp1;
            long max = prev[0];
            for (int j = m; j < n; j++) {
                curr[j] = Math.max(curr[j], arr[j] + max);
                if (max < prev[j - m]) {
                    max = prev[j - m];
                }
            }

            for (int j = 0; j < m; j++) {
                curr[j] = prev[j];
            }

            isFirst = !isFirst;
            System.out.println(Arrays.toString(curr));
        }

        long max = -1;
        for (int i = 0; i < n; i++) {
            if (max < dp1[i]) {
                max = dp1[i];
            }

            if (max < dp2[i]) {
                max = dp2[i];
            }
        }

        System.out.println(max);
    }
}
