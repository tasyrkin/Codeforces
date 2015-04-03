import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CF277_5D {
    public static void main(final String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List[] graph = new List[n + 1];
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            if (graph[from] == null) {
                graph[from] = new LinkedList();
            }

            graph[from].add(to);
        }

        long res = 0;
        for (int vertex = 1; vertex <= n; vertex++) {

            List<Integer> neighbours = graph[vertex];
            if (neighbours != null) {
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                Set<Integer> potentials = new HashSet<Integer>();
                for (Integer neighbour : neighbours) {
                    List<Integer> ns1 = graph[neighbour];
                    if (ns1 != null) {
                        for (Integer ns : ns1) {
                            if (ns == vertex) {
                                continue;
                            }

                            Integer count = map.get(ns);
                            if (count == null) {
                                count = 0;
                            }

                            count++;
                            if (count > 1) {
                                potentials.add(ns);
                            }

                            map.put(ns, count);
                        }
                    }
                }

                for (Integer potential : potentials) {
                    int cnt = map.get(potential);
                    res += cnt * (cnt - 1) / 2;
                }
            }
        }

        System.out.println(res);
    }
}
