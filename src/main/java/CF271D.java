import java.util.Scanner;

public class CF271D {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[t];
        int[] b = new int[t];
        int max = -1;
        for (int i = 0; i < t; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            max = Math.max(max, b[i]);
        }

        int MOD = 1000000007;

        int[] dp = new int[max + 1];
        int[] sum = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            dp[i] = 1 + (i >= k ? sum[i - k] + 1 : 0);
            dp[i] = dp[i] % MOD;
            sum[i] = (dp[i] + sum[i - 1]) % MOD;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int curr = sum[b[i]] - sum[a[i] - 1];
            if (curr < 0) {
                curr += MOD;
            }

            sb.append(curr);
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
