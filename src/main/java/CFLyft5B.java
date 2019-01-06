import java.util.Arrays;
import java.util.Scanner;

public class CFLyft5B {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int m = sc.nextInt();
        int[] ridersCoords = new int[n];
        int[] driversCoords = new int[m];

        int[] initCoords = new int[n + m];
        for (int i = 0; i < m + n; i++) {
            initCoords[i] = sc.nextInt();
        }
        int riderIdx = 0;
        int driverIdx = 0;
        for (int i = 0; i < m + n; i++) {
            int isDriver = sc.nextInt();
            if (isDriver == 1) {
                driversCoords[driverIdx++] = initCoords[i];
            } else {
                ridersCoords[riderIdx++] = initCoords[i];
            }
        }
        int[] driversWork = new int[m];
        for (int i = 0; i < n; i++) {
            int foundIdx = Arrays.binarySearch(driversCoords, ridersCoords[i]);
            int coord = -(foundIdx + 1);
            if (coord == 0) {
                ++driversWork[coord];
            } else if (coord == driversCoords.length) {
                ++driversWork[coord - 1];
            } else {
                int rightDiff = driversCoords[coord] - ridersCoords[i];
                int leftDiff = ridersCoords[i] - driversCoords[coord - 1];
                if (leftDiff <= rightDiff) {
                    ++driversWork[coord - 1];
                } else {
                    ++driversWork[coord];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(driversWork[i]);
        }

        System.out.println(sb.toString());
    }

}
