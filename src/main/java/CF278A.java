import java.util.Scanner;

public class CF278A {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= 100; i++) {
            String c = "" + (i + n);
            if (c.contains("8")) {
                System.out.println(i);
                return;
            }
        }

    }
}
