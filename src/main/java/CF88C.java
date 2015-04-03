import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CF88C {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][]arr = new char[n][n];
		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		int f = -1,s = -1;		
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
//			char[]row = br.readLine().toCharArray();
			int cnt = 0;
			for(int j = 0; j < n; j++){
				if(arr[i][j]=='1')cnt++;
			}			
			if(f!=-1)continue;
			ArrayList<Integer> list = map.get(cnt);
			if(list==null){
				list = new ArrayList<Integer>();
			} else {
				f = list.get(0);
				s = i;
//				break;
			}
			list.add(i);
			map.put(cnt, list);
		}
		if(s==-1||f==-1){
			System.out.println(-1);
			return;
		}
		for (int i = 0; i < n; i++) {
			if(arr[f][s]=='1'){
				if(arr[s][i]=='1'&&arr[i][f]=='1'){
					System.out.println((f+1) + " " + (s+1) + " " + (i+1));
					return;
				}
			} else if (arr[s][f]=='1'){
				if(arr[f][i]=='1'&&arr[i][s]=='1'){
					System.out.println((f+1) + " " + (i+1) + " " + (s+1));
					return;
				}
			}
		}
	}
}
