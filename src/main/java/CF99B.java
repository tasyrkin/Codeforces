import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CF99B {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[]length = new int[n];
		int[]wide = new int[n];
		int[]hight = new int[n];
		for(int i = 0; i < n; i++){
			String[]parts = br.readLine().split("\\s+");
			length[i] = Integer.parseInt(parts[0]);
			wide[i] = Integer.parseInt(parts[1]);
			hight[i] = Integer.parseInt(parts[2]);
		}
		int m = Integer.parseInt(br.readLine());
		int[]lengthOboi = new int[m];
		int[]wideOboi = new int[m];
		int[]costOboi = new int[m];
		for(int i = 0; i < m; i++){
			String[]parts = br.readLine().split("\\s+");
			lengthOboi[i] = Integer.parseInt(parts[0]);
			wideOboi[i] = Integer.parseInt(parts[1]);
			costOboi[i] = Integer.parseInt(parts[2]);
		}
		int[][]cost = new int[n+1][m];
		for(int room = 0; room < n; room++){
			int P = 2*(length[room]+wide[room]);
			for(int oboi = 0; oboi < m; oboi++){
				int heightCoveredBy = lengthOboi[oboi] / hight[room];
				if(heightCoveredBy==0){
					cost[room][oboi] = Integer.MAX_VALUE;
					continue;
				}
				int rulones = P / (heightCoveredBy*wideOboi[oboi]) + (P % (heightCoveredBy*wideOboi[oboi]) == 0 ? 0 : 1);
				cost[room][oboi] = rulones*costOboi[oboi];
			}
		}
		int res = 0;
		for(int room = 0; room < n; room++){
			int curr = Integer.MAX_VALUE;
			for(int oboi = 0; oboi < m; oboi++){
				if(curr > cost[room][oboi])curr = cost[room][oboi];
			}
			res += curr;
		}
		System.out.println(res);
	}

}
