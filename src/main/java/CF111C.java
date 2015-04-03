import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CF111C {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a = br.readLine().split("\\s+");
		long n = Long.parseLong(a[0]);
		long k = Long.parseLong(a[1]);
		a = br.readLine().split("\\s+");
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			int num = Integer.parseInt(a[i]);
			Integer j = map.get(num);
			if(j == null){
				j = 0;
			}
			j++;
			map.put(num, j);
		}
		long idx = 1;
		Integer[]set = map.keySet().toArray(new Integer[map.keySet().size()]);
		Arrays.sort(set);
		for(Integer l : set){
			long num1 = map.get(l);
			if(idx <= k && k < idx + (num1*n)){
				long sum = 0;
				for(Integer l1 : set){
					long num2 = map.get(l1);
					if(idx+sum <= k && k < idx+sum+num1*num2){
						System.out.println(l + " " + l1);
						return;
					}
					sum += (long)num1*(long)num2;
				}
			}
			idx += (num1*n);
		}
	}

}
