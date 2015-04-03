import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF84D {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());		
		for(int i = 1; i <=n; i++){
			char toPrint = 'a';
			if((i-1)%4==0)toPrint = 'a';
			else if((i-2)%4==0)toPrint = 'b';
			else if((i-3)%4==0)toPrint = 'c';
			else toPrint = 'd';
			System.out.print(toPrint);
		}
		System.out.println();
	}
}
