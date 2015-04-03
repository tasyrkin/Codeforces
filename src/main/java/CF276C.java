import java.util.Scanner;

public class CF276C {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int query = 0; query < n; query++) {
            long l = sc.nextLong();
            long r = sc.nextLong();
            if (l == 0 && r == 0) {
                sb.append(0);
                sb.append("\n");

                continue;
            }

            if (l == r) {
                sb.append(l);
                sb.append("\n");
                continue;
            }

            long rightSemi = 0;
            for (int bit = 63; bit >= 0; bit--) {
                boolean rightSet = ((r >> bit) & 1) == 1;
                boolean leftSet = ((l >> bit) & 1) == 1;

                if (rightSet) {
                    long check = ((1L << (bit + 1)) - 1);
                    if (check == r) {
                        sb.append(r);
                        sb.append("\n");

                        break;
                    }

                }

                if (rightSet && !leftSet) {

                    long check = ((1L << (bit + 1)) - 1);

                    if ((rightSemi | check) == r) {
                        sb.append((rightSemi | check));
                        sb.append("\n");

                    } else {

                        long res = rightSemi | ((1L << bit) - 1);
                        sb.append(res);
                        sb.append("\n");
                    }

                    break;
                }

                if (rightSet) {
                    rightSemi |= (1L << bit);
                }
            }
        }

        System.out.print(sb.toString());
    }
}
