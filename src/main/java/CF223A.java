import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF223A {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] ps = br.readLine().split("\\s+");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(ps[i]);
        }

        int s = 0, e = n - 1;
        int ser = 0, dim = 0;
        boolean isFirst = true;
        while (s <= e) {
            int cur = -1;
            if (a[s] > a[e]) {
                cur = a[s];
                s++;
            } else {
                cur = a[e];
                --e;
            }

            if (isFirst) {
                ser += cur;
            } else {
                dim += cur;
            }

            isFirst = !isFirst;
        }

        System.out.println(ser + " " + dim);

    }
}
