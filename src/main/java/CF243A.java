import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF243A {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");
        int n = Integer.parseInt(parts[0]);
        int s = Integer.parseInt(parts[1]);
        parts = br.readLine().split("\\s+");

        int tot = 0;
        int max = -1;
        for (int i = 0; i < n; i++) {
            int curr = Integer.parseInt(parts[i]);
            if (max < curr) {
                max = curr;
            }

            tot += curr;
        }

        if (tot - max <= s) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
