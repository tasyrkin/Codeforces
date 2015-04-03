import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Not solved
 * @author tim
 *
 */
public class CF109B {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for(int i = 0; i < n; i++){
			String[]p = br.readLine().split("\\s+");
			int pt = Integer.parseInt(p[0]);
			int mv = Integer.parseInt(p[1]);
			List<Integer> list = map.get(pt);
			if(list == null){
				list = new ArrayList<Integer>();
			}
			list.add(mv);
			map.put(pt, list);
		}
		Integer[] pts = map.keySet().toArray(new Integer[map.keySet().size()]);
		Arrays.sort(pts);
		int res = Integer.MIN_VALUE;
//		int cards = 1;
		for(int i = pts.length-1; i>=0; i--){
			List<Integer> list = map.get(pts[i]);
			Iterator<Integer> iter = list.iterator();
			while(iter.hasNext()){
				Integer mv = iter.next();
				if(mv == 0){
					res = Math.max(res, pts[i]);
					iter.remove();
				}
			}
			if(list.size()==0){
				map.remove(pts[i]);
				pts[i] = -1;
			}
		}
		int cards = 1;
		int currRes = 0;
		for(int i = pts.length-1; i>=0&&cards>0; i--){
//			cards--;
			if(pts[i] == -1)continue;
			List<Integer> l = map.get(pts[i]);
			for(Integer mv : l){
				cards += mv-1;
				currRes += pts[i];
			}
		}
		System.out.println(Math.max(res, currRes));
	}
}
