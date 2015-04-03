import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF86A {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long k = Long.parseLong(br.readLine());
		long l = Long.parseLong(br.readLine());
		
		if(k>l){
			System.out.println("NO");
			return;			
		}
		int cnt = 0;
		while(l>1){
			if(l%k==0){
				cnt++;
				l /= k;
			} else {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
		System.out.println(cnt-1);
	}
}
