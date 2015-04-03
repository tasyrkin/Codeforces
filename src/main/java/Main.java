import java.io.FileNotFoundException;

import java.util.Comparator;

public class Main {

    private static interface Range {
        Integer getStart();

        Integer getEnd();

        Integer getId();
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

        @Override
        public String toString() {
            return "Party{" + "start=" + start + ", end=" + end + '}';
        }
    }

    private static class CmpByEnd implements Comparator<Range> {
        @Override
        public int compare(final Range o1, final Range o2) {

            int cmpRes = o1.getEnd().compareTo(o2.getEnd());
// if (cmpRes == 0) {
// if (o1.getId() != null && o2.getId() != null) {
// return o1.getId().compareTo(o2.getId());
// }
// }

            return cmpRes;
        }
    }

    private static class Actor implements Range {
        Integer id;
        int start;
        int end;
        int capacity;

        public Actor(final Integer id, final int start, final int end, final int capacity) {
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

        @Override
        public String toString() {
            return "Actor{" + "id=" + id + ", start=" + start + ", end=" + end + ", capacity=" + capacity + '}';
        }
    }

    public static void main(final String[] args) throws FileNotFoundException {

        double l = 1e2;

        System.out.println(1e2);

    }

}
