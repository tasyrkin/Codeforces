import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CF114A {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[]parts = br.readLine().split("\\s+");
		int n = Integer.parseInt(parts[0]);
		int x = Integer.parseInt(parts[1]);
		int y = Integer.parseInt(parts[2]);
		
		int necc = (y*n) % 100 == 0 ? (y*n) / 100 : ((y*n) / 100) + 1;
		if(necc - x <= 0){
			System.out.println(0);
		} else {
			System.out.println(necc - x);
		}
	}
}
