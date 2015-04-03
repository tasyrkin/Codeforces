import java.util.Scanner;

public class CF283A {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            int curr = -1;
            for (int j = 0; j < n - 1; j++) {
                if (i == j) {
                    continue;
                }

                int next = j + 1 == i ? j + 2 : j + 1;
                if (next < n) {
                    curr = Math.max(curr, a[next] - a[j]);
                }
            }

            res = Math.min(res, curr);
        }

        System.out.println(res);
    }
}
