import java.util.Scanner;

public class CF273A {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += sc.nextInt();
        }

        int res = sum % 5 == 0 ? sum / 5 : -1;
        if (res == 0) {
            res = -1;
        }

        System.out.println(res);
    }
}
