import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF194A {
    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n * n / 2; i += n / 2) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + n / 2; j++) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }

                sb.append(j + 1);
                sb.append(" ");
                sb.append(((n * n) - j));
            }

            System.out.println(sb.toString());
        }
    }

}
