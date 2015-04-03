import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CF104A {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().split("\\s+");
		int n = Integer.parseInt(parts[0]);
		char[] nums = br.readLine().toCharArray();
		int sum1 = 0;
		int sum2 = 0;
		for(int i = 0; i < n/2; i++){
			if((nums[i] == '4' || nums[i] == '7') && (nums[n/2+i] == '4' || nums[n/2+i] == '7')){
				sum1 += Integer.parseInt(nums[i] + "");
				sum2 += Integer.parseInt(nums[i+n/2] + "");
			} else {
				System.out.println("NO");
				return;
			}
		}
		if(sum1 == sum2){
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
	}

}
