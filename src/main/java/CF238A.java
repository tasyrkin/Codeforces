import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;

public class CF238A {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] parts = br.readLine().split("\\s+");
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(parts[i]);
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        int[] arr1 = new int[max];
        for (int i = 0; i < arr1.length; i++) {
            int num = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] >= (i + 1)) {
                    num++;
                }
            }

            arr1[i] = num;
        }

        // System.out.println(Arrays.toString(arr1));

        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            int num = 0;
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] >= (n - i)) {
                    num++;
                }
            }

            arr2[i] = num;
        }

        System.out.println(Arrays.toString(arr2).replace("[", "").replace("]", "").replace(",", ""));
    }
}
