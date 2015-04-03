import java.util.Arrays;
import java.util.Scanner;

public class CF277_5B {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] boys = new int[n];
        for (int i = 0; i < n; i++) {
            boys[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] girls = new int[m];
        for (int i = 0; i < m; i++) {
            girls[i] = sc.nextInt();
        }

        Arrays.sort(boys);
        Arrays.sort(girls);

        int pboys = 0;
        int pgirls = 0;
        int res = 0;
        while (pboys < n && pgirls < m) {
            if (Math.abs(boys[pboys] - girls[pgirls]) <= 1) {
                res++;
                pboys++;
                pgirls++;
            } else if (boys[pboys] < girls[pgirls]) {
                pboys++;
            } else {
                pgirls++;
            }
        }

        System.out.println(res);
    }
}
