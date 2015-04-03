import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TheKingsFactorization {
    public long[] getVector(long N, final long[] p) {
        List<Long> l = new LinkedList<Long>();
        for (int i = 0; i < p.length; i++) {
            l.add(p[i]);
            N /= p[i];
        }

        long j = 2;
        while (N > 1) {
            for (; j * j <= N; j++) {
                while (N % j == 0) {
                    l.add(j);
                    N /= j;
                }
            }

            l.add(N);
            N /= N;
        }

        long[] res = new long[l.size()];
        int i = 0;
        for (Long r : l) {
            res[i++] = r;
        }

        Arrays.sort(res);

        // System.out.println(Arrays.toString(res));
        return res;
    }

    public static void main(final String[] args) {
        TheKingsFactorization f = new TheKingsFactorization();

        // 800000000000000026, {2}

        long start = System.currentTimeMillis();
        long[] r = f.getVector(800000000000000026L, new long[] {2});

        long duration = System.currentTimeMillis() - start;

        System.out.println(Arrays.toString(r) + ": " + duration);
    }
}
