import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CF113A {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[]parts = br.readLine().split("\\s+");
		int n = Integer.parseInt(parts[0]);
		int k = Integer.parseInt(parts[1]);
		int[]p = new int[n];
		int[]t = new int[n];
		for(int i = 0; i < n; i++){
			parts = br.readLine().split("\\s+");
			p[i] = Integer.parseInt(parts[0]);
			t[i] = Integer.parseInt(parts[1]);
		}
		int place = 1;
		for(int i = 50; i >= 0; i--){
			List<Integer> tasks = new ArrayList<Integer>();
			List<Integer> time = new ArrayList<Integer>();
			for(int j = 0; j < n; j++){
				if(p[j] == i){
					tasks.add(j);
					time.add(t[j]);
				}
			}
			if(tasks.size() == 0) continue;
			Collections.sort(time);
			int m = 0;
			for(int j = 0; j < time.size();){
				m = j;
				for(; m < time.size(); m++){
					if(time.get(j) != time.get(m)){
						break;
					}
				}
				if(place <= k && k < (place+m-j)){
					System.out.println(m-j);
					return;
				}
				place += m-j;
				j += m-j;
			}
		}
		System.out.println(0);
	}
}