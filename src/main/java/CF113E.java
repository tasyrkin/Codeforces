import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CF113E {
	
	private static final int MOD = 1000000007;
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n == 1){
			System.out.println(0);
			return;
		}			
		int sa, sb, sc, sd = 0;
		sa = sb = sc = 1;
		int na = 0, nb = 0, nc = 0, nd = 0;
		for(int i = 0; i < n-2; i++){
			na = (((sb + sc)%MOD)%MOD+sd)%MOD;
			nb = (((sc + sa)%MOD)%MOD+sd)%MOD;
			nc = (((sa + sb)%MOD)%MOD+sd)%MOD;
			nd = (((sa + sb)%MOD)%MOD+sc)%MOD;
			sa = na;
			sb = nb;
			sc = nc;
			sd = nd;
		}
		int res = ((sa + sb)%MOD + sc)%MOD; 
		System.out.println(res);
	}

}
