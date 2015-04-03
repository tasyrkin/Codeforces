import java.util.Comparator;
import java.util.PriorityQueue;

public class ProiorityQueueTest {

    private static class Cmp implements Comparator<Integer> {

        @Override
        public int compare(final Integer o1, final Integer o2) {
            return o2.compareTo(o1);
        }
    }

    public static void main(final String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(4, new Cmp());

        q.add(10);
        q.add(4);
        q.add(7);
        q.add(1);

        for (int i = 0; i < 4; i++) {
            int curr = q.poll();
            System.out.println(curr);
        }
    }
}
