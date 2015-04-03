import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author  tasyrkin
 * @since   2013/06/23
 */
public class CFTesting7A {
    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n % 2 == 1) {
            System.out.println(-1);
            return;
        }

        boolean[][] sq = new boolean[n][n];
        boolean isBlack = true;
        for (int s = 0; s < n / 2; s++) {
            for (int i = s; i < n - s; i++) {
                sq[s][i] = isBlack;
                sq[n - s - 1][i] = isBlack;
                sq[i][s] = isBlack;
                sq[i][n - s - 1] = isBlack;
            }

            isBlack = !isBlack;
        }

        boolean isInvert = false;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < sq.length; i++) {
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < sq[0].length; j++) {
                    String c = (sq[i][j]) ? "b" : "w";
                    if (isInvert) {
                        c = c.equals("b") ? "w" : "b";
                    }

                    sb.append(c);
                }

                System.out.println(sb.toString());
            }

            isInvert = !isInvert;
            System.out.println();
        }
    }

}
