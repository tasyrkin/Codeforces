import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF85A {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine().toLowerCase();
		String b = br.readLine().toLowerCase();
		int res = a.compareTo(b);
		if (res < 0)
			res = -1;
		if (res > 0)
			res = 1;
		System.out.println(res);
	}
}
