import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author  tasyrkin
 * @since   2013/06/23
 */
public class CF189A {
    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] num = br.readLine().toCharArray();

        for (int i = 0; i < num.length;) {
            if (num[i] == '1') {
                if (i + 1 < num.length && num[i + 1] == '4') {
                    if (i + 2 < num.length && num[i + 1] == '4') {
                        i += 3;
                        continue;
                    }

                    i += 2;
                    continue;
                }

                i += 1;
                continue;
            }

            System.out.println("NO");
            return;
        }

        System.out.println("YES");
        return;
    }

}
