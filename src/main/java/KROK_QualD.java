import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class KROK_QualD {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[]parts = br.readLine().split("\\s+");
		int a = Integer.parseInt(parts[0]);
		int n = Integer.parseInt(parts[1]);
		long res = 0;
		for(int diff = 0; diff < n; diff++){
			int num = a + diff;
			int sqrt = (int)Math.sqrt(num);			
			for(int i = sqrt; i >= 1; i--){
				if(num%(i*i)==0){
					res += num/(i*i);
					break;
				}
			}
		}
		System.out.println(res);
	}

}
