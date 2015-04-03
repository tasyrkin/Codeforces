import java.util.LinkedList;
import java.util.Scanner;

public class CF282C {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str = sc.next().toCharArray();
        int sharp = 0;
        for (char c : str) {
            if (c == '#') {
                sharp++;
            }
        }

        int balance = 0;
        LinkedList<Integer> l = new LinkedList<Integer>();
        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
            } else {
                if (sharp == 1) {
                    int restBalance = 0;
                    for (int j = i + 1; j < str.length; j++) {
                        if (str[j] == '(') {
                            restBalance++;
                        } else if (str[j] == ')') {
                            restBalance--;
                        }
                    }

                    if (restBalance <= 0 && Math.abs(balance) > Math.abs(restBalance)) {
                        int balToPut = balance + restBalance;
                        balance -= balToPut;
                        l.add(balToPut);
                    } else {
                        System.out.println(-1);
                        return;
                    }
                } else {
                    l.add(1);
                    balance--;
                }

                --sharp;
            }

            if (balance < 0) {
                System.out.println(-1);
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Integer i : l) {
            if (sb.length() > 0) {
                sb.append("\n");
            }

            sb.append(i);
        }

        System.out.println(sb.toString());

    }
}
