import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CF83B {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] parts = br.readLine().split("\\s+");
		Set<Integer> bitsSet = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			bitsSet.add(Integer.parseInt(parts[i]));
		}
		Integer[] bits = bitsSet.toArray(new Integer[bitsSet.size()]);
		Arrays.sort(bits);
		String res = "NO";
		mylabel: for (int i = 0; i < bits.length - 1; i++) {
			if (bits[i] < bits[i + 1] && 2 * bits[i] > bits[i + 1]) {
				res = "YES";
				break mylabel;
			}

		}
		System.out.println(res);
	}

}
