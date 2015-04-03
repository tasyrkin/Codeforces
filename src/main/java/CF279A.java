import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class CF279A {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();
        map.put(1, new LinkedList<Integer>());
        map.put(2, new LinkedList<Integer>());
        map.put(3, new LinkedList<Integer>());
        for (int i = 0; i < n; i++) {
            int talent = sc.nextInt();
            LinkedList<Integer> list = map.get(talent);
            if (list == null) {
                list = new LinkedList<Integer>();
            }

            list.add(i + 1);
            map.put(talent, list);
        }

        int teams = Math.min(map.get(3).size(), Math.min(map.get(1).size(), map.get(2).size()));
        System.out.println(teams);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < teams; i++) {
            LinkedList<Integer> l1 = map.get(1);
            LinkedList<Integer> l2 = map.get(2);
            LinkedList<Integer> l3 = map.get(3);
            sb.append(l1.getFirst() + " " + l2.getFirst() + " " + l3.getFirst() + "\n");
            l1.removeFirst();
            l2.removeFirst();
            l3.removeFirst();
        }

        System.out.print(sb.toString());

    }
}
