import java.util.Scanner;

public class CF277B {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        boolean[][] B = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = sc.nextInt() == 1;
            }
        }

        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (B[i][j]) {
                    int rowOnes = 0;
                    for (int col = 0; col < n; col++) {
                        rowOnes += B[i][col] ? 1 : 0;
                    }

                    int colOnes = 0;
                    for (int row = 0; row < m; row++) {
                        colOnes += B[row][j] ? 1 : 0;
                    }

                    if (rowOnes == n || colOnes == m) {
                        if (rowOnes == n) {
                            rows[i] = true;
                        }

                        if (colOnes == m) {
                            cols[j] = true;
                        }
                    } else {
                        System.out.println("NO");
                        return;
                    }
                }
            }
        }

        System.out.println("YES");

        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                boolean isOne = rows[i] && cols[j];
                if (sb.length() > 0) {
                    sb.append(" ");
                }

                sb.append(isOne ? 1 : 0);
            }

            System.out.println(sb.toString());
        }
    }
}
