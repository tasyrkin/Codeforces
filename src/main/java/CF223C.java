import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CF223C {

    public static class Pair {
        int l, c;
        long lastFullIdx;

        public Pair(final int il, final int ic) {
            l = il;
            c = ic;
        }

    }

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        LinkedList<Long> idxs = new LinkedList<Long>();
        Map<Long, Integer> vals = new HashMap<Long, Integer>();
        Map<Long, Pair> shifts = new HashMap<Long, Pair>();
        long idx = 0;
        boolean isLastDigit = false;
        for (int i = 0; i < m; i++) {
            String[] ps = br.readLine().split("\\s+");
            if (ps[0].equals("1")) {
                long currIdx = ++idx;
                idxs.addLast(currIdx);
                vals.put(currIdx, Integer.parseInt(ps[1]));
                isLastDigit = true;
            } else {

                Pair p = new Pair(Integer.parseInt(ps[1]), Integer.parseInt(ps[2]));
                shifts.put(idx, p);
                idx += (long) p.l * (long) p.c;
                // if (!isLastDigit) {
                idxs.addLast(idx);
                // }

                isLastDigit = false;
            }
        }

        Long[] a = idxs.toArray(new Long[0]);
        int n = Integer.parseInt(br.readLine());
        String[] ps = br.readLine().split("\\s+");
        StringBuffer r = new StringBuffer();
        for (int i = 0; i < ps.length; i++) {
            if (r.length() > 0) {
                r.append(" ");
            }

            long toSearch = Long.parseLong(ps[i]);
            while (true) {
                int foundIdx = Arrays.binarySearch(a, toSearch);
                if (foundIdx >= 0) {
                    r.append(vals.get(a[foundIdx]));
                    break;
                } else {

                    // foundIdx = (1 - foundIdx) - 1;
                    foundIdx = -(foundIdx + 1) - 1;

                    long lastGoodIndex = a[foundIdx];
                    Pair p = shifts.get(lastGoodIndex);
                    long diff = toSearch - lastGoodIndex;
                    if (diff > p.l) {
                        if (diff % p.l == 0) {
                            toSearch = p.l;
                        } else {
                            toSearch = diff - (diff / p.l) * p.l;
                        }
                    } else {
                        toSearch = diff;
                    }
                }
            }
        }

        System.out.println(r.toString());
    }
}
