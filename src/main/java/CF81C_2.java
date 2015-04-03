import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF81C_2 {

	private static class Vipechka {
		int remains_a;
		int need_b;
		int testo_c;
		int cost_d;

		public Vipechka(int remains_a, int need_b, int testo_c, int cost_d) {
			this.remains_a = remains_a;
			this.need_b = need_b;
			this.testo_c = testo_c;
			this.cost_d = cost_d;
		}
	}

	public static int[][] dp = new int[1001][12];

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().split("\\s+");
		int n = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);
		int c = Integer.parseInt(parts[2]);
		int d = Integer.parseInt(parts[3]);
		Vipechka[] vipArr = new Vipechka[m + 1];
		vipArr[0] = new Vipechka(0, 0, c, d);
		for (int i = 1; i <= m; i++) {
			parts = br.readLine().split("\\s+");
			Vipechka vip = new Vipechka(Integer.parseInt(parts[0]),
					Integer.parseInt(parts[1]), Integer.parseInt(parts[2]),
					Integer.parseInt(parts[3]));
			vipArr[i] = vip;
		}

		// dpMine(n, vipArr);
		for (int i = 0; i < vipArr.length; i++) {
			for (int testo = 0; testo <= n; testo++) {
				int nachinkiEnoughFor = vipArr[i].need_b == 0 ? Integer.MAX_VALUE
						: vipArr[i].remains_a / vipArr[i].need_b;
				int testaEnoughFor = testo / vipArr[i].testo_c;
				int maxCanBacke = Math.min(nachinkiEnoughFor, testaEnoughFor);
				for (int k = 0; k <= maxCanBacke; k++) {
					int restTesto = testo - k * vipArr[i].testo_c;
					if (restTesto < 0)
						break;
					int getMoney = (i - 1 >= 0 ? dp[restTesto][i - 1] : 0) + k
							* vipArr[i].cost_d;
					if (dp[testo][i] < getMoney)
						dp[testo][i] = getMoney;
				}
			}
		}
		// int max = Integer.MIN_VALUE;
		// for (int i = 0; i < vipArr.length; i++) {
		// int currMoney = dp[n][i];
		// if (max < currMoney)
		// max = currMoney;
		// }
		System.out.println(dp[n][m]);
	}

	private static void dpMine(int n, Vipechka[] vipArr) {
		for (int testo = 1; testo <= n; testo++) {
			for (int i = 0; i < vipArr.length; i++) {
				int nachinkiEnoughFor = vipArr[i].need_b == 0 ? Integer.MAX_VALUE
						: vipArr[i].remains_a / vipArr[i].need_b;
				int testaEnoughFor = testo / vipArr[i].testo_c;
				int maxCanBacke = Math.min(nachinkiEnoughFor, testaEnoughFor);
				int currMaxMoney = Integer.MIN_VALUE;
				for (int canBake = 0; canBake <= maxCanBacke; canBake++) {
					int currMoney = canBake * vipArr[i].cost_d;
					int currMoneyTmp = currMoney;
					for (int j = 0; j < i; j++) {
						if (testo - canBake * vipArr[i].testo_c > 0) {
							if (currMoney
									+ dp[testo - canBake * vipArr[i].testo_c][j] > currMoneyTmp) {
								currMoneyTmp = currMoney
										+ dp[testo - canBake
												* vipArr[i].testo_c][j];
							}
						}
					}
					if (currMoneyTmp > currMaxMoney)
						currMaxMoney = currMoneyTmp;
				}
				dp[testo][i] = currMaxMoney;
			}
		}
	}

	public static int solve(Vipechka[] vip, int testo, int currIdx) {
		if (currIdx >= vip.length)
			return 0;
		if (currIdx == 0) {
			int nachinkiEnoughFor = vip[currIdx].need_b == 0 ? Integer.MAX_VALUE
					: vip[currIdx].remains_a / vip[currIdx].need_b;
			int testaEnoughFor = testo / vip[currIdx].testo_c;
			int maxCanBacke = Math.min(nachinkiEnoughFor, testaEnoughFor);
			return maxCanBacke * vip[currIdx].cost_d;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < currIdx; i++) {
			int nachinkiEnoughFor = vip[currIdx].need_b == 0 ? Integer.MAX_VALUE
					: vip[currIdx].remains_a / vip[currIdx].need_b;
			int testaEnoughFor = testo / vip[currIdx].testo_c;
			int maxCanBacke = Math.min(nachinkiEnoughFor, testaEnoughFor);
			for (int j = 0; j <= maxCanBacke; j++) {
				int currMoney = j * vip[currIdx].cost_d;
				int adjustMoney = dp[testo - j * vip[currIdx].testo_c][i];
				if (adjustMoney == 0) {
					adjustMoney = solve(vip, testo - j * vip[currIdx].testo_c,
							i);
					dp[testo - j * vip[currIdx].testo_c][i] = adjustMoney;
				}
				currMoney += adjustMoney;
				if (max < currMoney)
					max = currMoney;
			}
		}
		return max;
	}
}