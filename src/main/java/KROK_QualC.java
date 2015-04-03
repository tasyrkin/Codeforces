import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class KROK_QualC {

	public static class Pair{
		int t;
		int x;
		public Pair(int t, int x){
			this.t = t;
			this.x = x;
		}
	}
	
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
		Pair[]studs = new Pair[n];
		for(int i = 0; i < n; i++){
			parts = br.readLine().split("\\s+");
			int t = Integer.parseInt(parts[0]);
			int x = Integer.parseInt(parts[1]);
			studs[i] = new Pair(t, x);
		}
		int t = 0;
		int stud = 0;
		int dist = 0;
		boolean isFirst = true;
		while(stud<n){
			int afterPassed = stud;
			for(; afterPassed-stud < m && afterPassed < n; afterPassed++){
				if(studs[afterPassed].t > t)break;
			}
			int timeToWait = 0;
			if(afterPassed - stud == m || afterPassed == n){
//				stud = afterPassed;
			} else {
				int lastTime = 0;
				for(; afterPassed-stud < m && afterPassed < n; afterPassed++){
					lastTime = studs[afterPassed].t; 
				}
				timeToWait += lastTime - t;
			}
			t += timeToWait;
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for(int i = stud; i < afterPassed; i++){
				Integer num = map.get(studs[i].x);
				if(num == null){
					num = 0;
				}
				num++;
				map.put(studs[i].x, num);
			}
			
			Integer[] distances = map.keySet().toArray(new Integer[map.keySet().size()]);
			Arrays.sort(distances);
			Map<Integer, Integer> arrival = new HashMap<Integer, Integer>();
			dist = 0;
			for(int distance : distances){
				Integer num = map.get(distance);
				t += distance-dist;
				arrival.put(distance, t);
				t += 1 + num/2;
				dist = distance;
			}
			for(int i = stud; i < afterPassed; i++){
				System.out.print((isFirst?"":" ") + arrival.get(studs[i].x));
				isFirst = false;
			}
			t += dist;
			stud = afterPassed;
		}		
		System.out.print("\n");
	}

}
