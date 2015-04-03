import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF226A {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");
        int n = Integer.parseInt(parts[0]);
        int c = Integer.parseInt(parts[1]);
        parts = br.readLine().split("\\s+");

        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            int curr = Integer.parseInt(parts[i]);
            int next = Integer.parseInt(parts[i + 1]);
            int currMax = curr - next - c;
            if (max < currMax) {
                max = currMax;
            }
        }

        System.out.println(max);
    }
}
