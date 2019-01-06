import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CFLyft5C {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int m = sc.nextInt();
        int[] vertical = new int[n + 1];
        for (int i = 0; i < n; i++) {
            vertical[i] = sc.nextInt();
        }
        vertical[n] = 1000000000;
        Arrays.sort(vertical);
        Map<Integer, Integer> ends = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int y = sc.nextInt();
            if (y < 1000000000) {
                if (start == 1) {
                    int count = ends.getOrDefault(end, 0);
                    ends.put(end, count + 1);
                }
            }
        }
        Integer[] sortedEnds = ends.keySet().toArray(new Integer[0]);
        Arrays.sort(sortedEnds);
        int[] sums = new int[sortedEnds.length];
        for (int i = sums.length - 1; i >= 0; i--) {
            if (i == sums.length - 1) {
                sums[sums.length - 1] = ends.get(sortedEnds[i]);
            } else {
                sums[i] = sums[i + 1] + ends.get(sortedEnds[i]);
            }
        }
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < vertical.length; i++) {
            int foundIdx = Arrays.binarySearch(sortedEnds, vertical[i]);
            if (foundIdx < 0) {
                foundIdx = -(foundIdx + 1);
            }
            int horiz = foundIdx == sortedEnds.length ? 0 : sums[foundIdx];
            int curr = horiz + i;
            if (curr < min) min = curr;
        }

        System.out.println(min);
    }

}
