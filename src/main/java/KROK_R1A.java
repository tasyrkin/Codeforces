import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class KROK_R1A {

	public static boolean isFirstWin(char r1, char r2){
		if(r1 == 'R'){
			if(r2=='S')return true;
			return false;
		}
		else if(r1 == 'S'){
			if(r2 == 'R')return false;
			else return true;
		}
		else if(r1 == 'P'){
			if(r2 == 'R')return true;
			return false;
		}
		return false;
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[]nik = br.readLine().toCharArray();
		char[]pol = br.readLine().toCharArray();
		if(nik.length == pol.length || n <= Math.max(nik.length,pol.length)){
			whenEqual(n, nik, pol);
			return;
		}
		int lcd = LCD(nik.length, pol.length);
		int iterNik = 0;
		int iterPol = 0;
		char[]nikNew = new char[lcd];
		char[]polNew = new char[lcd];
		for(int i = 0; i < lcd; i++){
			nikNew[i] = nik[iterNik++];
			polNew[i] = pol[iterPol++];
			if(iterNik == nik.length)iterNik = 0;
			if(iterPol == pol.length)iterPol = 0;
		}
		whenEqual(n, nikNew, polNew);
//		int nikN = lcd/nik.length;
//		int polN = lcd/pol.length;
//		int rNik = 0;
//		int rPol = 0;
//		int cnt = 0;
//		while(nikN>0&&polN>0){
//			if(nik[iterNik] != pol[iterPol]){
//				boolean r = isFirstWin(nik[iterNik], pol[iterPol]);
//				if(r){
//					rPol++;
//				} else {
//					rNik++;
//				}
//			}
//			iterNik++;
//			iterPol++;
//			cnt++;
//			if(iterNik == nik.length){
//				nikN--;
//				iterNik = 0;
//			}
//			if(iterPol == pol.length){
//				polN--;
//				iterPol = 0;
//			}
//			if(cnt == n){
//				System.out.println(rNik + " " + rPol);
//				return;
//			}
//		}
//		int mult = n/lcd;
//		rNik *= mult;
//		rPol *= mult;
//		if(n%lcd == 0){
//			System.out.println(rNik + " " + rPol);
//			return;
//		}
//		n = n%lcd;
//		iterNik = 0;
//		iterPol = 0;
//		cnt = 0;
//		while(true){
//			if(nik[iterNik] != pol[iterPol]){
//				boolean r = isFirstWin(nik[iterNik], pol[iterPol]);
//				if(r){
//					rPol++;
//				} else {
//					rNik++;
//				}
//			}
//			iterNik++;
//			iterPol++;
//			cnt++;
//			if(iterNik == nik.length){
//				nikN--;
//				iterNik = 0;
//			}
//			if(iterPol == pol.length){
//				polN--;
//				iterPol = 0;
//			}
//			if(cnt == n){
//				System.out.println(rNik + " " + rPol);
//				return;
//			}
//		}
		
	}

	private static void whenEqual(int n, char[] nik, char[] pol) {
		int rNik = 0;
		int rPol = 0;
		int iterNik = 0;
		int iterPol = 0;			
		for(int i = 0; i < Math.min(Math.max(nik.length,pol.length), n); i++){
			if(nik[iterNik] == pol[iterPol]){
				iterNik++;
				iterPol++;
				if(iterNik == nik.length)iterNik=0;
				if(iterPol== pol.length)iterPol=0;
				continue;
			}
			boolean r = isFirstWin(nik[iterNik], pol[iterPol]);
			if(r){
				rPol++;
			} else {
				rNik++;
			}
			iterNik++;
			iterPol++;
			if(iterNik == nik.length)iterNik=0;
			if(iterPol== pol.length)iterPol=0;
		}
		if(n <= Math.max(nik.length,pol.length)){
			System.out.println(rNik + " " + rPol);
			return;
		}
		int mult = n/nik.length;
		rPol *= mult;
		rNik *= mult;
		if(n%nik.length==0){
			System.out.println(rNik + " " + rPol);
			return;
		}
		for(int i = 0; i < n%nik.length; i++){
			if(nik[i] == pol[i])continue;
			boolean r = isFirstWin(nik[i], pol[i]);
			if(r){
				rPol++;
			} else {
				rNik++;
			}
		}
		System.out.println(rNik + " " + rPol);
		return;
	}
	public static int GCD(int a, int b){
		if(a<b)return GCD(b,a);
		if(b == 0)return a;
		return GCD(b, a%b);
	}
	public static int LCD(int a, int b){
		return (a*b)/GCD(a,b);
	}

}
