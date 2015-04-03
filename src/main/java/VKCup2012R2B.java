import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class VKCup2012R2B {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] a = br.readLine().toCharArray();
		char[] s = br.readLine().toCharArray();
		Arrays.sort(s);
		for(int i = 0; i < s.length / 2; i++){
			char tmp = s[i];
			s[i] = s[s.length - 1 - i];
			s[s.length - 1 - i] = tmp;
		}

		int cnt = 0;
		for(int i = 0; i < a.length; i++){
			if(cnt >= s.length)break;
			if(a[i]<s[cnt]){
				a[i] = s[cnt];
				cnt++;
			}
		}
		System.out.println(new String(a));
	}
}
