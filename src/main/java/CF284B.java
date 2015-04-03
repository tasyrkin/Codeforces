import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF284B {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<String, String> oneToTwo = new HashMap<String, String>();
        Map<String, String> twoToOne = new HashMap<String, String>();

        for (int i = 0; i < m; i++) {
            String first = sc.next();
            String second = sc.next();
            oneToTwo.put(first, second);
            twoToOne.put(second, first);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String word = sc.next();

            String first;
            String second = oneToTwo.get(word);

            if (second != null) {
                first = word;
            } else {
                first = twoToOne.get(word);
                second = word;
            }

            if (sb.length() > 0) {
                sb.append(" ");
            }

            if (second != null && first != null) {
                if (second.length() < first.length()) {
                    sb.append(second);
                } else {
                    sb.append(first);
                }
            } else if (second != null) {
                sb.append(second);
            } else {
                sb.append(first);
            }

        }

        System.out.println(sb.toString());
    }
}
