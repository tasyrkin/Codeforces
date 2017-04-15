import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Wrong solution
 */
public class CF797C {
    public static void main(String[] args) {

        final Scanner sc = new Scanner(System.in);


        final LinkedList<Character> s = getS(sc);
        final Stack<Character> t = new Stack<>();

        final StringBuilder result = new StringBuilder();

        while (s.size() > 0 || !t.empty()) {
            if (s.size() == 0) {
                while (!t.empty()) {
                    result.append(t.pop());
                }
            } else {
                final Pair minInfo = getMin(s);
                if (!t.empty()) {
                    while (!t.empty() && Character.compare(t.peek(), minInfo.ch) < 0) {
                        result.append(t.pop());
                    }
                }
                while (minInfo.num > 0) {
                    final Character ch = s.removeFirst();
                    t.push(ch);
                    if (minInfo.ch == ch) {
                        minInfo.num--;
                        t.pop();
                        result.append(ch);
                    }
                }
            }
        }

        System.out.println(result.toString());
    }

    private static Pair getMin(final LinkedList<Character> s) {

        Character min = null;
        int cnt = 0;

        for (char ch : s) {
            if (min == null) {
                min = ch;
                cnt = 1;
            } else {
                if (Character.compare(ch, min) < 0) {
                    min = ch;
                    cnt = 1;
                } else if (Character.compare(ch, min) == 0) {
                    cnt++;
                }
            }
        }
        return new Pair(min, cnt);
    }

    private static LinkedList<Character> getS(final Scanner sc) {
        char[] input = sc.next().toCharArray();
        LinkedList<Character> sr = new LinkedList<>();
        for (char ch : input) {
            sr.add(ch);
        }
        return sr;
    }

    private static class Pair {
        char ch;
        int num;

        public Pair(final char ch, final int num) {
            this.ch = ch;
            this.num = num;
        }
    }
}
