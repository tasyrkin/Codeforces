import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class CF283E {

    private static interface Range {
        Integer getStart();

        Integer getEnd();

        Integer getId();
    }

    private static class CmpByStart implements Comparator<Range> {

        @Override
        public int compare(final Range o1, final Range o2) {
            return o1.getStart().compareTo(o2.getStart());
        }
    }

    private static class CmpByEnd implements Comparator<Range> {
        @Override
        public int compare(final Range o1, final Range o2) {

            int cmpRes = o1.getEnd().compareTo(o2.getEnd());
            if (cmpRes == 0) {
                if (o1.getId() != null && o2.getId() != null) {
                    return o1.getId().compareTo(o2.getId());
                }
            }

            return cmpRes;
        }
    }

    private static class Party implements Range {
        int start;
        int end;

        public Party(final int start, final int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer getStart() {
            return start;
        }

        @Override
        public Integer getEnd() {
            return end;
        }

        @Override
        public Integer getId() {
            return null;
        }
    }

    private static class Actor implements Range {
        int id;
        int start;
        int end;
        int capacity;

        public Actor(final int id, final int start, final int end, final int capacity) {
            this.id = id;
            this.start = start;
            this.end = end;
            this.capacity = capacity;
        }

        @Override
        public Integer getEnd() {
            return end;
        }

        @Override
        public Integer getId() {
            return id;
        }

        @Override
        public Integer getStart() {
            return start;
        }
    }

    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Party[] parties = new Party[n];
        for (int i = 0; i < n; i++) {
            parties[i] = new Party(sc.nextInt(), sc.nextInt());
        }

        int m = sc.nextInt();
        Actor[] actors = new Actor[m];
        for (int i = 0; i < m; i++) {
            actors[i] = new Actor(i + 1, sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(parties, new CmpByStart());
        Arrays.sort(actors, new CmpByStart());

        int aIdx = 0;
        List<Integer> result = new LinkedList<Integer>();
        TreeSet<Range> actorTreeSet = new TreeSet<Range>(new CmpByEnd());
        for (int i = 0; i < n; i++) {
            if (aIdx < m && actors[aIdx].start <= parties[i].start) {
                while (aIdx < m && actors[aIdx].start <= parties[i].start) {
                    actorTreeSet.add(actors[aIdx++]);
                }
            }

            Actor actorToUse = (Actor) actorTreeSet.ceiling(parties[i]);

            if (actorToUse == null) {
                break;
            }

            result.add(actorToUse.id);
            if (--actorToUse.capacity <= 0) {
                actorTreeSet.remove(actorToUse);
            }
        }

        if (result.size() != n) {
            System.out.println("NO");
        } else {
            System.out.println("YES");

            StringBuilder sb = new StringBuilder();
            for (Integer i : result) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }

                sb.append(i);
            }

            System.out.println(sb.toString());
        }

    }
}
