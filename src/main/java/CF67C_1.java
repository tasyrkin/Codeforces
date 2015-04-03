

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
public class CF67C_1 {
	public void run() {
		try {
			Scanner in = new Scanner(System.in);
			long a = in.nextLong();
			long b = in.nextLong();
			long d = BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).longValue();
			generate(d);
			int n = in.nextInt();
			for (int i = 0; i < n; i++) {
				int low = in.nextInt(), high = in.nextInt();

				int index = Arrays.binarySearch(factors, 0, fsz, high);
				if (index >= 0) {
					System.out.println(high);
				}
				else if (index < 0) {
					index ++;
					index *= -1;
					index--;

					int lind = Arrays.binarySearch(factors, 0, fsz, low);

					if (lind >= 0) {
						if (lind > index) {
							System.out.println(-1);
						}
						else {
							if (factors[index] >= low && factors[index] <= high)
								System.out.println(factors[index]);
							else
								System.out.println("-1");
						}
					}
					else {
						lind ++;
						lind *= -1;

						if (lind > index) {
							System.out.println(-1);
						}
						else {
							if (factors[index] >= low && factors[index] <= high)
								System.out.println(factors[index]);
							else
								System.out.println("-1");
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	boolean[] p;
	int[] primes;
	int psz;
	int[] dp;
	int[] factors;
	int m;
	int fsz;


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


	public static void main(String[] args) {
		new CF67C_1().run();
	}
}