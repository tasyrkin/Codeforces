import java.util.Scanner;

public class CF277C {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        char[] str = sc.next().toCharArray();
        if (p > n / 2) {
            p = n - p + 1;
        }

        int res = computeChanges(str, p - 1, n - p);

        int mid = n / 2;
        int rightChanges = 0;
        int rightIdx = -1;
        for (int i = p + 1; i <= mid; i++) {
            int changes = computeChanges(str, i - 1, n - i);
            if (changes > 0) {
                rightIdx = i;
            }

            rightChanges += changes;
        }

        if (rightChanges > 0) {
            res += rightChanges;
        }

        int leftChanges = 0;
        int leftIdx = -1;
        for (int i = p - 1; i >= 1; i--) {
            int changes = computeChanges(str, i - 1, n - i);
            if (changes > 0) {
                leftIdx = i;
            }

            leftChanges += changes;
        }

        if (leftChanges > 0) {
            res += leftChanges;
        }

        int rightDelta = rightIdx - p;
        int leftDelta = p - leftIdx;

        if (leftChanges > 0 && rightChanges > 0) {
            int rightLeft = 2 * rightDelta + leftDelta;
            int leftRight = 2 * leftDelta + rightDelta;
            res += Math.min(rightLeft, leftRight);
        } else if (leftChanges > 0) {
            res += leftDelta;
        } else if (rightChanges > 0) {
            res += rightDelta;
        }

        System.out.println(res);
    }

    private static int computeChanges(final char[] str, final int start, final int end) {
        int st = (str[start] - 'a');
        int en = (str[end] - 'a');
        int res = Math.min(Math.abs(st - en), Math.abs(st + 26 - en));
        res = Math.min(res, Math.abs(en + 26 - st));
        return res;
    }
}
