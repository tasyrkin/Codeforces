import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CF99D {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[]a = br.readLine().toCharArray();
		int len = a.length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < len; i++){
			int num = a[i]-'0';
			Integer count = map.get(num);
			if(count==null){
				count = 0;
			}
			count++;
			map.put(num, count);			
		}
//		char[] one = new char[a.length];
//		char[] two = new char[a.length];
		int[][]res = new int[a.length+1][2];		
		a = null;
		for(int i = 1; i <= len; i++){
//			res[i][0] = 
		}
	}

}
