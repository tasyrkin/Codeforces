import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CF83D {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().split("\\s+");
		int n = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);
		int h = Integer.parseInt(parts[2])-1;
		int[]playbb = new int[m];
		parts = br.readLine().split("\\s+");
		int playersLeft = n;
		int allPlayers = 0;
		for(int i = 0; i < parts.length; i++){
			playbb[i] = Integer.parseInt(parts[i]);
			playersLeft -= playbb[i];
			allPlayers+=playbb[i];
		}
		if(playersLeft>0){
			System.out.println(-1.0);
			return;
		}
		if(playbb[h]==1||n==1){
			System.out.println(0);
			return;
		}
		long A = cnk(allPlayers-playbb[h],n-1);
		long B = 0;
		for(int i = 1; i < playbb[h]; i++){
			B += cnk(playbb[h]-1,i)*cnk(allPlayers-playbb[h], n-i+1);
		}
		System.out.println((double)B/(A+B));
	}
	
	public static long cnk(int n, int k){
		int diff = n - k;
		BigDecimal kFact = fact(new BigDecimal(k));
		BigDecimal diffFact = fact(new BigDecimal(diff));
		BigDecimal divider = kFact.multiply(diffFact);
		BigDecimal dividable = fact(new BigDecimal(n));
		BigDecimal res = dividable.divide(divider);
		return res.longValue();
	}
	
	public static BigDecimal fact(BigDecimal k){
		if(k.equals(BigDecimal.ONE)||k.equals(BigDecimal.ZERO)){
			return BigDecimal.ONE;
		}
		BigDecimal kNoOne = k.subtract(BigDecimal.ONE);
		return k.multiply(fact(kNoOne));
	}
}
