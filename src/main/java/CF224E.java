import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF224E {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String i = br.readLine();
        String[] ps = new String[2];
        ps[0] = i.substring(0, i.indexOf('|'));
        ps[1] = i.substring(i.indexOf('|') + 1, i.length());

        String g = br.readLine();
        /*if ((ps[0].length() + ps[1].length() + g.length()) % 2 != 0) {
         *  System.out.println("Impossible");
         *  return;
         *}*/

        for (char ch : g.toCharArray()) {
            if (ps[0].length() < ps[1].length()) {
                ps[0] = ps[0] + ch;
            } else {
                ps[1] = ps[1] + ch;
            }
        }

        if (ps[0].length() != ps[1].length()) {
            System.out.println("Impossible");
            return;
        }

        System.out.println(ps[0] + "|" + ps[1]);

    }
}
