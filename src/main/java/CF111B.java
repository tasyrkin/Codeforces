import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CF111B {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] a = br.readLine().toCharArray();
		int[]num1 = new int[n];
		int[]num2 = new int[n];
		for(int i = 0; i < a.length; i++){
			if(i < n)
				num1[i] = Integer.parseInt(""+a[i]);
			else {
				num2[i-n] = Integer.parseInt(""+a[i]);
			}
		}
		Arrays.sort(num1);
		Arrays.sort(num2);
		boolean isLess = true;
		boolean isMore = true;
		for(int i = 0; i < n; i++){
			if(num1[i] < num2[i]){
				isMore = false;
			} else if(num1[i] > num2[i]){
				isLess = false;
			} else {
				isLess = false;
				isMore = false;
			}			
		}
		if(isLess || isMore){
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

}
