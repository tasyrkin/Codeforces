import java.util.Scanner;

public class CF275C {
    public static void main(final String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int m = k / 2;
        StringBuilder sb = new StringBuilder();
        int curr = 1;
        int last = n + 1;
        while (m > 0) {
            if (sb.length() > 0) {
                sb.append(" ");
            }

            sb.append(curr);
            last = n - curr + 1;
            sb.append(" ");
            sb.append(last);
            curr++;
            m--;
        }

        if (k % 2 == 1) {

            for (int i = curr; i < last; i++) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }

                sb.append(i);
            }
        } else {
            for (int i = last - 1; i >= curr; i--) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }

                sb.append(i);
            }

        }

        System.out.println(sb.toString());
    }
}
