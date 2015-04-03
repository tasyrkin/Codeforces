import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF220B {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        
        long result = 1;
        int cnt = -1;
        for(int i = 1; i < arr.length; i++){
            if(Integer.valueOf(""+arr[i-1]) + Integer.valueOf(""+arr[i]) == 9){
                if(cnt == -1){
                    cnt = 2;
                } else cnt++;
            } else {
                if(cnt != -1){
                    if(cnt % 2 != 0){
                        long numbers = (cnt - 1) / 2 + 1;
                        result *= numbers;
                    }
                }
                cnt = -1;
            }
        }
        if(cnt != -1){
            if(cnt % 2 != 0){
                long numbers = (cnt - 1) / 2 + 1;
                
                result *= numbers;
            }
        }
        System.out.println(result);

    }

}
