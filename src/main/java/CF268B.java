import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF268B {

    private static class Interval {
        int s;
        int f;

        private Interval(final int s, final int f) {
            this.s = s;
            this.f = f;
        }

        public boolean intersect(final Interval other) {
            return (s >= other.s && s <= other.f) || (f >= other.s && f <= other.f) || (other.s >= s && other.s <= f)
                    || (other.f >= s && other.f <= f);
        }

        public Interval shift(final int time) {
            return new Interval(s + time, f + time);
        }
    }

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");
        int p = Integer.parseInt(parts[0]);
        int q = Integer.parseInt(parts[1]);
        int l = Integer.parseInt(parts[2]);
        int r = Integer.parseInt(parts[3]);

        Interval[] z = new Interval[p];
        for (int i = 0; i < p; i++) {
            parts = br.readLine().split("\\s+");
            z[i] = new Interval(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
        }

        Interval[] x = new Interval[q];

        for (int i = 0; i < q; i++) {
            parts = br.readLine().split("\\s+");
            x[i] = new Interval(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
        }

        int count = 0;
        main:
        for (int t = l; t <= r; t++) {
            for (Interval xs : x) {
                Interval shifted = xs.shift(t);
                for (Interval zs : z) {
                    if (zs.intersect(shifted)) {
                        count++;
                        continue main;
                    }
                }
            }
        }

        System.out.println(count);

    }
}
