import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CF115A {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[]a = br.readLine().toCharArray();
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < a.length-2; i++){
			if(i > 7)continue;
			for(int j = i+1; j < a.length-1; j++){
				if(j-i>7||a.length-1-j>7)continue;
				String r1S = new String(a,0,i+1);
				if(r1S.length()>1&&r1S.charAt(0)=='0'){
					continue;
				}
				int r1 = Integer.parseInt(r1S);
				String r2S = new String(a,i+1,j-i);
				if(r2S.length()>1&&r2S.charAt(0)=='0'){
					continue;
				}
				int r2 = Integer.parseInt(r2S);
				String r3S = new String(a,j+1,a.length-1-j);
				if(r3S.length()>1&&r3S.charAt(0)=='0'){
					continue;
				}
				
				int r3 = Integer.parseInt(r3S);
				if(r1>1000000||r2>1000000||r3>1000000)continue;
				if(r1+r2+r3>max){
					max = r1+r2+r3; 
				}
			}
		}
		System.out.println(max==Integer.MIN_VALUE?-1:max);
	}

}
