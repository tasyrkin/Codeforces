import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF221A {
    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] r = br.readLine().toCharArray();

        int idx = 0;
        long left = 0;
        long right = 0;
        for(int i = 0; i < r.length; i++){
            if(r[i] == '^' && idx == 0){
                idx = i;
                for(int j = i-1; j >= 0; j--){
                    if(r[j] != '='){
                        int mas = Integer.parseInt(""+r[j]);
                        left += mas*(idx-j);
                    }
                }
                continue;
            }
            if(idx > 0){
                if(r[i] != '='){
                    int mas = Integer.parseInt(""+r[i]);
                    right += mas*(i-idx);
                }
            }
        }

        //System.out.println("left:" + left + ", right:" + right);
        if(left > right){
            System.out.println("left");
        } else if(left < right){
            System.out.println("right");
        } else {
            System.out.println("balance");
        }
    }

}
