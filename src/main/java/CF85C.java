import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF85C {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().split("\\s+");
		long n = Long.parseLong(parts[0]);
		long x = Long.parseLong(parts[1]);
		long y = Long.parseLong(parts[2]);
		
		if(y-(n-1)<=0){
			System.out.println(-1);
			return;
		}
		long max = y-(n-1);
		long toCmp = max*max + (n-1); 
		if(toCmp<x){
			System.out.println(-1);
			return;
		}
		System.out.println(max);
		for(int i = 0; i < n-1; i++){
			System.out.println(1);
		}
	}
}
