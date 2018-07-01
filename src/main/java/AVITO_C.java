import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class AVITO_C {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        final Map<Integer, List> tree = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            addVertex(tree, v1, v2);
            addVertex(tree, v2, v1);
        }

        int moreEqThanThree = 0;
        int lastMoreEqThanTreeVertex = -1;
        int leafVertex = -1;
        List<Integer> leafVetexes = new LinkedList<>();
        for (Map.Entry<Integer, List> entry : tree.entrySet()) {
            if (entry.getValue().size() >= 3) {
                moreEqThanThree++;
                lastMoreEqThanTreeVertex = entry.getKey();
            }
            if (entry.getValue().size() == 1) {
                leafVertex = entry.getKey();
                leafVetexes.add(leafVertex);
            }
        }
        if (moreEqThanThree > 1) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
            if (lastMoreEqThanTreeVertex == -1) {
                System.out.println("1");
                final List<Integer> neighbours = tree.get(leafVertex);
                for (int nextVertex : neighbours) {
                    int lastVertex = traverseToLastVertex(tree, leafVertex, nextVertex);
                    System.out.println(String.format("%s %s", lastVertex, leafVertex));
                }
            } else {
                final List<Integer> neighbours = tree.get(lastMoreEqThanTreeVertex);
                System.out.println(neighbours.size());

                final StringBuilder sb = new StringBuilder();
                for (int currentLeafVertex : leafVetexes) {
                    if (sb.length() > 0) sb.append("\n");
                    sb.append(String.format("%s %s", lastMoreEqThanTreeVertex, currentLeafVertex));
                }
                System.out.println(sb.toString());
            }
        }
    }

    private static int traverseToLastVertex(final Map<Integer, List> tree, final int lastMoreEqThanTreeVertex, final int nextVertex) {
        final Set<Integer> visited = new HashSet<>();
        visited.add(lastMoreEqThanTreeVertex);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(nextVertex);
        int lastVertex = nextVertex;
        while (!queue.isEmpty()) {
            final Integer vertex = queue.poll();
            visited.add(vertex);
            for (int nextNeighbour : (List<Integer>) tree.get(vertex)) {
                if (!visited.contains(nextNeighbour)) {
                    queue.add(nextNeighbour);
                    lastVertex = nextNeighbour;
                }
            }
        }
        return lastVertex;
    }

    private static void addVertex(final Map<Integer, List> tree, final int v1, final int v2) {
        List neighbours = tree.get(v1);
        if (neighbours == null) {
            neighbours = new LinkedList();
            tree.put(v1, neighbours);
        }
        neighbours.add(v2);
    }
}
