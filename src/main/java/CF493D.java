import java.util.Scanner;

public class CF493D {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();

        long total = 0;
        label_i1:
        for (int i1 = 0; i1 <= n; i1++) {
            label_i2:
            for (int i2 = 0; i2 <= n; i2++) {
                if (i1 + i2 > n) continue label_i1;
                label_i3:
                for (int i3 = 0; i3 <= n; i3++) {
                    if (i1 + i2 + i3 > n) continue label_i2;
                    for (int i4 = n; i4 >= 0; i4--) {
                        if (i1 + i2 + i3 + i4 == n) {
                            total++;
                            continue label_i3;
                        }
                    }
                }
            }
        }
        System.out.println(total);
    }

}
