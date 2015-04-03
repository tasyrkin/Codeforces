import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CF274C {

    private static class Cmp implements Comparator<Integer> {

        @Override
        public int compare(final Integer o1, final Integer o2) {
            return o2.compareTo(o1);
        }
    }

    public static void main(final String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, PriorityQueue<Integer>> m = new HashMap<Integer, PriorityQueue<Integer>>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            PriorityQueue<Integer> pq = m.get(a);
            if (pq == null) {
                pq = new PriorityQueue<Integer>(5000, new Cmp());
            }

            pq.add(b);
            m.put(a, pq);
        }

        Integer[] arr = m.keySet().toArray(new Integer[0]);
        Arrays.sort(arr);

        int max = 1;
        for (Integer curr : arr) {
            PriorityQueue<Integer> pq = m.get(curr);
            Integer before = pq.peek();
            if (max > before) {
                max = curr;
            } else {
                max = before;
            }
        }

        System.out.println(max);
    }
}
