import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class CF87DIV1D {

	private static int[][] cache = null;

	private static final char MUL = '*';
	private static final char SUB = '-';
	private static final char ADD = '+';
	private static final char DIV = '/';

	private static final Set<Character> signs = new HashSet<Character>();

	public static void main(String[] args) throws IOException {
		signs.add(MUL);
		signs.add(SUB);
		signs.add(ADD);
		signs.add(DIV);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		if (!isValid(arr)) {
			System.out.println(0);
			return;
		}
		cache = new int[arr.length][arr.length];
		int res = solve(arr, 0, arr.length - 1);
		System.out.println(res);
	}

	private static boolean isValid(char[] arr) {
		if (arr[0] == MUL || arr[0] == DIV)
			return false;
		if (signs.contains(arr[arr.length - 1]))
			return false;
		for (int i = 0; i < arr.length; i++) {
			int cnt = 0;
			if (signs.contains(arr[i])) {
				cnt++;
				for (int j = i + 1; j < arr.length && signs.contains(arr[j]); j++, cnt++) {
				}
				if (cnt > 2)
					return false;
				if (cnt == 2) {
					if (arr[i + 1] == MUL || arr[i + 1] == DIV)
						return false;
				}
			}
		}
		return true;
	}

	private static int solve(char[] arr, int i, int j) {
		if (i > j || i < 0 || j >= arr.length)
			return 0;
		if (i == j && signs.contains(arr[i]))
			return 0;
		boolean noSign = true;
		for (int cnt = i; cnt <= j; cnt++) {
			if (signs.contains(arr[cnt])) {
				noSign = false;
				break;
			}
		}
		if (noSign) {
			if (i - 1 >= 0 && !signs.contains(arr[i - 1])) {
				return 0;
			}
			if (j + 1 < arr.length && !signs.contains(arr[j + 1])) {
				return 0;
			}
			return 1;
		}
		// in the middle of the number
		if (i - 1 >= 0 && !signs.contains(arr[i - 1])) {
			return 0;
		}
		if (j + 1 < arr.length && !signs.contains(arr[j + 1])) {
			return 0;
		}
		int res = 0;
		for (int cnt = i + 1; cnt < j; cnt++) {
			res += solve(arr, i, cnt) + solve(arr, cnt + 1, j);
		}
		return res;
	}
}
