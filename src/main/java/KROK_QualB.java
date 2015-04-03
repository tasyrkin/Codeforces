import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class KROK_QualB {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[]parts = br.readLine().split("\\s+");
		int a = Integer.parseInt(parts[0]);
		int b = Integer.parseInt(parts[1]);
		int m = Integer.parseInt(parts[2]);
		int r0 = Integer.parseInt(parts[3]);
		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		list.add(r0);
		set.add(r0);
		int rCurr = (a*r0 + b) % m;
		int cnt = 0;
		main: while(true){
			cnt = 0;
			if(set.contains(rCurr)){
				for(Integer test : list){
					if(rCurr == test){
						break main;
					}
					cnt++;
				}			
			}
			list.add(rCurr);
			set.add(rCurr);
			rCurr = (a*rCurr + b) % m;
		}
		System.out.println(list.size() - cnt);
	}

}
