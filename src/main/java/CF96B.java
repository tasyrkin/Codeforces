import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


public class CF96B {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Character, String> map = new HashMap<Character, String>();
		map.put('>', "1000");
		map.put('<', "1001");
		map.put('+', "1010");
		map.put('-', "1011");
		map.put('.', "1100");
		map.put(',', "1101");
		map.put('[', "1110");
		map.put(']', "1111");
//		map.put('>', "8");
//		map.put('<', "9");
//		map.put('+', "10");
//		map.put('-', "11");
//		map.put('.', "12");
//		map.put(',', "13");
//		map.put('[', "14");
//		map.put(']', "15");
		char[] parts = br.readLine().toCharArray();
		StringBuffer sb = new StringBuffer();
		for(char ch : parts){
			sb.append(map.get(ch));
		}
		char[]arr = sb.toString().toCharArray();
		BigDecimal bd = BigDecimal.ZERO;
		int pow = arr.length-1;
		BigDecimal two = new BigDecimal(2);
		for(char ch : arr){
			BigDecimal p = two.pow(pow--);
			bd = bd.add(ch=='1'?p:BigDecimal.ZERO);
		}
		bd = bd.remainder(new BigDecimal("1000003"));
		System.out.println(bd.toString());
	}
}
