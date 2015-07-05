import java.util.*;

public class CF311D {

    private static class VisitedVertex{
        int vertex;
        int number;

        public VisitedVertex(int vertex, int number) {
            this.vertex = vertex;
            this.number = number;
        }
    }

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        if (m == 0) {
            long res = (long) n * (n - 1) * (n - 2);
            System.out.println("3 " + res / 6);
            return;
        }

        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();

        boolean onlySingleRibbes = true;
        boolean hasDoubleRibbes = false;

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            HashSet<Integer> toSet = graph.get(from);
            if (toSet == null) {
                toSet = new HashSet<>();
            }
            toSet.add(to);
            graph.put(from, toSet);
            if (toSet.size() >= 2) {
                hasDoubleRibbes = true;
                onlySingleRibbes = false;
            }

            HashSet<Integer> fromSet = graph.get(to);
            if (fromSet == null) {
                fromSet = new HashSet<>();
            }
            fromSet.add(from);
            graph.put(to, fromSet);
            if (fromSet.size() >= 2) {
                hasDoubleRibbes = true;
                onlySingleRibbes = false;
            }
        }

        long secondResult = 0;

        Set<Integer> visited = new HashSet<>();
        boolean oddCycleFound = false;
        main:
        for (int vertex = 1; vertex <= n; vertex++) {
            if (visited.contains(vertex)) continue;
            visited.add(vertex);
            final HashMap<Integer, Integer> vertexToNumber = new HashMap<>();

            final Set<Integer> odds = new HashSet<>();
            final Set<Integer> evens = new HashSet<>();

            vertexToNumber.put(vertex, 1);
            Stack<Integer> stack = new Stack<>();
            stack.push(vertex);
            boolean isOdd = true;

            while (!stack.isEmpty()) {
                int currentVertex = stack.peek();
                visited.add(currentVertex);
                vertexToNumber.put(currentVertex, stack.size());

                if(isOdd){
                    odds.add(currentVertex);
                } else {
                    evens.add(currentVertex);
                }

                isOdd = !isOdd;

                final HashSet<Integer> toVertexes = graph.get(currentVertex);
                boolean foundChild = false;

                if (toVertexes != null) {

                    for (Integer child : toVertexes) {
                        if (visited.contains(child)) {
                            int cycleLength = vertexToNumber.get(currentVertex) - vertexToNumber.get(child) + 1;
                            if (cycleLength % 2 == 1) {
                                oddCycleFound = true;
                                break main;
                            }
                        }
                    }


                    for (Integer child : toVertexes) {
                        if (!visited.contains(child)) {
                            foundChild = true;
                            stack.push(child);
                            break;
                        }
                    }
                }
                if (!foundChild) {
                    stack.pop();
                }
            }

            long oddsSize = odds.size();
            long evensSize = evens.size();

            secondResult += oddsSize*(oddsSize-1)/2 + evensSize*(evensSize-1)/2;

        }

        if (oddCycleFound) {
            System.out.println("0 1");
            return;
        }

        if (onlySingleRibbes) {
            long result = 0;
            for (int vertex = 1; vertex <= n; vertex++) {
                HashSet<Integer> siblingSet = graph.get(vertex);
                if (siblingSet != null && siblingSet.size() == 1) {
                    result += (long)n - 2;
                    int sibling = siblingSet.iterator().next();
                    graph.put(vertex, null);
                    graph.put(sibling, null);
                }
            }
            System.out.println("2 " + result);
        } else {
            System.out.println("1 " + secondResult);
        }
    }
}
