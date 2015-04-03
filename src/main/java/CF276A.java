import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF276A {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int m = sc.nextInt();
        Set<Integer> set = new HashSet<Integer>();
        int rem = 0;
        while (!set.contains(rem)) {
            set.add(rem);
            rem = a % m;
            if (rem == 0) {
                System.out.println("Yes");
                return;
            }

            a += rem;
        }

        System.out.println("No");

    }
}
