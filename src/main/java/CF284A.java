import java.util.Scanner;

public class CF284A {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int curr = 1;
        int watched = 0;
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            while (curr + x <= l) {
                curr += x;
            }

            watched += r - curr + 1;
            curr = r + 1;
        }

        System.out.println(watched);
    }
}
