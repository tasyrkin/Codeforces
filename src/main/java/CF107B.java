import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF107B {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [][] res = new int[n][3];
		String[]names = new String[n];
		for(int i = 0; i < n; i++){
			String[]parts = br.readLine().split("\\s+");
			int k = Integer.parseInt(parts[0]);
			names[i] = parts[1];
			mid: for(int j = 0; j < k; j++){
				char[] num = br.readLine().replace("-", "").toCharArray();
				int eq = 0;
				int dec = 0;
				for(int m = 0; m < num.length-1; m++){
					if(num[m]<num[m+1]){
						res[i][2]++;
						continue mid;
					}
					if(num[m]==num[m+1]){
						eq++;
					}
					if(num[m]>num[m+1]){
						dec++;
					}
				}
				if(eq == num.length-1){
					res[i][0]++;
				} else if (dec == num.length-1) {
					res[i][1]++;
				} else {
					res[i][2]++;
				}
			}
		}
		int[] max = new int[3];
		max[0] = max[1] = max[2] = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < 3; j++){
				if(max[j]<res[i][j]){
					max[j] = res[i][j];
				}
			}
		}
		StringBuffer[] sbs = new StringBuffer[3];
		sbs[0] = new StringBuffer();	
		sbs[1] = new StringBuffer();
		sbs[2] = new StringBuffer();
		for(int i = 0; i < n; i++){
			for(int j = 0; j < 3; j++){
				if(max[j]==res[i][j]){
					sbs[j].append((sbs[j].length()==0?"":", ") + names[i]);
				}
			}
		}
		System.out.println("If you want to call a taxi, you should call: " + sbs[0] + ".");
		System.out.println("If you want to order a pizza, you should call: " + sbs[1] + ".");
		System.out.println("If you want to go to a cafe with a wonderful girl, you should call: " + sbs[2] + ".");
	}

}
