import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF245A {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        br.readLine();
        for (int i = 0; i < m; i++) {
            br.readLine();
        }

        boolean r = false;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                System.out.print(" ");
            }

            System.out.print("1");
            r = !r;
        }

    }

}
