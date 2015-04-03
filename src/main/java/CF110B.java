import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CF110B {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[]rads = new int[n];
		String[]p = br.readLine().split("\\s+");		
		int res = 0;
		for(int i = 0; i < n; i++){
			rads[i] = Integer.parseInt(p[i]);
		}
		Arrays.sort(rads);
		for(int i = n-1; i >= 0; i-=2){
			if(i-1>=0){
				res += (rads[i]*rads[i] - rads[i-1]*rads[i-1]);
			} else {
				res += rads[i]*rads[i];
			}
		}
		System.out.println(Math.PI*res);
	}
}
