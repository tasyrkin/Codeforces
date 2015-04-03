import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF200C {

    private static class Rat {

        public static final Rat ONE = new Rat(1, 1);

        long nom;
        long denom;

        public Rat(final long n, final long den) {

            if (den == 1) {
                nom = n;
                denom = 1;
            } else {

                long gcd = gcd(Math.abs(n), Math.abs(den));
                this.nom = n / gcd;
                this.denom = den / gcd;
            }
        }

        public Rat neg() {
            return new Rat(-nom, denom);
        }

        public Rat add(final Rat r) {
            long a1 = nom * r.denom;
            long a2 = r.nom * denom;
            long d = denom * r.denom;

            return new Rat(a1 + a2, d);
        }

        public Rat div(final Rat r) {
            return new Rat(nom * r.denom, denom * r.nom);
        }

        public boolean moreThanOne() {
            return nom > denom;
        }

        public boolean isZ() {
            return denom == 1;
        }

    }

    public static long gcd(final long a, final long b) {
        if (a < b) {
            return gcd(b, a);
        }

        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");
        long a = Long.parseLong(parts[0]);
        long b = Long.parseLong(parts[1]);

        Rat num = new Rat(a, b);
        long res = 0;
        while (!num.isZ()) {
            if (num.moreThanOne()) {

                // num = num.add(Rat.ONE.neg());
                long l = findLessThanOne(num, 1, 1000000000000L);
                res += l;
                num = num.add(new Rat(l, 1).neg());
            } else {

                if (num.nom == 1) {
                    res += num.denom;
                    System.out.println(res);
                    return;
                } else {

                    Rat den = Rat.ONE.add(num.neg());
                    num = num.div(den);

                    res++;
                }

            }
        }

        res += num.nom;
        System.out.println(res);
    }

    private static long findLessThanOne(final Rat num, final long left, final long right) {
        long mid = (left + right) >>> 1;
        Rat midR = new Rat(mid, 1);
        Rat res = num.add(midR.neg());
        if (res.moreThanOne()) {
            return findLessThanOne(num, mid + 1, right);
        } else {

            Rat res1 = num.add(new Rat(mid - 1, 1).neg());
            if (res1.moreThanOne()) {
                return mid;
            }

            return findLessThanOne(num, left, mid - 1);
        }
    }

}
