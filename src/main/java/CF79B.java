import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class CF79B {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		int cnt = 0;
		while(n.length()!=1){
			n = count(n);
			cnt++;
		}
		System.out.println(cnt);
	}	
	
	public static String count(String num){
		char[] arr = num.toCharArray();
		BigInteger bi = new BigInteger("0");
		for(int i = 0; i < arr.length; i++){
			BigInteger val = new BigInteger(arr[i]+"");
			bi = bi.add(val);			
		}
		return bi.toString();
	}

}
