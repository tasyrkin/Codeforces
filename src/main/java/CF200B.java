import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF200B {
    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");
        int[] a = new int[3];
        a[0] = Integer.parseInt(parts[0]);
        a[1] = Integer.parseInt(parts[1]);
        a[2] = Integer.parseInt(parts[2]);

        int s = a[2] + a[1] - a[0];

        int x = s / 2;

        if (a[1] - x + a[2] - x == a[0] && a[1] - x >= 0 && a[2] - x >= 0 && x >= 0) {
            System.out.println((a[1] - x) + " " + x + " " + (a[2] - x));
        } else {
            System.out.println("Impossible");
        }
    }

}
