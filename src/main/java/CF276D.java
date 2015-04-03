import java.util.Arrays;
import java.util.Scanner;

public class CF276D {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {

            if (i != 0 && a[i] == a[i - 1]) {
                continue;
            }

            int border = a[a.length - 1] + a[i];
            for (int multiple = 2 * a[i]; multiple <= border; multiple += a[i]) {
                int foundIdx = Arrays.binarySearch(a, i + 1, a.length, multiple);
                if (foundIdx < 0) {
                    foundIdx = Math.abs(foundIdx + 1);
                }

                --foundIdx;

                int mod = a[foundIdx] % a[i];
                max = Math.max(max, mod);
                if (mod == a[i] - 1) {
                    break;
                }
            }
        }

        System.out.println(max);
    }
}
