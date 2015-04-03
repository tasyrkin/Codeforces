import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CF72B {
	static long[] array = null;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		array = new long[n+1];
		String[]parts = br.readLine().split("\\s+");
		for(int i = 0; i < parts.length; i++){
			a[i] = Integer.parseInt(parts[i]);
		}
		for(int i = 1; i < array.length; i++){
			array[i] = array[i-1] + i; 
		}
		long count = 0;
		int idx = 0;
		for(int i = 0; i < a.length; i++){
			if(i+1<a.length){
				if(a[i+1]!=a[i]){
					count += array[i-idx+1];
					idx = i+1;
				}
			}
			else{
				count += array[i-idx+1];
				idx = i+1;
			}
		}
		System.out.println(count);
	}
}