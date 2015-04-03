import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CF107C {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		if(n==1||isPrime2(n, 1000)){
			System.out.println(1);
			System.out.println(0);
			return;
		}
		List<Integer> primes = new ArrayList<Integer>();
		boolean[]prime = new boolean[10000001];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for (int i=2; i<prime.length; ++i){
			if (prime[i]){
				primes.add(i);
				if (i * 1l * i < prime.length)
					for (int j=i*i; j<prime.length; j+=i)
						prime[j] = false;
			}
		}
		for(int p1 : primes){	
			boolean all = true;
			long divPrev = 0;
			for(int p2 : primes){
				long div = p1*p2;
				if(div>n)break;
				divPrev = div;
				if(n%div==0&&n!=div){
//					System.out.println(1);
//					System.out.println(div);
//					return;
//				} else if (n%div==0) {
//					all = false;
//					break;
//				}
				} else {
					
				}
			}
			if(all){
				System.out.println(1);
				System.out.println(divPrev);
				return;				
			}
		}
		System.out.println(2);
//		for(int p : primes){
//			long res1 = n/p;
//			if(res1==0)break;
//			if(n%p==0){
//				if(!isPrime2(res1, 1000)){
//					int notPrimes = 0;
//					int primesNum = 0;
//					for(int p1 : primes){
//						long res2 = res1/p1;
//						if(res2==0)break;
//						if((res1)%p1==0){
//							notPrimes++;
//							if(isPrime2(res2, 1000)){
//								primesNum++;
//							}
//						}
//					}
//					if(notPrimes==primesNum){
//						System.out.println(1);
//						System.out.println(p);
//						return;
//					}
//				}
//			}
//		}
//		System.out.println(2);		
	}
	
	
	public static boolean isPrime2(long n, int t){
		if(n%2==0)return false;
		if(n==1)return false;
		if(n==3)return true;
		long r = n-1;
		int s = 0;
		while(r%2==0){
			r=r/2;
			s++;
		}
		for(int i = 1; i <= t; i++){
			long a = (long)((n-4)*Math.random()+2);
			long rest = 1;
			long pow = r;
			long a1 = a;
			while(pow>0){
				if(pow%2==1)rest=(rest*a1)%n;
				pow/=2;
				a1 = (a1*a1)%n;
			}
			long y = rest;
			if(y!=1&&y!=n-1){
				int j = 1;
				while(j<=s-1&&y!=n-1){
					y = (y*y)%n;
					if(y==1)return false;
					j++;
				}
				if(y!=n-1)return false;
			}
		}
		return true;		
	}
	

}
