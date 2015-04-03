import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CF279B {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Set<Integer> afters = new HashSet<Integer>();
        Set<Integer> firsts = new HashSet<Integer>();

        for (int i = 0; i < n; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            afters.add(to);
            map.put(from, to);

            if (!afters.contains(from) && from != 0) {
                firsts.add(from);
            }
        }

        Integer secondFirst = null;
        for (Integer first : firsts) {
            if (!afters.contains(first)) {
                secondFirst = first;
                break;
            }
        }

        Integer firstFirst = map.get(0);
        StringBuilder sb = new StringBuilder();
        while (secondFirst != null && secondFirst != 0 && firstFirst != null && firstFirst != 0) {
            if (sb.length() > 0) {
                sb.append(" ");
            }

            sb.append(secondFirst);
            secondFirst = map.get(secondFirst);

            sb.append(" " + firstFirst);
            firstFirst = map.get(firstFirst);

        }

        if (secondFirst != null && secondFirst != 0) {
            sb.append(" " + secondFirst);
        }

        if (firstFirst != null && firstFirst != 0) {
            sb.append(" " + firstFirst);
        }

        System.out.println(sb.toString());
    }
}
