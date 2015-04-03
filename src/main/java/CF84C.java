import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CF84C {

	public static int[] array = null;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		array = new int[n + 1];
		Arrays.fill(array, Integer.MAX_VALUE);
		array[0] = 0;
		for (int i = 1; i <= n; i++) {
			int four = Integer.MAX_VALUE;
			if (i - 4 >= 0)
				four = array[i - 4];
			int seven = Integer.MAX_VALUE;
			if (i - 7 >= 0)
				seven = array[i - 7];
			int diff = four <= seven ? four : seven;
			array[i] = diff == Integer.MAX_VALUE ? diff : diff + 1;
		}
		int cnt = n;
		int fours = 0;
		int sevens = 0;
		while (cnt > 0) {
			int currVal = array[cnt];
			if (currVal == Integer.MAX_VALUE) {
				System.out.println(-1);
				return;
			}
			int four = Integer.MAX_VALUE;
			if (cnt - 4 >= 0)
				four = array[cnt - 4];
			int seven = Integer.MAX_VALUE;
			if (cnt - 7 >= 0)
				seven = array[cnt - 7];
			if (four != Integer.MAX_VALUE || seven != Integer.MAX_VALUE) {
				int diff = four <= seven ? 4 : 7;
				if (diff == 4) {
					fours++;
					cnt -= 4;
				} else {
					sevens++;
					cnt -= 7;
				}
			} else {
				System.out.println(-1);
				return;
			}
		}
		for(int i = 0; i < fours; i++){
			System.out.print(4);
		}
		for(int i = 0; i < sevens; i++){
			System.out.print(7);
		}
		System.out.println();
	}
}
