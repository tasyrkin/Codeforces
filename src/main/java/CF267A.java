import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF267A {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split("\\s+");
            int p = Integer.parseInt(parts[0]);
            int q = Integer.parseInt(parts[1]);
            if (p + 2 <= q) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
