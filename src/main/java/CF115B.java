import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CF115B {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> map = new HashMap<String, Integer>();
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++){
			String[]parts = br.readLine().split("\\s+");
			Integer num = map.get(parts[0]);
			if(num==null)num = 0;
			map.put(parts[0], Math.max(num, Integer.parseInt(parts[1])));
		}
		int num = map.keySet().size();
		System.out.println(num);
		for(String name : map.keySet()){
			int val = map.get(name);
			int worse = 0; 
			int eq = 0;
			int bet = 0;
			for(String name1 : map.keySet()){
				int val1 = map.get(name1);
				if(val>val1)worse++;
				if(val==val1)eq++;
				if(val<val1)bet++;
			}
			if(100*bet>50*num){
				System.out.println(name + " noob");
			} else if(100*(worse+eq)>=99*num){
				System.out.println(name + " pro");
			} else if(100*(worse+eq)>=50*num&&100*(bet)>20*num){
				System.out.println(name + " random");
			} else if(100*(worse+eq)>=80*num&&100*(bet)>10*num){
				System.out.println(name + " average");
			} else if(100*(worse+eq)>=90*num&&100*(bet)>1*num){
				System.out.println(name + " hardcore");
			}
		}
	}

}
