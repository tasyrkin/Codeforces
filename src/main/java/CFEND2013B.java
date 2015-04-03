import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CFEND2013B {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[]ps = br.readLine().split("\\s+");
        int[]a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(ps[i]);
        }
        StringBuffer sb = new StringBuffer();
        int i = 0;
        boolean isLeft = true;
        main: for(; i < n-1;){
            isLeft = true;
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
            if(isLeft){
                i += 2;
                sb.append("R");
                if(i < n){
                    sb.append("R");
                }
            } else {
                i += 1;
                if(i < n-1){
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
        System.out.println(sb.length());
    }

}
