import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF107A {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[]parts = br.readLine().split("\\s+");
		int cnt = 0;
		int n = Integer.parseInt(parts[cnt++]);
		int k = Integer.parseInt(parts[cnt++]);
		int l = Integer.parseInt(parts[cnt++]);
		int c = Integer.parseInt(parts[cnt++]);
		int d = Integer.parseInt(parts[cnt++]);
		int p = Integer.parseInt(parts[cnt++]);
		int nl = Integer.parseInt(parts[cnt++]);
		int np = Integer.parseInt(parts[cnt++]);
		int res = Math.min(k*l/nl, Math.min(c*d, p/np))/n;
		System.out.println(res);
	}

}
