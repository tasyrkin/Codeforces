import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF270A {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 4; i < n; i++) {
            if (!isPrime(i) && !isPrime(n - i)) {
                System.out.println(i + " " + (n - i));
                return;
            }
        }

    }

    private static boolean isPrime(final int num) {
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
