import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CFT9A {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] ps = br.readLine().split("\\s+");
        int max = Integer.MIN_VALUE;
        int win = -1;
        int secMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int curr = Integer.parseInt(ps[i]);
            if (curr > max) {
                max = curr;
                win = i;
            }
        }

        for (int i = 0; i < n; i++) {
            int curr = Integer.parseInt(ps[i]);
            if (curr > secMax && curr != max) {
                secMax = curr;
            }
        }

        System.out.println(win + 1 + " " + secMax);
    }
}
