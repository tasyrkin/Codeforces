import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF99A {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] parts = br.readLine().split("\\s+");
		int[] num = new int[parts.length];
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(parts[i]);
		}
		int cnt = 0;
		while (n > 0) {
			for (int i = 0; i < num.length; i++) {
				cnt++;
				n -= num[i];
				if (n <= 0)
					break;
			}
		}
		int ans = cnt % 7;
		if(ans == 0)ans = 7;
		System.out.println(ans);
	}

}
