import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF173A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res = 0;
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            if(s.contains("++")){
                res++;
            }
            if(s.contains("--")){
                --res;
            }
        }
        System.out.println(res);
    }

}
