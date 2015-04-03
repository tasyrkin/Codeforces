import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF244A {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] parts = br.readLine().split("\\s+");
        int crime = 0;
        int pol = 0;
        for (String s : parts) {
            int event = Integer.parseInt(s);
            if (event == -1) {
                if (pol > 0) {
                    pol--;
                } else {
                    crime++;
                }
            } else {
                pol += event;
            }
        }

        System.out.println(crime);
    }

}
