import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class VKCup2012R2C {

	public static class Pair{
		int beg;
		int end;
		public Pair(int beg, int end){
			this.beg = beg;
			this.end = end;
		}
	}
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[]a = br.readLine().toCharArray();
		char[]b = br.readLine().toCharArray();
		List<Pair> notMatched = new ArrayList<Pair>();
		int res = 0;
		for(int i = 0; i < a.length; i++){
			sec: for(int j = i; j < a.length; j++){
				for(Pair p : notMatched){
					if(!(p.beg > j || p.end < i)){
						p.beg = Math.min(p.beg, i);
						p.beg = Math.max(p.end, j);
						continue sec; 
					}
				}
				int cnt = i;
				for(int k = 0; k < b.length && cnt <= j; k++){
					if(a[cnt] == b[k]){
						cnt++;
					}
				}
				if(cnt != j+1){
					for(Pair p : notMatched){
						if(!(p.beg > j || p.end < i)){
							p.beg = Math.min(p.beg, i);
							p.beg = Math.max(p.end, j);
							continue sec; 
						}
					}
					Pair p = new Pair(i, j);
					notMatched.add(p);
				} else {
					res = (res + 1) % 1000000007;
				}
			}
		}
		System.out.println(res);
	}
}
