import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author  tasyrkin
 * @since   2013/08/25
 */
public class Lunch3D {

    private static long count = 0;

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] parts = br.readLine().split("\\s+");
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        count = 0;

        sort(nums, 0, nums.length - 1);

        System.out.println(count);
        // System.out.println(Arrays.toString(nums));

    }

    private static void sort(final int[] nums, final int start, final int end) {
        if (start >= end) {
            return;
        }

        count += end - start + 1;

        int mid = (start + end) / 2;

        swap(nums, start, mid);

        int ptr = start + 1;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < nums[start]) {
                swap(nums, i, ptr);
                ptr++;
            }
        }

        swap(nums, start, ptr - 1);
        sort(nums, start, ptr - 2);
        sort(nums, ptr, end);
    }

    private static void swap(final int[] nums, final int start, final int mid) {
        int tmp = nums[start];
        nums[start] = nums[mid];
        nums[mid] = tmp;
    }

}
