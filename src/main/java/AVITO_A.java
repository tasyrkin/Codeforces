import java.util.Scanner;

public class AVITO_A {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final String s = sc.next();

        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (!isPalindrom(s.substring(i, j).toCharArray())) {
                    if (max < j - i) max = j - i;
                }
            }
        }
        System.out.println(max);
    }

    private static boolean isPalindrom(char[] s) {
        for (int i = 0; i <= s.length / 2; i++) {
            if (s[i] != s[s.length - i - 1]) return false;
        }
        return true;
    }
}
