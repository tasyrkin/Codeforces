import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CF225C {

    private static class ItemCmp implements Comparator<Item> {

        @Override
        public int compare(final Item o1, final Item o2) {

            Long a1 = o1.val / 100000000;
            Long b1 = o1.val % 100000000;
            Long a2 = o2.val / 100000000;
            Long b2 = o2.val % 100000000;

            if (a1.compareTo(a2) == 0) {
                return -b1.compareTo(b2);
            }

            return a1.compareTo(a2);

        }
    }

    private static class Item {
        Long val;
        Integer i;

        public Item(final Long v, final Integer in) {
            val = v;
            i = in;
        }

    }

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] lookToMe = new int[n];
        int[] iLookAt = new int[n];
        String[] ps = br.readLine().split("\\s+");
        List<Integer> lookRight = new LinkedList<Integer>();
        List<Integer> lookLeft = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if ("0".equals(ps[i])) {
                lookLeft.add(i);
                iLookAt[i] = i;
            } else {
                lookRight.add(i);
                iLookAt[i] = n - i - 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int idx = Collections.binarySearch(lookRight, i);
            if (idx >= 0) {
                lookToMe[i] += idx;
            } else {
                idx = -(idx + 1);
                lookToMe[i] += idx;
            }

            idx = Collections.binarySearch(lookLeft, i);
            if (idx >= 0) {
                lookToMe[i] += lookLeft.size() - idx - 1;
            } else {
                idx = -(idx + 1);
                lookToMe[i] += lookLeft.size() - idx;
            }
        }

        // System.out.println("I look at:" + Arrays.toString(iLookAt));
        // System.out.println("They look at me:" + Arrays.toString(lookToMe));

        // PriorityQueue<Item> pq = new PriorityQueue<Item>(200000, new ItemCmp());
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            Long v = (long) lookToMe[i] * (long) 100000000 + (long) iLookAt[i];

            // pq.offer(new Item(v, i));
            items[i] = new Item(v, i);

        }

        Arrays.sort(items, new ItemCmp());

        long cnt = 0;
        for (Item i : items) {

            // Item i = pq.poll();
            int idx = Collections.binarySearch(lookRight, i.i);
            if (idx >= 0) {
                cnt += idx;
                lookRight.remove(idx);
            } else {
                idx = -(idx + 1);
                cnt += idx;
            }

            idx = Collections.binarySearch(lookLeft, i.i);
            if (idx >= 0) {
                cnt += lookLeft.size() - idx - 1;
                lookLeft.remove(idx);
            } else {
                idx = -(idx + 1);
                cnt += lookLeft.size() - idx;
            }

        }

        System.out.println(cnt);
    }
}
