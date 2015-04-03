import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF94A {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] parts = br.readLine().split("\\s+");
		int[] nums = new int[n];
		int sum = 0;
		for (int i = 0; i < parts.length; i++) {
			nums[i] = Integer.parseInt(parts[i]);
			sum += nums[i];
		}
		int cases = 0;
		if (sum % 2 == 0) {
			for (int i = 0; i < parts.length; i++) {
				if(nums[i]%2==0)cases++;
			}
		} else {
			for (int i = 0; i < parts.length; i++) {
				if(nums[i]%2==1)cases++;
			}			
		}
		System.out.println(cases);
	}
}
