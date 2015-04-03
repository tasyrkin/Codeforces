import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CF79C {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] n = br.readLine().toCharArray();
		Integer k = Integer.parseInt(br.readLine());
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < n.length; i++){
			Integer num = map.get(n[i]);
			if(num==null){
				num = 0;
			}
			num++;
			map.put(n[i], num);			
		}
		//HashMap<Integer,ArrayList<Character>> invMap = new HashMap<Integer, ArrayList<Character>>();
		Integer[] vals = map.values().toArray(new Integer[map.values().size()]);
		Arrays.sort(vals);
		Set<Character> toRemove = new HashSet<Character>();
		for(Integer count : vals){
			if(k>=count){
				k-=count;
				Iterator<Character> iter = map.keySet().iterator();
				while(iter.hasNext()){
					Character ch = iter.next();
					Integer currCount = map.get(ch);
					if(currCount == count){
						map.remove(ch);
						toRemove.add(ch);
						break;
					}
				}
			}
		}
		System.out.println(map.keySet().size());
		for(int i = 0; i < n.length; i++){
			if(!toRemove.contains(n[i]))
				System.out.print(n[i]);
		}
		System.out.println();
	}

}
