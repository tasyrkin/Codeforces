

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CF67C {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int cnt = -1;
		long a = -1;
		long b = -1;
		long gcd = -1;
		String[] parts = null;
		while(null != (line = br.readLine())){
			if(cnt==-1){
				parts = line.split("\\s+");
				a = Long.parseLong(parts[0]);
				b = Long.parseLong(parts[1]);
				cnt = Integer.parseInt(br.readLine());
				gcd = GCD(a>b?a:b,a>b?b:a);
				continue;				
			}
			parts = line.split("\\s+");
			long low = Long.parseLong(parts[0]); 
			long high = Long.parseLong(parts[1]);
			if(gcd<low){
				System.out.println(-1);
				continue;
			}
			else if(gcd>=low&&gcd<=high){
				System.out.println(gcd);
				continue;
			}
			long divider = -1;
			long startHigh = Math.min(gcd/2, high);
			for(long num = startHigh; num>=low; num--){
				if(gcd%num==0){
					divider = num;
					break;
				}
			}
			System.out.println(divider);
			if(--cnt<=0)break;
		}
	}

	private boolean[] p;
	private int[] primes;
	private int psz;
	private int[] dp;
	private int m;
	private int[] factors;
	private int fsz;

	void generate(long d) {
		int max = 100000;
		p = new boolean[max];
		primes = new int[max];
		psz = 0;
		primes[psz++] = 2;

		Arrays.fill(p, true);
		for (int i = 4; i < p.length; i+=2) {
			p[i] = false;
		}
		p[0] = p[1] = false;

		for (int i = 3; i < p.length; i+=2) {
			if (p[i]){
				primes[psz++] = i;
				for (int j = 2*i; j < p.length; j+=i) {
					p[j] = false;
				}
			}
		}

		dp = new int[max];

		int index = 0, PF = primes[index];
		int D = (int)d;
		m = -1;
		while (D != 1 && (PF * PF <= D)) {
			while (D % PF == 0) {
				D /= PF;
				dp[index]++;
				m = Math.max(m, index);
			}
			PF = primes[++index];
		}

		if (D != 1) {
			for (int i = index; i < psz; i++) {
				if (primes[i] == D) {
					dp[i]++;
					m = Math.max(m, i);
					break;
				}
			}
		}


		factors = new int[10*max];
		fsz = 0;

		solve(0, 1);

		Arrays.sort(factors, 0, fsz);
	}

	public void solve(int index, int value) {
		if (index > m) {
			factors[fsz++] = value;
			return;
		}

		for (int i = 0; i <= dp[index]; i++) {
			solve(index+1, value);
			value *= primes[index];
		}
	}	

	public static long GCD(long a, long b){
		if(a%b==0){
			return b;
		}
		return GCD(b, a%b);
	}

}
