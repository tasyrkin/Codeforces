import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF110A {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][]a = new int[n][n];
		for(int i = 0; i < n; i++){
			String[]p = br.readLine().split("\\s+");
			for(int j = 0; j < n; j++){
				a[i][j] = Integer.parseInt(p[j]);
			}
		}
		int res = 0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				int vert = 0;
				for(int i1 = 0; i1 < n; i1++){
					vert += a[i1][j];
				}
				int hor = 0;
				for(int j1 = 0; j1 < n; j1++){
					hor += a[i][j1];
				}
				if(vert>hor)res++;
			}
		}
		System.out.println(res);
	}
}
