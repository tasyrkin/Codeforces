import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF173C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();
        if(s1.length != s2.length){
            System.out.println("NO");
        } else {
            boolean s1With1 = false;
            boolean s2With1 = false;
            for(int i = 0; i < s1.length; i++){
                if(s1[i] == '1')s1With1 = true;
                if(s2[i] == '1')s2With1 = true;
            }
            System.out.println(s1With1 ^ s2With1 ? "NO" : "YES");
        }
    }

}
