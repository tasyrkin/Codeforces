import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CF106C {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[]a = br.readLine().split("\\s+");
		int[]aint = new int[a.length];
		int[]sorted = new int[10001];
		Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
		for(int i = 0; i < a.length; i++){
			aint[i] = Integer.parseInt(a[i]);
			sorted[aint[i]]++;
			List<Integer> list = map.get(aint[i]);
			if(list == null){
				list = new ArrayList<Integer>();
			}
			list.add(i);
			map.put(aint[i], list);
		}
		a = null;
		List<Integer> resFirst = new ArrayList<Integer>();
		List<Integer> resSecond = new ArrayList<Integer>();
		boolean isFirst = true;
		for(int i = 0; i < sorted.length; i++){
			if(sorted[i]>0){
				List<Integer>list = map.get(i);
				for(Integer pl : list){
					if(isFirst){
						resFirst.add(pl);
					} else {
						resSecond.add(pl);
					}
					isFirst = !isFirst;
				}
//				sorted[i]--;
//				if(sorted[i]%2==0)isFirst = !isFirst;				
			}
		}
		System.out.println(resFirst.size());
		boolean isF = true;
		for(Integer i : resFirst){
			System.out.print((isF?"":" ") + (i+1));
			isF = false;
		}
		isF = true;
		System.out.println();
		System.out.println(resSecond.size());
		for(Integer i : resSecond){
			System.out.print((isF?"":" ") + (i+1));
			isF = false;
		}
		System.out.println();
	}

}
