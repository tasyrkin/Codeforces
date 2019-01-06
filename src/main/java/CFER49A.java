import java.util.Scanner;

public class CFER49A {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int T = sc.nextInt();

        main:
        for (int stringIdx = 0; stringIdx < T; stringIdx++) {
            final int n = sc.nextInt();
            final char[] str = sc.next().toCharArray();

            for (int charIdx = 0; charIdx < str.length / 2; charIdx++) {

                final int oppCharIdx = str.length - 1 - charIdx;

                boolean eq = cmp(str, charIdx, oppCharIdx);

                moveForward(str, charIdx);
                eq |= cmp(str, charIdx, oppCharIdx);

                moveForward(str, oppCharIdx);

                if (!eq) {
                    System.out.println("NO");
                    continue main;
                }
            }
            System.out.println("YES");
        }
    }

    private static boolean cmp(final char[] str, final int charIdx, final int charIdxOpposite) {
        return str[charIdx] == str[charIdxOpposite];
    }

    private static void moveBack(final char[] str, final int charIdx) {
        if (str[charIdx] != 'a') {
            str[charIdx] = str[charIdx]--;
        }
    }

    private static void moveForward(final char[] str, final int charIdx) {
        if (str[charIdx] != 'z') {
            str[charIdx] = str[charIdx]++;
        }
    }
}
