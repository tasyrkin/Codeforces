import java.util.Arrays;
import java.util.Scanner;

public class CF283B {
    public static void main(final String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] num = sc.next().toCharArray();
        // int[]num = new int[n];

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {

            char[] newNum = Arrays.copyOf(num, n);

            for (int j = 0; j < n; j++) {
                int idx = (i + j) % n;
                newNum[idx] = (char) (((newNum[idx] - num[i] + 10) % 10) + '0');
            }

            String s = new String(newNum, i, n - i) + new String(newNum, 0, i);
            arr[i] = s;
        }

        Arrays.sort(arr);

        System.out.println(arr[0]);

// char[] res = arr[0].toCharArray();
// int cnt = 0;
// while (res[cnt] == '0') {
// cnt++;
// }
//
// if (cnt == n) {
// System.out.println(0);
// } else {
// System.out.println(new String(res, cnt, n - cnt));
// }
    }
}
