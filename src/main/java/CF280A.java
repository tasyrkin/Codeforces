import java.util.Scanner;

public class CF280A {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int level = 0;
        int levelSum = 0;
        int sum = 0;
        while (n > sum) {
            level++;
            levelSum += level;
            sum += levelSum;
        }

        if (sum != n) {
            level--;
        }

        System.out.println(level);
    }
}
