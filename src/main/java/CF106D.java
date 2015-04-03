import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF106D {

	public static int MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		int[][] dp = new int[arr.length + 1][3];
		dp[0][0] = 1;
		dp[0][1] = 1;
		dp[0][2] = 1;
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = (dp[i][0] % MOD + dp[i - 1][0] % MOD + dp[i - 1][1] % MOD + dp[i - 1][2]% MOD)% MOD;
			if (arr[i] == '(') {
				dp[i][1] = (dp[i][1] % MOD + dp[i - 1][0] % MOD + dp[i - 1][2] % MOD);
				dp[i][2] = (dp[i][2] % MOD + dp[i - 1][0] % MOD + dp[i - 1][1] % MOD);
			} else {
				int brackets = 1;
				int j = i-1;
				do {
					if(arr[j]=='(')brackets--;
					else brackets++;
				} while(brackets > 0);
				int[][] currdp = new int[arr.length + 1][3];
				for(int k = 0; k < j; k++){
					currdp[k][0] = dp[k][0];
					currdp[k][1] = dp[k][1];
					currdp[k][2] = dp[k][2];
				}
				for(int k = j; k < i; k++){
					currdp[k][0] = (currdp[i][0] % MOD + currdp[i - 1][0] % MOD + currdp[i - 1][1] % MOD + currdp[i - 1][2]% MOD)% MOD;
					currdp[k][1] = (currdp[i][1] % MOD + currdp[i - 1][0] % MOD + currdp[i - 1][2] % MOD);
				}
				dp[i][2] = (dp[i][2] % MOD + currdp[i - 1][0] % MOD + currdp[i - 1][1] % MOD);
				for(int k = 0; k < j; k++){
					currdp[k][0] = dp[k][0];
					currdp[k][1] = dp[k][1];
					currdp[k][2] = dp[k][2];
				}
				for(int k = j; k < i; k++){
					currdp[k][0] = (currdp[i][0] % MOD + currdp[i - 1][0] % MOD + currdp[i - 1][1] % MOD + currdp[i - 1][2]% MOD)% MOD;
					currdp[k][2] = (currdp[i][2] % MOD + currdp[i - 1][0] % MOD + currdp[i - 1][1] % MOD);
				}
				dp[i][1] = (dp[i][1] % MOD + currdp[i - 1][0] % MOD + currdp[i - 1][2] % MOD);
			}
		}
	}
}
