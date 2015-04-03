import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CF244C {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] parts = br.readLine().split("\\s+");
        int[] cost = new int[n];
        LinkedList[] gr = new LinkedList[n];
        Set<Integer> notVisited = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(parts[i]);
            gr[i] = new LinkedList();
            notVisited.add(i);
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            parts = br.readLine().split("\\s+");

            int a = Integer.parseInt(parts[0]) - 1;
            int b = Integer.parseInt(parts[1]) - 1;
            gr[a].add(b);
        }

        LinkedList<ComponentResult> res = new LinkedList<ComponentResult>();
        Set<Integer> alreadyInCycle = new HashSet<Integer>();

        while (!notVisited.isEmpty()) {
            Iterator<Integer> iter = notVisited.iterator();
            int v = iter.next();
            iter.remove();

            Queue<Integer> q = new LinkedList<Integer>();
            q.add(v);

            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            while (!q.isEmpty()) {

                Integer currVertex = q.poll();

                notVisited.remove(currVertex);

                Integer cnt = map.get(currVertex);
                if (cnt == null) {
                    cnt = 0;
                }

                cnt++;
                if (cnt < 3) {
                    for (Integer child : (LinkedList<Integer>) gr[currVertex]) {
                        Integer childCnt = map.get(child);
                        if (!alreadyInCycle.contains(child) && (childCnt == null || childCnt < 2)) {
                            q.add(child);
                        }
                    }
                }

                // System.out.println("size=" + q.size());

                map.put(currVertex, cnt);
            }

            int min = Integer.MAX_VALUE;
            int minCnt = 0;
            long componentCost = 0;
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                alreadyInCycle.add(e.getKey());
                if (e.getValue() == 1) {
                    componentCost += cost[e.getKey()];
                } else {
                    if (min > cost[e.getKey()]) {
                        minCnt = 1;
                        min = cost[e.getKey()];
                    } else if (min == cost[e.getKey()]) {
                        minCnt++;
                    }
                }
            }

            ComponentResult cc = new ComponentResult();
            cc.cost = componentCost + (minCnt != 0 ? min : 0);
            cc.sameWithinCycle = minCnt;
            res.add(cc);
        }

        long resCost = 0;
        long possibilites = 1;

        for (ComponentResult cr : res) {
            resCost += cr.cost;
            possibilites = (possibilites * (cr.sameWithinCycle != 0 ? cr.sameWithinCycle : 1)) % 1000000007;
        }

        System.out.println(resCost + " " + possibilites);
    }

    private static class ComponentResult {
        long cost;
        int sameWithinCycle;
    }
}
