import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF222A {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]ps = br.readLine().split("\\s+");
        int a = Integer.parseInt(ps[0]);
        int b = Integer.parseInt(ps[1]);
        int f = 0,s= 0,n= 0;
        for(int i = 1; i <= 6; i++){
            if(Math.abs(i - a) < Math.abs(i - b)){
                f++;
            } else if(Math.abs(i - a)> Math.abs(i - b)){
                s++;
            } else {
                n++;
            }
        }
        System.out.println(f + " " + n + " " + s);

    }

}
