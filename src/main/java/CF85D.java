import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class CF85D {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] x = new int[n];
		int[] y = new int[n];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			String[] parts = br.readLine().split("\\s+");
			x[i] = Integer.parseInt(parts[0]);
			y[i] = Integer.parseInt(parts[1]);
			if (max < x[i])
				max = x[i];
		}
		int[] pos = new int[max+1];
		for(int i = 0; i < n; i++){
			Integer[]divs = divs(x[i]);
			int cnt = 0;
			for(Integer divider : divs){
				if((i+1)-y[i]<=pos[divider]){
					cnt++;
				}
				pos[divider] = i+1;
			}
			System.out.println(divs.length-cnt);
		}
	}
	
	public static Integer[] divs(int num){
		HashSet<Integer> divs = new HashSet<Integer>();
		for(int i = 1; i*i <= num; i++){
			if(num%i==0){
				divs.add(i);
				divs.add(num/i);
			}
		}
		return divs.toArray(new Integer[divs.size()]);
	}
}
