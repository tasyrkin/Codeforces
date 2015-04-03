import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF245B {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");
        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);
        int x = Integer.parseInt(parts[2]);

        parts = br.readLine().split("\\s+");

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(parts[i]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int[] b = new int[n + 1];
            b[i] = x;
            for (int j = 0; j < i; j++) {
                b[j] = a[j];
            }

            for (int j = i + 1; j <= n; j++) {
                b[j] = a[j - 1];
            }

            int idx = -1;
            while (-1 < (idx = possible(b))) {
                int c = b[idx];
                for (int j = idx; j < b.length; j++) {
                    if (b[j] != -1 && c != b[j]) {
                        break;
                    }

                    b[j] = -1;
                }
            }

            int cnt = -1;
            for (int j = 0; j < b.length; j++) {
                if (b[j] == -1) {
                    cnt++;
                }
            }

            if (cnt > res) {
                res = cnt;
            }
        }

        System.out.println(res);

    }

    private static int possible(final int[] b) {
        int st = 0;
        for (st = 0; st < b.length && b[st] == -1; st++) { }

        if (st == b.length) {
            return -1;
        }

        int last = b[st];
        int cnt = 1;
        int idx = st;
        for (int i = st + 1; i < b.length; i++) {
            if (b[i] == -1) {
                continue;
            }

            if (b[i] != last) {
                cnt = 1;
                idx = i;
                last = b[i];
            } else {
                cnt++;
                if (cnt >= 3) {
                    break;
                }
            }
        }

        return cnt >= 3 ? idx : -1;
    }

}
