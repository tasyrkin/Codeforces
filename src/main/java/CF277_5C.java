import java.util.Scanner;

public class CF277_5C {
    public static void main(final String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int s = sc.nextInt();
        if (s == 0) {
            if (m == 1) {
                System.out.println("0 0");
            } else {
                System.out.println("-1 -1");
            }
        } else if (s > 9 * m) {
            System.out.println("-1 -1");
        } else {
            System.out.println(getMin(m, s) + " " + getMax(m, s));
        }
    }

    private static String getMin(final int m, final int s) {
        String min = "";
        int rest = s;
        for (int i = 0; i < m; i++) {
            if (i != m - 1) {
                if (rest > 9) {
                    min = "9" + min;
                    rest -= 9;
                } else {
                    min = (rest - 1) + min;
                    for (int j = i + 1; j < m - 1; j++) {
                        min = "0" + min;
                    }

                    min = "1" + min;
                    break;
                }
            } else {
                min = rest + min;
            }
        }

        return min;
    }

    private static String getMax(final int m, final int s) {
        StringBuilder max = new StringBuilder();
        int rest = s;
        for (int i = 0; i < m; i++) {
            if (rest > 0) {
                if (rest > 9) {
                    max.append(9);
                    rest -= 9;
                } else {
                    max.append(rest);
                    rest = 0;
                }
            } else {
                max.append("0");
            }
        }

        return max.toString();
    }
}
