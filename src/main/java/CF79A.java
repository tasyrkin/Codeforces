import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;


public class CF79A {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("\\s+");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int[] costs = new int[n];
		str = br.readLine().split("\\s+");
		for(int i = 0; i < n; i++){
			costs[i] = Integer.parseInt(str[i]);
		}
		HashMap<Integer,ArrayList<Integer>> maps = new HashMap<Integer, ArrayList<Integer>>();
		for(int i = 0; i < m; i++){
			String[] pair = br.readLine().split("\\s+");
			int a = Integer.parseInt(pair[0]);
			int b = Integer.parseInt(pair[1]);
			ArrayList<Integer> list = maps.get(a);
			if(list == null){
				list = new ArrayList<Integer>();
			}			
			list.add(b);
			maps.put(a, list);
			list = maps.get(b);
			if(list==null){
				list = new ArrayList<Integer>();
			}
			list.add(a);
			maps.put(b, list);
		}
		Iterator<Integer> iter = maps.keySet().iterator();
		Integer minPrice = Integer.MAX_VALUE;
		while(iter.hasNext()){
			Integer curr = iter.next();
			ArrayList<Integer> list = maps.get(curr);
			if(list!=null){
				for(Integer curr2 : list){
					ArrayList<Integer> list2 = maps.get(curr2);
					if(list2!=null){
						for(Integer curr3 : list2){
							ArrayList<Integer> testList = maps.get(curr3);
							if(testList==null)break;
							if(!testList.contains(curr))break;
							Integer newPrice = costs[curr-1]+costs[curr2-1]+costs[curr3-1];
							if(minPrice > newPrice){
								minPrice = newPrice;
							}
						}
					}
				}
			}
		}
		if(minPrice == Integer.MAX_VALUE){
			System.out.println(-1);
		}
		else{
			System.out.println(minPrice);
		}
		
	}	

}
