import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AVITO_B {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Map<Integer, Integer> chemForcesElements = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            final int element = sc.nextInt();
            final int price = sc.nextInt();
            sum += price;
            chemForcesElements.put(element, price);
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            final int element = sc.nextInt();
            final int price = sc.nextInt();

            final Integer chemPrice = chemForcesElements.get(element);
            if (chemPrice != null) {
                if (chemPrice < price) {
                    sum -= chemPrice;
                    sum += price;
                }
            } else {
                sum += price;
            }
        }

        System.out.println(sum);
    }
}
