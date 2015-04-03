import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF113B {

	public static class Pair{
		long x;
		long y;
		public Pair(long x, long y){
			this.x = x;
			this.y = y;
		}
		public String toString(){
			return "("+x+","+y+")";
		}
	}
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Pair[]out = new Pair[n];
		for(int i = 0; i < n; i++){
			String[]pairs = br.readLine().split("\\s+");
			out[i] = new Pair(Long.parseLong(pairs[0]), Long.parseLong(pairs[1]));
		}
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++){
			String[]pairs = br.readLine().split("\\s+");
			long x = Long.parseLong(pairs[0]);
			long y = Long.parseLong(pairs[1]);
			int res = 0;
			int matchPos = 0;
			int matchNeg = 0;
			for(int j = 0; j < n; j++){
				if(x == out[j].x && y == out[j].y){
					System.out.println("NO");
					return;
				}
				int next = j+1;
				if(next>=n)next = 0;
				long y1 = out[j].y - y; 
				long y2 = out[next].y - y;
				if(y1 == y2) {
					if(x <= Math.max(out[j].x, out[next].x) && x >= Math.min(out[j].x, out[next].x) && y2 == 0){
						System.out.println("NO");
						return;						
					}
					if(y2 == 0){
						if(x < Math.min(out[j].x, out[next].x)){
							res--;
						}
						if(x > Math.max(out[j].x, out[next].x)){
							res++;
						}
					}
				}
				else if(out[j].x == out[next].x){
					if(x == out[j].x){
						System.out.println("NO");
						return;						
					}
					if(x < out[j].x){
						res--;
					}
					if(x > out[j].x){
						res++;
					}
				}
				else {
					if(y1*(out[next].x-out[j].x)%(y2-y1) == 0){
						long xint = out[j].x - (y1*(out[next].x-out[j].x)/(y2-y1));
						if(xint == out[j].x || xint == out[next].x){
							if(xint == x){
								System.out.println("NO");
								return;								
							}
							if(x < xint){
								res--;
								matchNeg++;
							}
							else {
								res++;
								matchPos++;
							}
						}
					} else {
						double xinter = out[j].x - (y1*(out[next].x-out[j].x)/(y2-y1));
						if(x <= xinter + 0.0000001 && x >= xinter - 0.0000001){
							System.out.println("NO");
							return;						
						} else if(x < xinter) res--;
						else res++;
					}
				}
			}
			if(res > 0){
				if(res - matchPos + 1 != 0){
					System.out.println("NO");
					return;					
				}
			}
			if(res < 0){
				if(res + matchNeg - 1 != 0){
					System.out.println("NO");
					return;					
				}
			}
		}		
		System.out.println("YES");
	}
}