import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CF86B {

	public static class Pair{
		int max;
		String name;
		public Pair(int max, String name){
			this.max = max;
			this.name = name;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().split("\\s+");
		int n = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);

		String[] names = new String[n];
		for (int i = 0; i < n; i++) {
			names[i] = br.readLine();
		}
		Map<String, Set<String>> notFriends = new HashMap<String, Set<String>>();
		for (int i = 0; i < m; i++) {
			parts = br.readLine().split("\\s+");
			assignNotFriend(parts, names, notFriends, 0, 1);
			assignNotFriend(parts, names, notFriends, 1, 0);
		}
		if (m == 0) {
			Arrays.sort(names);
			System.out.println(names.length);
			for(String s : names){
				System.out.println(s);
			}
			return;
		}
		int max = Integer.MIN_VALUE;
		String nameToAdd = null;
		for(int i = 0; i < n; i++){
			Set<String> notFriendsSet = notFriends.get(names[i]);
			Set<String> friends = new HashSet<String>();
			for(int j = 0; j < n; j++){
				if(i==j)continue;
				if(notFriendsSet==null||!notFriendsSet.contains(names[j])){
					friends.add(names[j]);
				}
			}
			int currCount = checkFriends(friends, notFriends, 1);
			if(max < currCount+1){
				max = currCount + 1;
				nameToAdd = names[i];
			}
		}
		System.out.println(max);
		String[]result = new String[max];                                                                                                    
		result[0] = nameToAdd;
		Iterator<Integer> iter = cummulative.keySet().iterator();
		while(iter.hasNext()){
			Integer level = iter.next();
			ArrayList<Pair> list = cummulative.get(level);
			int currMax = Integer.MIN_VALUE;
			for(Pair p : list){
				if(currMax < p.max){
					currMax = p.max;
					nameToAdd = p.name;
				}
			}
			result[level] = nameToAdd;
		}
		Arrays.sort(result);
		for(int i = 0; i < max; i++){
			System.out.println(result[i]);			
		}
	}
	
	public static Map<Integer, ArrayList<Pair>> cummulative = new HashMap<Integer, ArrayList<Pair>>();
	public static Map<String, Integer> cache = new HashMap<String, Integer>();
	
	public static int checkFriends(Set<String> friends, Map<String, Set<String>> notFriends, int level){
		if(friends.isEmpty())return 0;
		Integer max = Integer.MIN_VALUE;
		String nameToAdd = null;
		for(String curr : friends){		
			Set<String> friends2 = new HashSet<String>();
			Set<String> notFriendsSet = notFriends.get(curr); 
			for(String friendToCheck : friends){
				if(curr.equals(friendToCheck))continue;
				if(notFriendsSet==null||!notFriendsSet.contains(friendToCheck)){
					friends2.add(friendToCheck);
				}
			}
			String key = makeKey(friends2,level+1);
			Integer count = cache.get(key);
			if(count==null){
				count = checkFriends(friends2, notFriends, level+1);
				cache.put(key, count);
			}
			if(max<count+1){
				nameToAdd = curr;
				max = count+1;
			}
		}
		ArrayList<Pair> list = cummulative.get(level);
		if(list==null){
			list = new ArrayList<Pair>();
		}
		list.add(new Pair(max,nameToAdd));
		cummulative.put(level, list);
		return max;
	}
	
	private static String makeKey(Set<String> friends2, int i) {
		String[]arr = friends2.toArray(new String[friends2.size()]);
		Arrays.sort(arr);
		StringBuffer sb = new StringBuffer();
		for(String s : arr){
			sb.append(s);
			sb.append(",");
		}
		sb.append(i);
		return sb.toString();
	}

	private static void assignNotFriend(String[] parts, String[] names,
			Map<String, Set<String>> notFriends, int m1, int m2) {
		Set<String> set = notFriends.get(parts[m1]);
		if (set == null) {
			set = new HashSet<String>();
		}
		set.add(parts[m2]);
		notFriends.put(parts[m1], set);
	}	
}
