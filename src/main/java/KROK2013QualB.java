import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA. User: admin Date: 4/13/13 Time: 3:35 PM To change this template use File | Settings |
 * File Templates.
 */
public class KROK2013QualB {
    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();

        StringBuilder res = new StringBuilder();
        boolean open = false;
        StringBuilder curr = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (open) {
                if (c == '"') {
                    open = false;
                    res.append("<" + curr.toString() + ">\n");
                    curr = new StringBuilder();
                } else {
                    curr.append(c);
                }
            } else {
                if (c == '"') {
                    open = true;

                    if (curr.length() > 0) {
                        res.append("<" + curr.toString() + ">\n");
                    }

                    curr = new StringBuilder();

                } else if (Character.isWhitespace(c)) {
                    if (curr.length() > 0) {
                        res.append("<" + curr.toString() + ">\n");
                    }

                    curr = new StringBuilder();
                } else {
                    curr.append(c);
                }
            }
        }

        if (curr.length() > 0) {
            res.append("<" + curr.toString() + ">\n");
        }

        System.out.print(res);

    }
}
