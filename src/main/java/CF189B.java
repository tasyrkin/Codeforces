import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author  tasyrkin
 * @since   2013/06/23
 */
public class CF189B {

    private static Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();

    private static class Pair {
        int s;
        int e;

        Pair(final int a, final int b) {
            s = a;
            e = b;
        }

        boolean endsWithin(final Pair p) {
            return p.s < e && e < p.e;
        }

        boolean startsWithin(final Pair p) {
            return p.s < s && s < p.e;
        }
    }

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Pair> l = new ArrayList<Pair>();
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split("\\s+");
            if (parts[0].equals("1")) {
                l.add(new Pair(Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
            } else {
                Pair[] arr = l.toArray(new Pair[0]);
                HashSet<Integer> set = new HashSet<Integer>();

                int startIdx = Integer.parseInt(parts[1]) - 1;
                int endIdx = Integer.parseInt(parts[2]) - 1;

                set.add(startIdx);

                boolean hasPath = solve(arr, startIdx, endIdx, set);
                System.out.println(hasPath ? "YES" : "NO");
                if (hasPath) {
                    Set<Integer> already = map.get(startIdx);
                    if (already == null) {
                        already = new HashSet<Integer>();
                    }

                    already.add(endIdx);
                    map.put(startIdx, already);
                }
            }
        }
    }

    private static boolean solve(final Pair[] arr, final int start, final int end, final Set<Integer> visited) {

        Set<Integer> val = map.get(start);
        if (val != null && val.contains(end)) {
            return true;
        }

        if (arr[start].endsWithin(arr[end]) || arr[start].startsWithin(arr[end])) {
            return true;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited.contains(i)) {
                if (arr[start].endsWithin(arr[i]) || arr[start].startsWithin(arr[i])) {

                    visited.add(i);

                    boolean res = solve(arr, i, end, visited);

                    visited.remove(i);
                    if (res) {
                        Set<Integer> set = map.get(i);
                        if (set == null) {
                            set = new HashSet<Integer>();
                        }

                        set.add(end);
                        map.put(i, set);

                        return true;
                    }
                }
            }
        }

        return false;
    }

}
