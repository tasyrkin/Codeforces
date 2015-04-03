import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF282A {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();

        cnt.put(0, 2);
        cnt.put(1, 7);
        cnt.put(2, 2);
        cnt.put(3, 3);
        cnt.put(4, 3);
        cnt.put(5, 4);
        cnt.put(6, 2);
        cnt.put(7, 5);
        cnt.put(8, 1);
        cnt.put(9, 2);

        char[] arr = sc.next().toCharArray();

        System.out.println(cnt.get(Integer.parseInt("" + arr[0])) * cnt.get(Integer.parseInt("" + arr[1])));

    }
}
