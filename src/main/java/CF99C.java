import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CF99C {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().split("\\s+");
		int n = Integer.parseInt(parts[0]);
		int k = Integer.parseInt(parts[1]);
		char[][][] poem = new char[n][4][];
		for (int i = 0; i < 4 * n; i++) {
			poem[i / 4][i % 4] = br.readLine().toCharArray();
		}
		Map<Integer, String> rhythm = new HashMap<Integer, String>();
		for (int i = 0; i < n; i++) {			
			boolean[][] isRhythm = new boolean[4][4];
			int[]lastVocalIdx = new int[4];
			lastVocalIdx[0] = getVocalIdx(poem[i][0], k);
			lastVocalIdx[1] = getVocalIdx(poem[i][1], k);
			lastVocalIdx[2] = getVocalIdx(poem[i][2], k);
			lastVocalIdx[3] = getVocalIdx(poem[i][3], k);
			
			for (int j = 0; j < 4; j++) {
				if(lastVocalIdx[j] == -1)continue;
				for (int m = j+1; m < 4; m++) {
					if(lastVocalIdx[m] == -1)continue;
					int lenJ = poem[i][j].length - lastVocalIdx[j];
					int lenM = poem[i][m].length - lastVocalIdx[m];
					if(lenJ != lenM)continue;
					boolean cmpRes = true;
					for(int len = 0; len < lenJ; len++){
						if(poem[i][j][lastVocalIdx[j]+len]!=poem[i][m][lastVocalIdx[m]+len]){
							cmpRes = false;
							break;
						}
					}
					isRhythm[j][m] = cmpRes;
					isRhythm[m][j] = cmpRes;
				}				
			}
			
			if (isRhythm[0][1] && isRhythm[1][2] && isRhythm[2][3]) {
				rhythm.put(i, "aaaa");
			} else if (isRhythm[0][1] && isRhythm[2][3]) {
				rhythm.put(i, "aabb");
			} else if (isRhythm[0][3] && isRhythm[1][2]) {
				rhythm.put(i, "abba");
			} else if (isRhythm[0][2] && isRhythm[1][3]) {
				rhythm.put(i, "abab");
			} else {
				rhythm.put(i, "NO");
			}
		}
		Map<String, Integer> resMap = new HashMap<String, Integer>();
		Iterator<Integer> iter = rhythm.keySet().iterator();
		while (iter.hasNext()) {
			String rhythmStr = rhythm.get(iter.next());
			Integer num = resMap.get(rhythmStr);
			if(num == null){
				num = 0;
			}
			num++;
			resMap.put(rhythmStr, num);
		}
		int size = resMap.keySet().size();
		if(size>2||size==0){
			System.out.println("NO");
		} else if(size==2){
			Iterator<String> iter2 = resMap.keySet().iterator();
			String a = iter2.next();
			String b = iter2.next();
			if("NO".equals(a)||"NO".equals(b)){
				System.out.println("NO");
			}
			else if("aaaa".equals(a)||"aaaa".equals(b)){
				 if(!"aaaa".equals(a)){
					 System.out.println(a);
				 } else {
					 System.out.println(b);
				 }
			} else {
				System.out.println("NO");
			}
		} else {
			Iterator<String> iter1 = resMap.keySet().iterator();
			System.out.println(iter1.next());
		}
	}

	public static int getVocalIdx(char[] a, int k) {
		for (int i = a.length - 1; i >= 0; i--) {
			if (a[i] == 'a' || a[i] == 'e' || a[i] == 'i' || a[i] == 'o'
					|| a[i] == 'u') {
				--k;
				if (k == 0)
					return i;
			}
		}
		return -1;
	}
}
