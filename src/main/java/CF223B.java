import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;

public class CF223B {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        String[] ps = br.readLine().split("\\s+");
        int[] a = new int[5001];
        for (int i = 0; i < m; i++) {
            a[Integer.parseInt(ps[i])]++;
        }

        LinkedList<Integer> l = new LinkedList<Integer>();
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] != 0) {
                if (l.size() == 0) {
                    l.add(i);
                } else {
                    if (a[i] >= 2) {
                        l.addFirst(i);
                        l.addLast(i);
                    } else {
                        l.addLast(i);
                    }
                }
            }
        }

        System.out.println(l.size());

        StringBuffer r = new StringBuffer();
        for (Integer i : l) {
            if (r.length() > 0) {
                r.append(" ");
            }

            r.append(i);
        }

        System.out.println(r.toString());

    }
}
