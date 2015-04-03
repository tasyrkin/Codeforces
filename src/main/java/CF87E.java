import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF87E {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().split("\\s+");
		Integer n = Integer.parseInt(parts[0]);
		Integer m = Integer.parseInt(parts[1]);
		char[][]map = new char[n][m];
		for(int i = 0; i < n; i++){
			char[]col = br.readLine().toCharArray();
			for(int j = 0; j < n; j++){
				map[i][j] = col[j]; 
			}
		}
		
	}
}
