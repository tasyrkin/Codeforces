import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF86D {

	private static final int OVERMIN = -1;
	private static final int OVERMAX = 1000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().split("\\s+");
		Integer n = Integer.parseInt(parts[0]);
		Integer m = Integer.parseInt(parts[1]);
		int lastWithWeed = -1;
		char[][] map = new char[n][m];
		for (int i = 0; i < n; i++) {
			String col = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = col.charAt(j);
				if(map[i][j]=='W')lastWithWeed = i;
			}
		}
		if(lastWithWeed==-1){
			System.out.println(0);
			return;
		}
		boolean isRight = true;
		int res = lastWithWeed;
		int colPos = 0;
		for (int i = 0; i < n && i <= lastWithWeed; i++, isRight = !isRight) {			
			int weedPosCurr = isRight?OVERMIN:OVERMAX;
			if(isRight){
				for(int j = colPos; j < m; j++){
					if(map[i][j]=='W')weedPosCurr = j;
				}
			} else {
				for(int j = colPos; j >= 0; j--){
					if(map[i][j]=='W')weedPosCurr = j;
				}
			}			
			int weedPosNext = isRight?OVERMIN:OVERMAX;
			if(i+1<n){
				if(isRight){
					for(int j = colPos; j < m; j++){
						if(map[i+1][j]=='W')weedPosNext = j;
					}
				} else {
					for(int j = colPos; j >= 0; j--){
						if(map[i+1][j]=='W')weedPosNext = j;
					}
				}
			}
			if(isRight){
				int nextMove = Math.max(weedPosCurr, weedPosNext);
				if(nextMove==OVERMIN){
//					res++;
					continue;
				} else {
					res += nextMove-colPos;
					colPos = nextMove;
				}
			} else {
				int nextMove = Math.min(weedPosCurr, weedPosNext);
				if(nextMove==OVERMAX){
//					res++;
					continue;
				} else {
					res += colPos-nextMove;
					colPos = nextMove;
				}
			}
		}
		System.out.println(res);
	}
}
