import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CF111A {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[]a = br.readLine().split("\\s+");
		int[]num = new int[n];
		for(int i = 0; i < n; i++){
			num[i] = Integer.parseInt(a[i]);
		}
		Arrays.sort(num);
		for(int i = num.length-1; i >= 0; i--){
			int more = 0;
			for(int j = i; j < num.length; j++){
				more += num[j];
			}
			int less = 0;
			for(int j = 0; j < i; j++){
				less += num[j];
			}
			if(more > less){
				System.out.println(num.length - i);
				return;
			}
		}
//		System.out.println();
	}

}
