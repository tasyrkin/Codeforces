import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CF493B {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int B = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        List<Integer> costOfDiv = new LinkedList<>();

        int odd = 0;
        int even = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0) ++even;
            else ++odd;

            if (odd == even) {
                odd = 0;
                even = 0;
                if (i + 1 < n) {
                    costOfDiv.add(Math.abs(a[i] - a[i + 1]));
                }
            }
        }
        final Integer[] costs = costOfDiv.toArray(new Integer[0]);

        Arrays.sort(costs);

        int total = 0;
        for (int cost : costs) {
            B -= cost;
            if (B < 0) {
                break;
            }
            total++;
        }
        System.out.println(total);
    }

}
