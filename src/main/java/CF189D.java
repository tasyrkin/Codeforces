import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author  tasyrkin
 * @since   2013/06/23
 */
public class CF189D {
    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] parts = br.readLine().split("\\s+");
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(parts[i]);
        }

        if (a.length == 1) {
            System.out.println("0");
            return;
        }

        int res = solve(0, a);

        /*int cnt = 0;
         * while (true) {
         *  LinkedList<Integer> b = new LinkedList<Integer>();
         *  int first = 0;
         *  int last = first + 1;
         *
         *  while (last < a.length) {
         *      b.add(a[first]);
         *      while (last < a.length && a[last - 1] > a[last]) {
         *          ++last;
         *      }
         *
         *      if (last < a.length) {
         *          first = last;
         *          ++last;
         *      }
         *  }
         *
         *  if (first == last - 1) {
         *      b.add(a[first]);
         *  }
         *
         *  if (b.size() == a.length) {
         *      break;
         *  }
         *
         *  a = b.toArray(new Integer[0]);
         *  cnt++;
         * }
         *
         * System.out.println(cnt);
         */
    }

    private static int solve(final int idx, final Integer[] a) {
        int end = idx + 1;
        if (end < a.length) {
            int cnt = 0;
            for (; a[idx] > a[end] && end < a.length; end++) {
                if (a[end - 1] < a[end]) {
                    cnt++;
                }
            }
        }

        return 0;
    }

}
