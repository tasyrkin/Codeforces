import java.util.Scanner;

public class CF507B {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int k = sc.nextInt();

        int steps = n / (2 * k + 1) + (n % (2 * k + 1) == 0 ? 0 : 1);

        if (steps == 1) {
            System.out.println(1);
            System.out.println(k + 1 > n ? n : k + 1);
        } else {
            int N = n - (steps - 2) * (2 * k + 1);
            int R = N - 2 * (k + 1);
            int first = R / 2;

            final StringBuilder sb = new StringBuilder();
            int current = first + 1;
            sb.append(current);
            for (int i = 0; i < steps - 1; i++) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                current += 2 * k + 1;
                sb.append(current);
            }
            System.out.println(steps);
            System.out.println(sb.toString());
        }
    }

}
