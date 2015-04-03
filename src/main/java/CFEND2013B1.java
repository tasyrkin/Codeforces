import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CFEND2013B1 {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[]ps = br.readLine().split("\\s+");
        int[]a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(ps[i]);
        }
        StringBuffer sb = new StringBuffer();
        
        for(int i = 0; i < n - 1; ){
            boolean isLeft = true;
            while(a[i] > 0 || a[i+1] > 0){
                if(isLeft){
                    if(a[i] > 0){
                        sb.append("P");
                        a[i]--;
                    }
                    sb.append("R");
                    isLeft = false;
                } else {
                    if(a[i+1] > 0){
                        sb.append("P");
                        a[i+1]--;
                    }
                    sb.append("L");
                    isLeft = true;
                }
            }
            i += 2;
            if(isLeft){
                if(i < n){
                    sb.append("RR");
                }
            } else {
                if(i < n){
                    sb.append("R");
                }
            }
        }
        if(n % 2 != 0){
            while(a[n-1] > 0){
                sb.append("PLR");
                a[n-1]--;
            }
        }
        System.out.println(sb.toString());
        //System.out.println(sb.length());
    }

}
