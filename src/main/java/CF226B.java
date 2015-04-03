import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF226B {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        char[] b = "bear".toCharArray();
        int cnt = 0;
        int lastMatch = -1;
        m:
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (i + j >= str.length || b[j] != str[i + j]) {
                    continue m;
                }
            }

            int bef = i - (lastMatch == -1 ? -1 : lastMatch);
            int aft = (str.length - (i + 3));
            cnt += bef * aft;
            lastMatch = i;
        }

        System.out.println(cnt);
    }
}
