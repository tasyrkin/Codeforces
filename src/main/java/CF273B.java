import java.util.Scanner;

public class CF273B {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long m = sc.nextInt();
        if (n == m) {
            System.out.println("0 0");
        } else {
            long last = n - (m - 1);
            long max = (last * (last - 1)) / 2;
            long baseMin = n / m;
            long cmds = n % m;
            long min = cmds * ((baseMin + 1) * baseMin) / 2 + (m - cmds) * (baseMin - 1) * baseMin / 2;
            System.out.println(min + " " + max);
        }
    }
}
