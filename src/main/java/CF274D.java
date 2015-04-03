import java.util.Arrays;
import java.util.Scanner;

public class CF274D {
    public static void main(final String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextLong();
        }

        long xRes = search(x, arr);
        long yRes = search(y, arr);
        if (xRes != Integer.MAX_VALUE && yRes != Integer.MAX_VALUE) {
            System.out.println(0);
            return;
        }

        if (xRes != Integer.MAX_VALUE) {
            System.out.println(1);
            System.out.println(y);
            return;
        }

        if (yRes != Integer.MAX_VALUE) {
            System.out.println(1);
            System.out.println(x);
            return;
        }

        long xyRes = search(x + y, arr);
        if (xyRes != Integer.MAX_VALUE) {
            System.out.println(1);
            System.out.println(xyRes - y);
        } else {
            xyRes = search(y - x, arr);
            if (xyRes != Integer.MAX_VALUE) {
                if (xyRes + x > arr[n - 1]) {
                    xyRes = searchBack(y - x, arr);

                    if (xyRes - x < 0) {

                        System.out.println(2);
                        System.out.println(x + " " + y);
                    } else {
                        System.out.println(1);
                        System.out.println(xyRes - x);
                    }

                } else {
                    System.out.println(1);
                    System.out.println(xyRes + x);
                }
            } else {
                System.out.println(2);
                System.out.println(x + " " + y);
            }
        }

    }

    private static long searchBack(final int toSearch, final long[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            long end = arr[i] - toSearch;
            int idx = Arrays.binarySearch(arr, end);
            if (idx >= 0) {
                return arr[idx];
            }
        }

        return Integer.MAX_VALUE;
    }

    private static long search(final long toSearch, final long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            long end = arr[i] + toSearch;
            int idx = Arrays.binarySearch(arr, end);
            if (idx >= 0) {
                return arr[idx];
            }
        }

        return Integer.MAX_VALUE;
    }
}
