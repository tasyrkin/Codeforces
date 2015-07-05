import java.util.*;

/*
TLE
 */
public class CF310D {

    private static class Key{
        final long value;
        final int type;
        final int index;

        public Key(long value, int type, int index) {
            this.value = value;
            this.type = type;
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            if (value != key.value) return false;
            if (type != key.type) return false;
            return index == key.index;

        }

        @Override
        public int hashCode() {
            int result = (int) (value ^ (value >>> 32));
            result = 31 * result + type;
            result = 31 * result + index;
            return result;
        }

        @Override
        public String toString() {
            return "Key{" +
                    "value=" + value +
                    ", type=" + type +
                    ", index=" + index +
                    '}';
        }
    }

    private static class KeyComparator implements Comparator<Key>{

        @Override
        public int compare(Key o1, Key o2) {

            if(o1.value == o2.value){

                if(o1.type == o2.type){
                    return Integer.valueOf(o1.index).compareTo(o2.index);
                }

                return Integer.valueOf(o1.type).compareTo(o2.type);
            }

            return Long.valueOf(o1.value).compareTo(o2.value);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        long[]l = new long[n];
        long[]r = new long[n];

        TreeMap<Key, Integer> map = new TreeMap<>(new KeyComparator());

        for(int i = 0; i < n; i++){
            l[i] = sc.nextLong();
            r[i] = sc.nextLong();
            if(i>0) {
                final Key smallKey = new Key(l[i] - r[i - 1], -1, i-1);
                final Key largeKey = new Key(r[i] - l[i - 1], 1, i-1);
                map.put(smallKey, smallKey.index);
                map.put(largeKey, largeKey.index);
            }
        }
        long[]a = new long[m];

        for(int i = 0; i < m; i++){
            a[i] = sc.nextLong();
            map.put(new Key(a[i], 0, i), i);
        }

        int[]result = new int[n-1];
        Arrays.fill(result, -1);

        TreeMap<Key, Integer> currentIntervals = new TreeMap<>(new KeyComparator());

        for(Map.Entry<Key, Integer> entry : map.entrySet()){
            if(entry.getKey().type == -1){
                currentIntervals.put(new Key(r[entry.getValue() + 1] - l[entry.getValue()], -2, entry.getValue()), entry.getValue());
            } else if(entry.getKey().type == 1){
                currentIntervals.remove(new Key(r[entry.getValue() + 1] - l[entry.getValue()], -2, entry.getValue()));
            } else if(!currentIntervals.isEmpty()){
                Map.Entry<Key, Integer> firstEntry = currentIntervals.firstEntry();
                result[firstEntry.getValue()] = entry.getKey().index+1;
                currentIntervals.remove(firstEntry.getKey());
            }
        }

        StringBuilder res = new StringBuilder();
        for(int value : result){
            if(value == -1){
                System.out.println("No");
                return;
            } else {
                if(res.length()>0){
                    res.append(" ");
                }
                res.append(value);
            }
        }
        System.out.println("Yes");
        System.out.println(res.toString());
    }
}
