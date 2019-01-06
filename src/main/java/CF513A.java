import java.util.Scanner;

public class CF513A {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        char[] sumbs = sc.next().toCharArray();
        int eights = 0;
        for (int i = 0; i < sumbs.length; i++) {
            if (sumbs[i] == '8') ++eights;
        }

        System.out.println(Math.min(n / 11, eights));
    }

}
