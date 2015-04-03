import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF244B {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");
        int n = Integer.parseInt(parts[0]);
        int t = Integer.parseInt(parts[1]);
        int c = Integer.parseInt(parts[2]);
        parts = br.readLine().split("\\s+");

        int[] cr = new int[n];
        for (int i = 0; i < parts.length; i++) {
            cr[i] = Integer.parseInt(parts[i]);
        }

        int more = 0;
        for (int i = 0; i < c - 1; i++) {
            if (cr[i] > t) {
                more++;
            }
        }

        int res = 0;
        for (int i = c - 1; i < n; i++) {
            if (i - c >= 0) {
                if (cr[i - c] > t) {
                    more--;
                }

            }

            if (cr[i] > t) {
                more++;
            }

            if (more <= 0) {
                res++;
            }
        }

        System.out.println(res);
    }

}
