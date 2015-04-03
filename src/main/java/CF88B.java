import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF88B {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().split("\\s+");
		int a = Integer.parseInt(parts[0]);
		int b = Integer.parseInt(parts[1]);
		int mod = Integer.parseInt(parts[2]);
		if (a == 0 || mod == 1) {
			System.out.println(2);
			return;
		}
		if (a == 1000000000)
			a--;
		if (b == 1000000000)
			b--;
		long i = 1;
		for (i = 1; i <= a; i++) {
			long num = i * 1000000000;
			long div1 = num / mod;
			if (mod * (div1 + 1) > num + b && num % mod != 0) {
				break;
			}
			int cnt = 0;
			if (num % mod == 0) {
				System.out.println(2);
				return;
			}
			if (mod * (div1 + 1) <= num + b)
				cnt++;
			if (mod * (div1 + 2) <= num + b)
				cnt++;
			if (cnt >= 2) {
				System.out.println(2);
				return;
			}
		}
		if (i > a) {
			System.out.println(2);
			return;
		}
		String res = i + "";
		String nulls = "000000000";
		System.out.println("1 " + nulls.substring(0, 9 - res.length()) + res);
	}
}
