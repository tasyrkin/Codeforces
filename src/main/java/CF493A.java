import java.util.Arrays;
import java.util.Scanner;

public class CF493A {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        int[]a = new int[n];
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if(min > a[i]) {
                min = a[i];
                idx = i + 1;
            }
        }

        if(a.length == 1) {
            System.out.println(-1);
            return;
        }

        Arrays.sort(a);

        int two = 0;
        for(int i = 1; i < n; i++) {
            two += a[i];
        }
        if(a[0] == two) {
            System.out.println(-1);
        } else {
            System.out.println("1");
            System.out.println(idx);
        }
    }

}
