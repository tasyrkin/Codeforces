import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Iterator;
import java.util.LinkedList;

public class CF243B {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        String[] mat = new String[n];
        for (int i = 0; i < n; i++) {
            mat[i] = br.readLine();
        }

        int min = n;
        for (int i = n / 2; i >= 1; i /= 2) {
            if (n % i == 0) {
                LinkedList<String> l = new LinkedList<String>();
                for (int j = 0; j < i; j++) {
                    l.add(mat[j]);
                }

                int tot = i;
                while (tot < n) {
                    LinkedList<String> l1 = new LinkedList<String>();
                    Iterator<String> it = l.iterator();
                    while (it.hasNext()) {
                        l1.add(it.next());
                    }

                    Iterator<String> dit = l.descendingIterator();
                    while (dit.hasNext()) {
                        l1.add(dit.next());
                    }

                    l = l1;
                    tot *= 2;
                }

                if (n == l.size()) {
                    int j = 0;
                    boolean same = true;
                    for (String elem : l) {
                        if (!elem.equals(mat[j++])) {
                            same = false;
                            break;
                        }
                    }

                    if (same && i < min) {
                        min = i;
                    }
                }
            }
        }

        System.out.println(min);
    }
}
