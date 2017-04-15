import java.util.Arrays;
import java.util.Scanner;

public class CF707B {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        reverse(arr);

        if (arr[0] < 0) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 == -1) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }

        int positiveSum = 0;
        for (int i = 0; i < arr.length && arr[i] > 0; i++) {
            positiveSum += arr[i];
        }

        if (positiveSum % 2 == 1) {
            System.out.println(positiveSum);
        } else {
            int plusNegative = positiveSum;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < 0 && arr[i] % 2 == -1) {
                    plusNegative += arr[i];
                    break;
                }
            }
            int minusPositive = positiveSum;
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] > 0 && arr[i] % 2 == 1) {
                    minusPositive -= arr[i];
                    break;
                }
            }
            if (plusNegative == positiveSum) {
                System.out.println(minusPositive);
            } else if (minusPositive == positiveSum) {
                System.out.println(plusNegative);
            } else {
                System.out.println(Math.max(plusNegative, minusPositive));
            }
        }

    }

    private static void reverse(final int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = tmp;
        }
    }
}
