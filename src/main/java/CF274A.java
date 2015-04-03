import java.util.Scanner;

public class CF274A {
    public static void main(final String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int max = -1;
        max = Math.max(max, a + b + c);
        max = Math.max(max, a * b + c);
        max = Math.max(max, a + b * c);
        max = Math.max(max, a * b * c);
        max = Math.max(max, a * (b + c));
        max = Math.max(max, (a + b) * c);
        System.out.println(max);
    }
}
