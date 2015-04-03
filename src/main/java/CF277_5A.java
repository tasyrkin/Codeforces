import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CF277_5A {
    public static void main(final String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] input = new int[n];
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
            sorted[i] = input[i];
        }

        Arrays.sort(sorted);

        List<Pair> changes = new LinkedList<Pair>();
        for (int i = 0; i < n; i++) {
            if (input[i] != sorted[i]) {

                int j = i + 1;
                for (; j < n; j++) {
                    if (input[j] == sorted[i]) {
                        break;
                    }
                }

                int tmp = input[i];
                input[i] = input[j];
                input[j] = tmp;

                changes.add(new Pair(i, j));
            }
        }

        System.out.println(changes.size());
        if (!changes.isEmpty()) {
            for (Pair p : changes) {
                System.out.println(p.i + " " + p.j);
            }
        }
    }

    private static class Pair {
        int i;
        int j;

        private Pair(final int i, final int j) {
            this.i = i;
            this.j = j;
        }
    }
}
