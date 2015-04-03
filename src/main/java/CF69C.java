import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class CF69C {

	static int a = -1;
	static int b = -1; 
	static int c = -1; 
	static int minDiff = Integer.MAX_VALUE; 
	static int maxLikiness = Integer.MIN_VALUE;
	static HashMap<String,HashSet<String>> liking = null;
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = -1;
		String[] heroes = {"Anka", "Chapay", "Cleo", "Troll", "Dracul","Snowy","Hexadecimal"};
		String[] parts = null;
		String line = null;
		liking = new HashMap<String, HashSet<String>>();
		while(null != (line = br.readLine())){
			if(n == -1){
				n = Integer.parseInt(line);
				continue;
			}
			if(--n<0)break;
			parts = line.split("\\s+");
			HashSet<String> friends = liking.get(parts[0]);
			if(friends==null){
				friends = new HashSet<String>();
			}
			friends.add(parts[2]);
			liking.put(parts[0], friends);
		}
		parts = line.split("\\s+");
		a = Integer.parseInt(parts[0]); 
		b = Integer.parseInt(parts[1]);
		c = Integer.parseInt(parts[2]);
		//System.out.println("a:"+a+",b:"+b+",c:"+c);
		getMinAndLiking(heroes, 0, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
		System.out.println(minDiff + " " + maxLikiness);
	}
	
	public static void getMinAndLiking(String[]heroes, int i, ArrayList<String> team1, ArrayList<String> team2, ArrayList<String> team3){
		if(i>=heroes.length){
			if(team1.size()>0&&team2.size()>0&&team3.size()>0){
				int inA = a / team1.size();
				int inB = b / team2.size();
				int inC = c / team3.size();
				int max = Math.max(inA, Math.max(inB, inC));
				int min = Math.min(inA, Math.min(inB, inC));
				int totalLikiness = getLikiness(team1) + getLikiness(team2) + getLikiness(team3);
				if((max-min)<minDiff){
					minDiff = max-min;
					maxLikiness = totalLikiness;
				}
				else if((max-min) == minDiff){
					if(totalLikiness>maxLikiness){
						maxLikiness = totalLikiness;
					}
				}
			}
			return;
		}
		
		String hero = heroes[i];
		team1.add(hero);
		getMinAndLiking(heroes, i+1, team1, team2, team3);
		team1.remove(hero);
		team2.add(hero);
		getMinAndLiking(heroes, i+1, team1, team2, team3);
		team2.remove(hero);
		team3.add(hero);
		getMinAndLiking(heroes, i+1, team1, team2, team3);
		team3.remove(hero);		
	}
	
	public static int getLikiness(ArrayList<String> team){
		int count = 0;
		for(String s : team){
			HashSet<String> list = liking.get(s);
			if(list == null)continue;
			for(String sint : team){
				if(sint.equals(s))continue;
				if(list.contains(sint))count++;
			}
		}
		return count;
	}

}
