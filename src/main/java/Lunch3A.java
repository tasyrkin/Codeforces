import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author  tasyrkin
 * @since   2013/08/25
 */
public class Lunch3A {

    public static void main(final String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] nums = br.readLine().split("\\s+");

        int[] sums = new int[31];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(nums[i]);
            for (int j = 0; j < sums.length; j++) {
                sums[j] += (num >> j) & 0x1;
            }
        }

        // System.out.println(Arrays.toString(sums));

        long res = 0;
        for (int j = 0; j < sums.length; j++) {
            long m = sums[j];
            res += (long) (1 << j) * ((m * (m - 1)) / 2);
        }

        System.out.println(res);

    }

}
