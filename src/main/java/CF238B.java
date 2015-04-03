import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF238B {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] a = br.readLine().toCharArray();
        Character context = null;
        int idx = -1;
        int res = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != '.') {
                if (context == null) {
                    context = a[i];
                    idx = i;
                    if (context == 'R') {
                        res += i;
                    }
                } else {
                    if (a[i] == 'L') {
                        if ((i - idx - 1) % 2 == 1) {
                            res++;
                        }
                    } else {
                        res += (i - idx - 1);
                    }

                    context = a[i];
                    idx = i;
                }
            }
        }

        if (context != null) {
            if (context == 'L') {
                res += n - idx - 1;
            }
        } else {
            res += n;
        }

        System.out.println(res);
    }
}
