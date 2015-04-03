import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * WRONG IMPLEMENTATION.
 */
public class TheKingsTree {
    private static class Pair {
        int g;
        int r;
        int costg;
        int costr;

        public Pair(final int gs, final int rs, final int icostg, final int icostr) {
            g = gs;
            r = rs;
            costg = icostg;
            costr = icostr;
        }

        public int cost() {
            return costg + costr;
        }

        @Override
        public String toString() {
            return "Pair{" + "g=" + g + ", r=" + r + "}";
        }
    }

    public int getNumber(final int[] p) {
        Map<Integer, List<Integer>> t = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < p.length; i++) {
            List<Integer> l = t.get(p[i]);
            if (l == null) {
                l = new LinkedList<Integer>();
            }

            l.add(i + 1);
            t.put(p[i], l);

        }

        Pair[][] dp = new Pair[p.length + 1][2];

        find(t, 0, dp);

        int one = dp[0][0].cost();
        int two = dp[0][1].cost();

        return one < two ? one : two;
    }

    public void find(final Map<Integer, List<Integer>> t, final int idx, final Pair[][] dp) {
        List<Integer> chs = t.get(idx);
        if (chs == null) {
            dp[idx][0] = new Pair(1, 0, 1, 0);
            dp[idx][1] = new Pair(0, 1, 0, 1);

            return;
        }

        if (dp[idx][0] != null) {
            return;
        }

        int minGs = 0;
        int rsForGs = 0;
        int costg = 0;
        int costrForG = 0;

        int minRs = 0;
        int gsForRs = 0;
        int costr = 0;
        int costGForR = 0;
        for (Integer ch : chs) {
            find(t, ch, dp);
            if (dp[ch][0].g + dp[ch][0].costg < dp[ch][1].g + dp[ch][1].costg) {
                costg += dp[ch][0].g + dp[ch][0].costg;
                costrForG += dp[ch][0].costr;
                minGs += dp[ch][0].g;
                rsForGs += dp[ch][0].r;
            } else if (dp[ch][0].g + dp[ch][0].costg > dp[ch][1].g + dp[ch][1].costg) {
                costg += dp[ch][1].g + dp[ch][1].costg;
                costrForG += dp[ch][1].costr;
                minGs += dp[ch][1].g;
                rsForGs += dp[ch][1].r;
            } else {
                costg += dp[ch][1].g + dp[ch][1].costg;
                if (dp[ch][0].costr < dp[ch][1].costr) {
                    costrForG += dp[ch][0].costr;
                    minGs += dp[ch][0].g;
                    rsForGs += dp[ch][0].r;
                } else if (dp[ch][0].costr > dp[ch][1].costr) {
                    costrForG += dp[ch][1].costr;
                    minGs += dp[ch][1].g;
                    rsForGs += dp[ch][1].r;
                } else {
                    costrForG += dp[ch][1].costr;
                    if (dp[ch][0].g < dp[ch][1].g) {
                        minGs += dp[ch][0].g;
                        rsForGs += dp[ch][0].r;
                    } else {
                        minGs += dp[ch][1].g;
                        rsForGs += dp[ch][1].r;
                    }
                }
            }

            if (dp[ch][0].r + dp[ch][0].costr < dp[ch][1].r + dp[ch][1].costr) {
                costr += dp[ch][0].r + dp[ch][0].costr;
                costGForR += dp[ch][0].costg;
                minRs += dp[ch][0].r;
                gsForRs += dp[ch][0].g;
            } else if (dp[ch][0].r + dp[ch][0].costr > dp[ch][1].r + dp[ch][1].costr) {
                costr += dp[ch][1].r + dp[ch][1].costr;
                costGForR += dp[ch][1].costg;
                minRs += dp[ch][1].r;
                gsForRs += dp[ch][1].g;
            } else {
                costr += dp[ch][0].r + dp[ch][0].costr;
                if (dp[ch][0].costg < dp[ch][1].costg) {
                    costGForR += dp[ch][0].costg;
                    minRs += dp[ch][0].r;
                    gsForRs += dp[ch][0].g;
                } else if (dp[ch][0].costg > dp[ch][1].costg) {
                    costGForR += dp[ch][1].costg;
                    minRs += dp[ch][1].r;
                    gsForRs += dp[ch][1].g;
                } else {
                    costGForR += dp[ch][1].costg;
                    if (dp[ch][0].r < dp[ch][1].r) {
                        minRs += dp[ch][0].r;
                        gsForRs += dp[ch][0].g;
                    } else {
                        minRs += dp[ch][1].r;
                        gsForRs += dp[ch][1].g;
                    }
                }
            }
        }

        dp[idx][0] = new Pair(minGs + 1, rsForGs, costg + 1, costrForG);
        dp[idx][1] = new Pair(gsForRs, minRs + 1, costGForR, costr + 1);

    }

    public static void main(final String[] args) {
        TheKingsTree t = new TheKingsTree();

        int r = t.getNumber(new int[] {0, 0, 1, 0, 4, 3, 5, 2, 0, 7, 9, 2, 4, 5, 3, 1});

        // int r = t.getNumber(new int[] {0, 0, 0});
        // int r = t.getNumber(new int[] {0, 1, 2, 3, 1});
        // int r = t.getNumber(new int[] {0, 1, 2, 3, 4});
        // int r = t.getNumber(new int[] {});
        System.out.println(r);
    }
}
