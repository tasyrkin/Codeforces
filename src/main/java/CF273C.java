import java.util.Scanner;

public class CF273C {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] a = new long[] {sc.nextInt(), sc.nextInt(), sc.nextInt()};

        long t = a[0] + a[1] + a[2];

        System.out.println(t / 3);
    }

}
