import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF267B {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int k = Integer.parseInt(parts[2]);
        int[] arr = new int[m + 1];

        for (int i = 0; i <= m; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[i] = x;
        }

        int cnt = 0;

        for (int i = 0; i < m; i++) {
            int res = arr[i] ^ arr[m];
            int diff = 0;
            for (int j = 0; j < 32; j++) {
                if (((res >> j) & 0x1) == 1) {
                    diff++;
                }
            }

            if (diff <= k) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
