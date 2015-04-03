import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;

public class CF270C {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] name = new String[n];
        String[] surname = new String[n];
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split("\\s+");
            name[i] = parts[0];
            surname[i] = parts[1];
        }

        String[] parts = br.readLine().split("\\s+");
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = Integer.parseInt(parts[i]) - 1;
        }

        String[] res = new String[n];
        res[0] = sort(name[perm[0]], surname[perm[0]]).s1;
        for (int i = 1; i < n; i++) {
            Pair pair = sort(name[perm[i]], surname[perm[i]]);
            if (res[i - 1].compareTo(pair.s1) < 0) {
                res[i] = pair.s1;
                continue;
            }

            if (res[i - 1].compareTo(pair.s2) < 0) {
                res[i] = pair.s2;
                continue;
            }

            System.out.println("NO");
            return;
        }

        System.out.println("YES");

    }

    private static class Pair {
        String s1;
        String s2;

        private Pair(final String s1, final String s2) {
            this.s1 = s1;
            this.s2 = s2;
        }
    }

    private static Pair sort(final String s, final String s1) {
        String[] arr = new String[2];
        arr[0] = s;
        arr[1] = s1;
        Arrays.sort(arr);
        return new Pair(arr[0], arr[1]);
    }
}
