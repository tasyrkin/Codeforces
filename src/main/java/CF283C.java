import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CF283C {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] s = new char[n][m];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next().toCharArray();
        }

        if (n == 1) {
            System.out.println(0);
            return;
        }

        List<Integer> csIdx = new LinkedList<Integer>();
        main:
        for (int j = 0; j < m; j++) {
            boolean cons = true;
            for (int i = 1; i < n; i++) {
                if (s[i][j] < s[i - 1][j]) {
                    cons = false;
                    break;
                }
            }

            if (!cons) {

                if (!csIdx.isEmpty()) {

                    for (int i = 1; i < n; i++) {
                        if (s[i][j] < s[i - 1][j]) {
                            boolean allEq = true;
                            for (Integer idx : csIdx) {
                                if (s[i][idx] != s[i - 1][idx]) {
                                    allEq = false;
                                    break;
                                }
                            }

                            if (allEq) {
                                continue main;
                            }
                        }
                    }

                    csIdx.add(j);

                }

            } else {
                csIdx.add(j);
            }

        }

        System.out.println(m - csIdx.size());

    }
}
