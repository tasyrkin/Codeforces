import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CF110D {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[]pairs = br.readLine().split("\\s+");
		int n = Integer.parseInt(pairs[0]);
		int m = Integer.parseInt(pairs[1]);
		Map<Integer, List<Integer>> posSent = new HashMap<Integer, List<Integer>>();
		Map<Integer, List<Integer>> negSent = new HashMap<Integer, List<Integer>>();
		boolean[] truth = new boolean[n];
		boolean[] lie = new boolean[n];
		int totalNeg = 0;
		for(int i = 0; i < n; i++){
			String sent = br.readLine();
			int pers = Integer.parseInt(sent.substring(1))-1;
			if(sent.charAt(0)=='+'){
				List<Integer> list = posSent.get(pers);
				if(list == null){
					list = new ArrayList<Integer>();
				}
				list.add(i);
				posSent.put(pers, list);
			} else {
				totalNeg++;
				List<Integer> list = negSent.get(pers);
				if(list == null){
					list = new ArrayList<Integer>();
				}
				list.add(i);
				negSent.put(pers, list);				
			}
		}
		if(m == 0){
			for(int i = 0; i < n; i++){
				System.out.println("Lie");				
			}
			return;
		}
		int posIters = 0;
		int negIters = 0;
		for(int i = 0; i < n; i++){
			List<Integer> currPos = posSent.get(i);
			int numOfTruth = currPos != null ? currPos.size() : 0;
			List<Integer> currNeg = negSent.get(i);
			numOfTruth += (currNeg != null ? (totalNeg - currNeg.size()) : totalNeg);
			if(numOfTruth == m){
				if(currPos != null){
					for(int pers : currPos){
						truth[pers] = true;
					}
				}
				if(posIters<2){
					posIters++;
					Iterator<Integer> posIter = posSent.keySet().iterator();
					while(posIter.hasNext()){
						int key = posIter.next();
						if(key != i){
							List<Integer> l = posSent.get(key);
							if(l != null){
								for(int pers2 : l){
									lie[pers2] = true;
								}
							}
						}
					}
				}
				if(currNeg != null){
					for(int pers : currNeg){
						lie[pers] = true;
					}					
				}
				if(negIters<2){
					negIters++;
					Iterator<Integer> negIter = negSent.keySet().iterator();
					while(negIter.hasNext()){
						int key = negIter.next();
						if(key != i){
							List<Integer> l = negSent.get(key);
							if(l != null){
								for(int pers2 : l){
									truth[pers2] = true;
								}
							}
						}
					}
				}
			}
		}
		for(int i = 0; i < n; i++){
			if(truth[i] && lie[i]){
				System.out.println("Not defined");
			}
			else if(truth[i]){
				System.out.println("Truth");
			} else {
				System.out.println("Lie");
			}
		}
	}

}
