import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class KROK_R1B {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[]parts = br.readLine().split("\\s+");
		int n = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);
		char[][]carta = new char[n][m];
		int[][]res = new int[n][m];
		for(int i = 0; i < n; i++){
			carta[i] = br.readLine().toCharArray();
			if(i == 0){
				for(int j = 0; j < m; j++){
					if(carta[i][j]=='#')res[i][j] = 1;
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(carta[i][j] == '.')continue;
				int val = res[i][j];
				if(val == 0)continue;
				if(i == n-1){
					if(val>0){
						if(min > val)min = val;
					}
				}
				if(res[i][j]%2==1){
					for(int k = i+1; k < n; k++){
						if(carta[k][j]=='#'){
							if(res[k][j]>0){
								res[k][j] = Math.min(res[k][j], val+1);
							} else {
								res[k][j] = val+1;
							}
						}
					}					
				} else {
					for(int k = j+1; k < m; k++){
						if(carta[i][k]=='#'){
							if(res[i][k]>0){
								res[i][k] = Math.min(res[i][k], val+1);
							} else {
								res[i][k] = val+1;
							}
						}
					}					
				}
			}
		}
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}

}
