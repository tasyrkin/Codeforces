import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF110E {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (--t >= 0) {
			char[] strArr = br.readLine().toCharArray();
			int[][][]dp = new int [strArr.length][26][26];
			dp[0][strArr[0]-'a'][strArr[0]-'a'] = 1;
			for(int i = 1; i < strArr.length; i++){
				
			}
		}
	}
}
