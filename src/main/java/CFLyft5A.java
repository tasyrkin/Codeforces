import java.util.Scanner;

public class CFLyft5A {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final long n = sc.nextLong();
        final long x = sc.nextLong();
        final long y = sc.nextLong();

        long white = Math.min(x - 1, y - 1) + Math.abs(x - y);
        long black = Math.min(n - x, n - y) + Math.abs(x - y);


        //System.out.println(String.format("white = [%s], black = [%s]", white, black));
        System.out.println(white <= black ? "White" : "Black");
    }

}
