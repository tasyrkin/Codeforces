import java.util.Scanner;

public class CF493C {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final long revertCost = sc.nextInt();
        final long flipCost = sc.nextInt();
        char[] s = sc.next().toCharArray();

        long total = 0;
        for (int i = 0; i < s.length; i++) {
            if (i > 0 && s[i - 1] == '0' && s[i] == '1') {
                total++;
            }
        }
        if(s[s.length-1] == '0') total++;

        if(total == 0) {
            System.out.println(0);
            return;
        }

        long min = Long.MAX_VALUE;
        for (int idx = 0; idx < total; idx++) {
            long currCost = (total - idx) * flipCost + (idx * revertCost);

            if (min > currCost) min = currCost;
        }

        System.out.println(min);

    }

}
