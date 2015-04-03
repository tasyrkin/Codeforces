import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;


public class CF67B {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String mynick = null;
		String line = null;
		int cnt = -1;
		HashMap<String, Integer> ratingMap = new HashMap<String, Integer>();
		while(null!= (line = br.readLine())){
			if(cnt == -1){
				mynick = line;
				cnt = Integer.parseInt(br.readLine());
				continue;
			}
			String[] parts = line.split("\\s+");
			int rank = 0;
			String name1 = null;
			String name2 = null;
			if(parts[1].equals("posted")){
				rank = 15;
				name1 = parts[0];
				name2 = parts[3].substring(0, parts[3].indexOf('\''));
			}
			else if(parts[1].equals("commented")){
				rank = 10;
				name1 = parts[0];
				name2 = parts[3].substring(0, parts[3].indexOf('\''));
			}
			else{
				rank = 5;
				name1 = parts[0];
				name2 = parts[2].substring(0, parts[2].indexOf('\''));
			}
			if(!mynick.equals(name1)&&!mynick.equals(name2)){
				setRating(ratingMap, 0, name1);
				setRating(ratingMap, 0, name2);
			}
			else if(!mynick.equals(name1)){
				setRating(ratingMap, rank, name1);
			}
			else if(!mynick.equals(name2)){
				setRating(ratingMap, rank, name2);
			}
			if(--cnt<=0)break;
		}
		int[] rankArray = new int[ratingMap.size()];
		String[] namesArray = new String[ratingMap.size()];
		Iterator<String> namesIter = ratingMap.keySet().iterator();
		int i = 0;
		while(namesIter.hasNext()){
			String name = namesIter.next();
			rankArray[i] = ratingMap.get(name);
			namesArray[i] = name;
			//System.out.println(rankArray[i] + " " + namesArray[i]);
			++i;			
		}
		int[] num = new int[15*rankArray.length+1];
		for(i = 0;i<rankArray.length;i++){
			num[rankArray[i]]++;
		}

		int[] pos = new int[num.length];
		for(i=1; i<num.length; i++){
			pos[i] = pos[i-1]+num[i-1];
		}
		
		for(i = 0; i < pos.length; i++){
			System.out.print(pos[i] + " ");
		}	
		System.out.print("\n");
		
		int[] rankArrayNew = new int[rankArray.length];
		String[] namesArrayNew = new String[rankArray.length];
		for(i=0; i<rankArray.length;i++){
			int rankIndex = rankArray[i];
			rankArrayNew[pos[rankIndex]] = rankArray[i];
			namesArrayNew[pos[rankIndex]] = namesArray[i];
			//System.out.println(i + " " + rankArray[i] + " " + namesArray[i]);
			pos[rankIndex]++;
		}
		
		for(i = 0; i < pos.length; i++)pos[i] = pos[i]-num[i];

		for(i = 0; i < rankArrayNew.length; i++){
			System.out.println(i + ":" + rankArrayNew[i] + " " + namesArrayNew[i]);
		}
		
		ArrayList<String> list = new ArrayList<String>(); 
		for(i = pos.length-1; i >= 0; i--){
			for(int j = pos[i]; j<pos[i]+num[i];j++){
				list.add(namesArray[j]);
			}
			Collections.sort(list);
			//System.out.println(list.size());
			Iterator<String> iter = list.iterator();
			while(iter.hasNext()){
				System.out.println(iter.next());
			}
			list.clear();
		}		
	}

	private static void setRating(HashMap<String, Integer> ratingMap, int rank, String name1) {
		Integer currRating = rank;
		if(ratingMap.containsKey(name1)){
			currRating +=ratingMap.get(name1); 
		}
		ratingMap.put(name1, currRating);
	}

}
