import java.util.Scanner;

public class CF282B {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int diff = a - b;

        if (diff == 0) {
            System.out.println("infinity");
            return;
        }

        int cnt = 0;
        for (long i = 1; i * i <= diff; i++) {
            if (diff % i == 0 && diff / i > b) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
