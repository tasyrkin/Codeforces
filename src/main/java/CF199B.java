import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.Map;

public class CF199B {

    private static class Pair {
        int l;
        int r;

        public Pair(final int le, final int ri) {
            l = le;
            r = ri;
        }
    }

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = br.readLine().split("\\s+");

        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int s = Integer.parseInt(parts[2]);
        int f = Integer.parseInt(parts[3]);

        int dir = f - s > 0 ? 1 : -1;

        Map<Integer, Pair> map = new HashMap<Integer, Pair>();

        while (m-- > 0) {
            parts = br.readLine().split("\\s+");

            int t = Integer.parseInt(parts[0]);
            int l = Integer.parseInt(parts[1]);
            int r = Integer.parseInt(parts[2]);

            map.put(t, new Pair(l, r));
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        int step = 0;
        while (s != f) {
            step++;

            Pair p = map.get(step);
            if (p != null) {
                if (inRange(s, p.l, p.r) || inRange(s + dir, p.l, p.r)) {
                    sb.append("X");

                } else if (dir < 0) {
                    sb.append("L");
                    s += dir;
                } else {
                    sb.append("R");
                    s += dir;
                }
            } else {
                if (dir < 0) {
                    sb.append("L");
                    s += dir;
                } else {
                    sb.append("R");
                    s += dir;
                }
            }

        }

        System.out.println(sb.toString());
    }

    private static boolean inRange(final int mark, final int l, final int r) {
        return mark >= l && mark <= r;
    }

}
