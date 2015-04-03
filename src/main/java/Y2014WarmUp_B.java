import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author  tasyrkin
 * @since   2014/05/16
 */
public class Y2014WarmUp_B {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] parts = null;
        Set<String> r = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            parts = br.readLine().split("\\s+");

            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            int c = Integer.parseInt(parts[2]);

            int[] arr = {a, b, c};

            Arrays.sort(arr);
            r.add(arr[0] + "," + arr[1] + "," + arr[2]);

        }

        System.out.println(r.size());

    }

}
