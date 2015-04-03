import java.util.Arrays;
import java.util.Scanner;

public class CF271B {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] seqNums = new int[n];
        for (int i = 0; i < n; i++) {
            int curr = sc.nextInt();
            seqNums[i] = curr + (i > 0 ? seqNums[i - 1] : 0);
        }

        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int worm = sc.nextInt();
            int idx = Arrays.binarySearch(seqNums, worm);
            if (idx >= 0) {
                sb.append(idx + 1);
            } else {
                int possibleIdx = Math.abs(idx + 1);
                sb.append(possibleIdx + 1);
            }

            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
