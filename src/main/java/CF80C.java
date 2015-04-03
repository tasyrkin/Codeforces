import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CF80C {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[]parts = br.readLine().split("\\s+");
		int n = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);
		int[][]graph = new int[n][n];
		for(int i = 0; i < m; i++){
			parts = br.readLine().split("\\s+");
			int start = Integer.parseInt(parts[0]);
			int end = Integer.parseInt(parts[0]);
			graph[start-1][end-1] = 1;
			graph[end-1][start-1] = 1;
		}
		
	}	

}
