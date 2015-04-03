import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF200A {
    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 1;
        String prev = null;
        for (int i = 0; i < n; i++) {
            String curr = br.readLine();
            if (prev == null) {
                prev = curr;
            } else {
                if (prev.charAt(1) == curr.charAt(0)) {
                    cnt++;
                }
            }

            prev = curr;
        }

        System.out.println(cnt);
    }

}
