import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF174B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[]ch = br.readLine().toCharArray();
        int ni = 0;
        int na = 0;
        int nf = 0;
        for(int i = 0; i < ch.length; i++){
            if(ch[i] == 'I')ni++;
            if(ch[i] == 'A')na++;
            if(ch[i] == 'F')nf++;
        }
        if(ni > 1){
            System.out.println(0);
            return;
        }
        if(ni == 1){
            System.out.println(1);
            return;
        }
        System.out.println(na);
    }

}
