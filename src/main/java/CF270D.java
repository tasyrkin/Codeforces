import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CF270D {

    private static class Pair {
        int i;
        int j;

        private Pair(final int i, final int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] costs = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split("\\s+");
            for (int j = 0; j < n; j++) {
                costs[i][j] = Integer.parseInt(parts[j]);
            }
        }

        Map<Integer, List<Pair>> map = new HashMap<Integer, List<Pair>>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (costs[i][j] != costs[j][i]) {
                    System.out.println("NO");
                    return;
                }

                if (i != j && costs[i][j] == 0) {
                    System.out.println("NO");
                    return;
                }

                if (i == j && costs[i][j] != 0) {
                    System.out.println("NO");
                    return;
                }

                if (i != j) {
                    List<Pair> list = map.get(costs[i][j]);
                    if (list == null) {
                        list = new ArrayList<Pair>();
                    }

                    list.add(new Pair(i, j));
                    map.put(costs[i][j], list);
                }
            }
        }

        final Integer[] costsArr = map.keySet().toArray(new Integer[0]);
        Arrays.sort(costsArr);

        int[][] newCosts = new int[n][n];

        for (int i = 0; i < costsArr.length; i++) {
            List<Pair> pairs = map.get(costsArr[i]);
            for (Pair currPair : pairs) {
                if (newCosts[currPair.i][currPair.j] != 0) {
                    if (newCosts[currPair.i][currPair.j] != costsArr[i]) {
                        System.out.println("NO");
                        return;
                    } else {
                        continue;
                    }
                }

                newCosts[currPair.i][currPair.j] = costsArr[i];
                newCosts[currPair.j][currPair.i] = costsArr[i];

                for (int endVertex = 0; endVertex < n; endVertex++) {
                    if (endVertex != currPair.j && endVertex != currPair.i && newCosts[endVertex][currPair.j] == 0
                            && newCosts[endVertex][currPair.i] != 0) {
                        newCosts[endVertex][currPair.j] = newCosts[endVertex][currPair.i] + costsArr[i];
                        newCosts[currPair.j][endVertex] = newCosts[endVertex][currPair.j];
                    }

                    if (endVertex != currPair.j && endVertex != currPair.i && newCosts[endVertex][currPair.i] == 0
                            && newCosts[endVertex][currPair.j] != 0) {
                        newCosts[endVertex][currPair.i] = newCosts[endVertex][currPair.j] + costsArr[i];
                        newCosts[currPair.i][endVertex] = newCosts[endVertex][currPair.i];
                    }
                }
            }
        }

        System.out.println("YES");
    }
}
