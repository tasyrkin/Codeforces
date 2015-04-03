import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CF96A {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		if(str.contains("H")||str.contains("Q")||str.contains("9")){
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
