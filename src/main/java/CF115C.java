import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CF115C {

	public static class Pair implements Comparable<Pair>{
		int numFigs;
		Integer costFig;
		public Pair(int n, int c){
			numFigs = n;
			costFig = c;
		}
		@Override
		public int compareTo(Pair o) {			
			return costFig.compareTo(o.costFig);
		}
		
	}
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Pair[]figs = new Pair[n];
		for(int i = 0; i < n; i++){
			String[]parts = br.readLine().split("\\s+");
			figs[i] = new Pair(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
		}
		Arrays.sort(figs);
		int t = Integer.parseInt(br.readLine());
		long[]ps = new long[t];
		long[]psNum = new long[t];
		String[]parts = br.readLine().split("\\s+");
		for(int i = 0; i < t; i++){
			psNum[i] = Long.parseLong(parts[i]);
			if(i>0){
				ps[i] = psNum[i]-psNum[i-1]; 
			} else {
				ps[i] = psNum[i];
			}
		}
		int currT = 1;
		int cnt = 0;
		long res = 0;
		for(int i = 0; i < figs.length; i++){
			int currNum = figs[i].numFigs;
			while(currNum>0){
				if(cnt>=t){
					res += (long)figs[i].costFig*(long)currT*(long)currNum;
					currNum = 0;
					continue;
				}
				if(ps[cnt]<currNum){
					res += (long)figs[i].costFig*(long)currT*(long)ps[cnt];
					currNum -= ps[cnt]; 
					cnt++;
					currT++;
				} else {
					res += (long)figs[i].costFig*(long)currT*(long)currNum;
					ps[cnt] -= currNum;
					currNum = 0;
				}
			}
		}
		System.out.println(res);
	}

}
