import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF225A {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] m = new char[n][n];
        m[0][0] = 'C';
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m[i][j] == 'C') {
                    continue;
                }

                int c = 0;
                int d = 0;
                for (int ki = -1; ki <= 1; ki++) {
                    for (int kj = -1; kj <= 1; kj++) {
                        if ((ki == 0 && kj == 0) || (ki != 0 && kj != 0)) {
                            continue;
                        }

                        if (isValid(ki + i, n) && isValid(kj + j, n)) {
                            if (m[ki + i][kj + j] == 'C') {
                                c++;
                            }

                            if (m[ki + i][kj + j] == '.') {
                                d++;
                            }
                        }
                    }
                }

                if (c == 0) {
                    m[i][j] = 'C';
                } else {
                    m[i][j] = '.';
                }
            }
        }

        int c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m[i][j] == 'C') {
                    c++;
                }
            }
        }

        System.out.println(c);
        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < n; j++) {
                sb.append(m[i][j]);
            }

            System.out.println(sb.toString());
        }

    }

    private static boolean isValid(final int ki, final int n) {
        return ki >= 0 && ki < n;
    }
}
