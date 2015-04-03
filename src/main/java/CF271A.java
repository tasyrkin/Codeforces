import java.util.Scanner;

public class CF271A {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] keyboard = new String[] {"qwertyuiop", "asdfghjkl;", "zxcvbnm,./"};

        char dir = sc.next().toCharArray()[0];
        char[] typed = sc.next().toCharArray();
        for (char chTyped : typed) {
            for (String kbString : keyboard) {
                int idx = kbString.indexOf(chTyped);
                if (idx >= 0) {
                    System.out.print(dir == 'R' ? kbString.charAt(idx - 1) : kbString.charAt(idx + 1));
                    break;
                }
            }
        }

        System.out.println();
    }
}
