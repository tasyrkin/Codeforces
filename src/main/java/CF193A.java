import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF193A {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] a = br.readLine().toCharArray();

        int res = 0;
        for (int i = 1; i < a.length; i++) {
            if (i % n == 0) {
                if (a[i - 1] == a[i - 2] && a[i - 2] == a[i - 3]) {
                    ++res;
                }
            }
        }

        System.out.println(res);
    }

}
