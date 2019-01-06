import java.util.Scanner;

public class CF507A {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int whiteCost = sc.nextInt();
        final int blackCost = sc.nextInt();

        final int[] dancers = new int[n];
        for (int i = 0; i < dancers.length; i++) {
            dancers[i] = sc.nextInt();
        }

        int toPay = 0;

        for (int i = 0; i < n / 2; i++) {
            if (dancers[i] == 2 || dancers[n - 1 - i] == 2) {
                if (dancers[i] == 2 && dancers[n - 1 - i] == 2) {
                    toPay += 2 * (whiteCost > blackCost ? blackCost : whiteCost);
                } else {
                    if (dancers[i] == 2) {
                        toPay += dancers[n - 1 - i] == 1 ? blackCost : whiteCost;
                    }
                    if (dancers[n - 1 - i] == 2) {
                        toPay += dancers[i] == 1 ? blackCost : whiteCost;
                    }
                }
            } else if (dancers[i] != dancers[n - 1 - i]) {
                System.out.println(-1);
                return;
            }
        }
        if (n % 2 == 1 && dancers[n / 2] == 2) {
            toPay += whiteCost > blackCost ? blackCost : whiteCost;
        }
        System.out.println(toPay);
    }

}
