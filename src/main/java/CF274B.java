import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CF274B {

    private static class Tow {
        Integer hight;
        int pos;

        private Tow(final int hight, final int pos) {
            this.hight = hight;
            this.pos = pos;
        }
    }

    private static class TowMinimal implements Comparator<Tow> {

        @Override
        public int compare(final Tow o1, final Tow o2) {
            return o1.hight.compareTo(o2.hight);
        }
    }

    private static class TowMaximal implements Comparator<Tow> {

        @Override
        public int compare(final Tow o1, final Tow o2) {
            return o2.hight.compareTo(o1.hight);
        }
    }

    private static class Pair {
        int first;
        int second;

        private Pair(final int first, final int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(final String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        PriorityQueue<Tow> min = new PriorityQueue<Tow>(n, new TowMinimal());
        PriorityQueue<Tow> max = new PriorityQueue<Tow>(n, new TowMaximal());
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();

            Tow tow = new Tow(a[i], i + 1);
            min.offer(tow);
            max.offer(tow);
        }

        if (n == 1) {
            System.out.println("0 0");
            return;
        }

        int steps = 0;
        int minInc = Integer.MAX_VALUE;
        int firstStep = -1;
        List<Pair> ops = new ArrayList<Pair>();
        while (steps < k) {
            int currInc = max.peek().hight - min.peek().hight;
            if (currInc >= 0 && currInc < minInc) {
                minInc = currInc;
                firstStep = steps;
            }

            Tow towMax = max.poll();
            Tow towMin = min.poll();
            min.remove(towMax);
            max.remove(towMin);
            ops.add(new Pair(towMax.pos, towMin.pos));
            towMax.hight--;
            min.offer(towMax);
            max.offer(towMin);
            towMin.hight++;
            min.offer(towMin);
            max.offer(towMax);
            steps++;
        }

        int currInc = max.peek().hight - min.peek().hight;
        if (currInc >= 0 && currInc < minInc) {
            minInc = currInc;
            firstStep = steps;
        }

        System.out.println(minInc + " " + firstStep);
        for (int i = 0; i < firstStep; i++) {
            Pair p = ops.get(i);
            System.out.println(p.first + " " + p.second);
        }
    }
}
