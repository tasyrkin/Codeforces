import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CF80B {

	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		//int[]numQs = new int[n];
		String[]parts = br.readLine().split("\\s+");
		long res = 0;
		for(int i = 1; i < n+1; i++){
			//numQs[i] = Integer.parseInt(parts[i]);
			res += ((Long.parseLong(parts[i-1])-1)*i + 1);
		}
		System.out.println(res);
	}
}
