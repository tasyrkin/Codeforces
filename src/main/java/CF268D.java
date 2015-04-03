import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class CF268D {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");
        int n = Integer.parseInt(parts[0]);
        int a = Integer.parseInt(parts[1]);
        int b = Integer.parseInt(parts[2]);

        parts = br.readLine().split("\\s+");

        TreeSet<Integer> tree = new TreeSet<Integer>();

        for (int i = 0; i < parts.length; i++) {
            int num = Integer.parseInt(parts[i]);
            tree.add(num);
        }

        Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();

        boolean ok = true;
        for (Integer iter = 0; iter < parts.length; iter++) {
            int num = Integer.parseInt(parts[iter]);
            if (visited.get(num) != null) {
                continue;
            }

            if (num == b - num) {
                tree.remove(num);
                visited.put(num, true);
                continue;
            }

            if (num == a - num) {
                tree.remove(num);
                visited.put(num, false);
                continue;
            }

            boolean rem1 = tree.remove(num);
            boolean rem2 = tree.remove(b - num);
            if (!rem1 || !rem2) {
                if (rem1) {
                    tree.add(num);
                }

                if (rem2) {
                    tree.add(b - num);
                }

                boolean rem3 = tree.remove(num);
                boolean rem4 = tree.remove(a - num);
                if (!rem3 || !rem4) {
                    ok = false;
                    break;
                } else {
                    visited.put(num, false);
                    visited.put(a - num, false);
                }
            } else {
                visited.put(num, true);
                visited.put(b - num, true);

            }
        }

        if (!ok) {
            System.out.println("NO");
        } else {
            System.out.println("YES");

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < parts.length; i++) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }

                int num = Integer.parseInt(parts[i]);

                sb.append(visited.get(num) ? "1" : "0");
            }

            System.out.println(sb.toString());
        }
    }
}
