import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CF194B {

    private static class Pair {
        int x;
        int y;

        public Pair(final int x1, final int y1) {
            x = x1;
            y = y1;
        }

        @Override
        public boolean equals(final Object o) {
            if (o != null && o instanceof Pair) {
                Pair p = (Pair) o;
                return x == p.x && y == p.y;
            }

            return false;
        }

        @Override
        public int hashCode() {
            return Integer.valueOf(x).hashCode() + Integer.valueOf(y).hashCode();
        }
    }

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Pair> set = new HashSet<Pair>();
        Pair[] pairs = new Pair[8];

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int i = 0; i < 8; i++) {
            String[] parts = br.readLine().split("\\s+");
            pairs[i] = new Pair(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            set.add(pairs[i]);
            if (minX > pairs[i].x) {
                minX = pairs[i].x;
            }

            if (minY > pairs[i].y) {
                minY = pairs[i].y;
            }

            if (maxX < pairs[i].x) {
                maxX = pairs[i].x;
            }

            if (maxY < pairs[i].y) {
                maxY = pairs[i].y;
            }
        }

        if (set.size() != 8) {
            System.out.println("ugly");
            return;
        }

        List<Pair> minxes = new ArrayList<Pair>();
        List<Pair> minyes = new ArrayList<Pair>();
        List<Pair> maxxes = new ArrayList<Pair>();
        List<Pair> maxyes = new ArrayList<Pair>();
        for (Pair p : pairs) {
            if (p.x == minX) {
                minxes.add(p);
            }

            if (p.y == minY) {
                minyes.add(p);
            }

            if (p.x == maxX) {
                maxxes.add(p);
            }

            if (p.y == maxY) {
                maxyes.add(p);
            }
        }

        if (minxes.size() != 3 || minyes.size() != 3 || maxxes.size() != 3 || maxyes.size() != 3) {
            System.out.println("ugly");
            return;
        }

        for (Pair p : minxes) {
            int found = 0;
            for (Pair p1 : maxxes) {
                if (p.y == p1.y) {
                    found++;
                }
            }

            if (found != 1) {
                System.out.println("ugly");
                return;
            }
        }

        for (Pair p : minyes) {
            int found = 0;
            for (Pair p1 : maxyes) {
                if (p.x == p1.x) {
                    found++;
                }
            }

            if (found != 1) {
                System.out.println("ugly");
                return;
            }
        }

        System.out.println("respectable");
    }

}
