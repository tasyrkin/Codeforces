import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CF113C {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[]parts = br.readLine().split("\\s+");
		int n = Integer.parseInt(parts[0]);
		int x = Integer.parseInt(parts[1]);
		parts = br.readLine().split("\\s+");
		List<Integer> l = new ArrayList<Integer>();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++){
			int num = Integer.parseInt(parts[i]);
			l.add(num);
			if(num > max) max = num;
			if(num < min) min = num;
		}
		Collections.sort(l);
		int med = l.get((l.size()+1)/2-1);
		int res = 0;
		if(!l.contains(x)){
			l.add(x);
			Collections.sort(l);
			med = l.get((l.size()+1)/2-1);
			res++;
		}
		while(l.get((l.size()+1)/2-1) != x){
			if(med < x){
				l.add(x+1);				
			} else if(med>x){
				l.add(x-1);
			}
			Collections.sort(l);
			med = l.get((l.size()+1)/2-1);
			res++;
		}
		System.out.println(res);
	}
}