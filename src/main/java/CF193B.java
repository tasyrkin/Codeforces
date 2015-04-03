import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.TreeMap;
import java.util.TreeSet;

public class CF193B {

    /*
     * private static class Node implements Comparable<Node> {
     *
     *  private long abs;
     *
     *  public Node(final long abs) {
     *      setAbs(abs);
     *  }
     *
     *  public void setAbs(final long abs) {
     *      this.abs = abs;
     *  }
     *
     *  @Override
     *  public int compareTo(final Node o) {
     *      return Long.valueOf(abs).compareTo(o.abs);
     *  }
     * }
     */

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");

        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);

        parts = br.readLine().split("\\s+");

        int[] abs = new int[n];
        Long[] nodes = new Long[n];

        long currAbs = 0;
        for (int i = 0; i < k; i++) {
            int a = Integer.parseInt(parts[i]);
            abs[i] = a;
            currAbs += a;
        }

        TreeMap<Long, TreeSet<Integer>> tree = new TreeMap<Long, TreeSet<Integer>>();

        for (int i = 0; i <= parts.length - k; i++) {

            nodes[i] = currAbs; // new Node(currAbs);

            if (i >= k) {
                TreeSet<Integer> intSet = tree.get(nodes[i]);
                if (intSet == null) {
                    intSet = new TreeSet<Integer>();
                }

                intSet.add(i);

                tree.put(nodes[i], intSet);
            }

            int prev = abs[i];
            int next = i < parts.length - k ? Integer.parseInt(parts[i + k]) : 0;

            if (i < parts.length - k) {
                abs[i + k] = next;
            }

            currAbs = currAbs - prev + next;

        }

        long max = -1;
        int leftIdx = -1;
        int rightIdx = -1;
        for (int i = 0; i <= parts.length - 2 * k; i++) {

            long left = nodes[i];

            long rightNode = tree.lastKey();
            TreeSet<Integer> set = tree.get(rightNode);

            long right = rightNode;

            if (left + right > max) {
                max = left + right;
                leftIdx = i;
                rightIdx = set.first();
            }

            TreeSet<Integer> obj = tree.get(nodes[i + k]);
            if (obj.size() == 1) {
                tree.remove(nodes[i + k]);
            } else {
                obj.remove(Integer.valueOf(i + k));
                tree.put(nodes[i + k], obj);
            }

        }

        System.out.println((leftIdx + 1) + " " + (rightIdx + 1));
    }

}
