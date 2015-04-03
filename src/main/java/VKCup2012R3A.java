import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class VKCup2012R3A {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[]parts = br.readLine().split("\\s+");
		int n = Integer.parseInt(parts[0]);
		int b = Integer.parseInt(parts[1]);
		int[] a = new int[n];
		int max = 0;
		parts = br.readLine().split("\\s+");
		for(int i = 0; i < a.length; i++){
			a[i] = Integer.parseInt(parts[i]);
			if(max<a[i])max = a[i];
		}
		int diff = 0;
		for(int i = 0; i < a.length; i++){
			diff += max - a[i];
		}
		b -= diff;
		if(b < 0){
			System.out.println(-1);
			return;
		}
		double toAdd = (double)b/n;
		for(int i = 0; i < a.length; i++){
			double res = toAdd+(double)(max-a[i]);
			System.out.println(res);
		}
	}
}
