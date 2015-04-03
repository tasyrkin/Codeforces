import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CF106A {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		String[]a = br.readLine().split("\\s+");
		int[]sm = new int[a.length];
		for(int i = 0; i < sm.length; i++){
			sm[i] = Integer.parseInt(a[i]);
		}
		Arrays.sort(sm);
		int cnt = 0;
		for(int i = sm.length-1; i>=0 && k>0; i--){
			k -= sm[i];
			if(sm[i]>0)cnt++;
		}
		if(k>0)System.out.println(-1);
		else System.out.println(cnt);
	}

}
