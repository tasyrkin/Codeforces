import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class CF160B {

    /**
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");
        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);
        parts = br.readLine().split("\\s+");

        int sum = 0;

        int[]nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(parts[i]);
            if(k > 0){
                if(nums[i]<0){
                    nums[i] *= -1;
                    sum += nums[i];
                    --k;
                } else {
                    sum += nums[i];
                }
            } else {
                sum += nums[i];
            }
        }
        Arrays.sort(nums);
        if(k % 2 == 1){
            sum -= 2*nums[0];
        }
        System.out.println(sum);
    }

}
