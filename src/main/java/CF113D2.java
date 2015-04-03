import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * not solved
 * 
 * @author tim
 * 
 */
public class CF113D2 {

	public static class Client {
		int d;
		int l;

		public Client(int d, int l) {
			this.d = d;
			this.l = l;
		}
	}

	public static class Goods implements Comparable<Goods> {
		int c;
		Integer s;
		List<Integer> candidates = null;

		public Goods(int c, int s) {
			this.c = c;
			this.s = s;
			candidates = new ArrayList<Integer>();
		}

		public void addCandidate(int num) {
			candidates.add(num);
		}

		@Override
		public int compareTo(Goods o) {
			return s.compareTo(o.s);
		}

		@Override
		public boolean equals(Object o) {
			if (o != null && o instanceof Goods) {
				Goods oth = (Goods) o;
				return s.equals(oth.s);
			}
			return false;
		}
	}

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Goods[] goods = new Goods[n];
		String[] pairs = null;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			pairs = br.readLine().split("\\s+");
			int c = Integer.parseInt(pairs[0]);
			int s = Integer.parseInt(pairs[1]);
			goods[i] = new Goods(c, s);
			map.put(s, i);
		}
		int m = Integer.parseInt(br.readLine());
		long[][][] dp = new long[m + 1][n][2];
		int[] back = new int[n];
		int[] prev = new int[n];
		Client[] clients = new Client[m];
		Arrays.fill(back, -1);
		Arrays.fill(prev, -1);
		for (int i = 0; i < m; i++) {
			pairs = br.readLine().split("\\s+");
			int d = Integer.parseInt(pairs[0]);
			int l = Integer.parseInt(pairs[1]);
			clients[i] = new Client(d, l);
			if (i == 0) {
				if (goods[map.get(l)].c <= d) {
					dp[1][map.get(l)][1] = goods[map.get(l)].c;
					back[map.get(l)] = i;
					prev[1] = 0;
				}
				if (goods[map.get(l + 1)].c <= d) {
					dp[1][map.get(l + 1)][1] = goods[map.get(l + 1)].c;
					back[map.get(l + 1)] = i;
					prev[1] = 0;
				}
			} else {
				boolean needPrev = true;
				long maxPrev = Math.max(dp[i][map.get(l)][0] + goods[map.get(l)].c,
						dp[i][map.get(l + 1)][1] + goods[map.get(l)].c);
				if (goods[map.get(l)].c <= d && maxPrev > dp[i + 1][map.get(l)][1]) {
					back[map.get(l)] = i;
					dp[i + 1][map.get(l)][1] = maxPrev;
					prev[i + 1] = i;
					needPrev = false;
				}
				maxPrev = Math.max(dp[i][map.get(l + 1)][0] + goods[map.get(l + 1)].c,
						dp[i][map.get(l)][1] + goods[map.get(l + 1)].c);
				if (goods[map.get(l + 1)].c <= d && maxPrev > dp[i + 1][map.get(l + 1)][1]) {
					back[map.get(l + 1)] = i;
					dp[i + 1][map.get(l + 1)][1] = maxPrev;
					prev[i + 1] = i;
					needPrev = false;
				}
				dp[i + 1][map.get(l)][0] = dp[i][map.get(l)][0];
				dp[i + 1][map.get(l + 1)][0] = dp[i][map.get(l + 1)][0];
				if (needPrev) {
					prev[i + 1] = prev[i];
				}
			}
		}
		long revenue = Math.max(Math.max(dp[m][map.get(clients[m - 1].l)][0],
				dp[m][map.get(clients[m - 1].l + 1)][0]), Math.max(
				dp[m][map.get(clients[m - 1].l)][1], dp[m][map.get(clients[m - 1].l + 1)][1]));
		System.out.println(revenue);
		System.out.println(Arrays.toString(back));
//		System.out.println(Arrays.toString(prev));
		int num = 0;
		for (int i = prev.length - 1; i >= 1; i--) {
			if (prev[i] != prev[i - 1]) {
				num++;
			}
		}
		System.out.println(num);
		for (int i = prev.length - 1; i >= 1; i--) {
			if (prev[i] != prev[i - 1]) {
				int pairNum = -1;
				System.out.println(prev[i] + " " + map.get(clients[prev[i]].l));
			}
		}
	}
}
