import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;

public class CFT9B {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] ps = br.readLine().split("\\s+");
        int[] ts = new int[n];
        for (int i = 0; i < n; i++) {
            ts[i] = Integer.parseInt(ps[i]);
        }

        Arrays.sort(ts);

        int t = Integer.parseInt(br.readLine());

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int curr = 1;
            for (int j = i + 1; j < n; j++) {
                if (ts[i] + t >= ts[j]) {
                    curr++;
                } else {
                    break;
                }
            }

            if (curr > max) {
                max = curr;
            }
        }

        System.out.println(max);

    }
}
