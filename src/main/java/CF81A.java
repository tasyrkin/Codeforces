import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CF81A {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().split("\\s+");
		int n = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);
		int k = (int)(100*Float.parseFloat(parts[2]));
		Map<String, Integer> abilities = new HashMap<String, Integer>();
		Set<String> currentAbilities = new HashSet<String>();
		for(int i = 0; i < n; i++){
			parts = br.readLine().split("\\s+");
			int newPower = (Integer.parseInt(parts[1])*k)/100;
			currentAbilities.add(parts[0]);
			if(newPower>=100){
				abilities.put(parts[0], newPower);
			}
		}		
		for(int i = 0; i < m; i++){
			String ability = br.readLine(); 
			if(!abilities.containsKey(ability)){
				abilities.put(ability, 0);
			}
		}
		String[] orderedAbilities = abilities.keySet().toArray(new String[abilities.keySet().size()]);
		Arrays.sort(orderedAbilities);
		System.out.println(orderedAbilities.length);
		for(String ability : orderedAbilities){
			System.out.println(ability + " " + abilities.get(ability));
		}
	}
}
