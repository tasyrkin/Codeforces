import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VKCup2012R3C {

	public static class Pair{
		int s;
		int f;
		public Pair(int si, int fi){
			s = si;
			f = fi;
		}
		public String toString(){
			return (s+1) + " " + (f+1);
		}
	}
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[]a = new int[n];
		String[]parts = br.readLine().split("\\s+");
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < a.length; i++){
			a[i] = Integer.parseInt(parts[i]);
			set.add(a[i]);
		}
		Integer[] b = set.toArray(new Integer[set.size()]);
		Arrays.sort(b);
		int cnt = b.length-1;
		List<Pair> res = new ArrayList<Pair>();
		main: while(true){
			int left = -1;
			int right = -1;
			for(int i = 0; i < a.length; i++){
				if(a[i] == b[cnt]){
					if(i-1>=0){
						left = a[i-1];
					}
					int j = i+1;
					for(; j<a.length && a[j] == b[cnt]; j++){						
					}
					if(j<=a.length-1){
						right = a[j];
					}
					int down = Math.max(left, right);
					if(down == -1){
						for(int k = 0; k < b[cnt]; k++){
							res.add(new Pair(i,j-1));
						}
						break main;
					} else {
						for(int k = i; k<j; k++){
							a[k] = down;
						}
						for(int k = 0; k < b[cnt]-down; k++){
							res.add(new Pair(i,j-1));
						}						
					}
				}
			}
			cnt--;
			if(b[cnt]==0)break;
		}
		System.out.println(res.size());
		for(Pair p : res){
			System.out.println(p.toString());
		}
	}
}
