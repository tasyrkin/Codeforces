import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CFEND2013A {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]ps = br.readLine().split("\\s+");
        int a = Integer.parseInt(ps[0]);
        int b = Integer.parseInt(ps[1]);
        int res = 0;
        int rest = 0;
        while(a > 0){
            res += a;
            int nw = (a+rest) / b;
            rest = (a+rest) % b;
            a = nw;
        }
        
        System.out.println(res);

    }

}
