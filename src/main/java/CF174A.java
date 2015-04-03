import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class CF174A {
    static String[] r = {
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine());

        for(String s : r){
            String[]part = s.split(":");
            int n = Integer.parseInt(part[0]);
            if(n == p){
                System.out.println(part[1]);
                return;
            }
        }

        /*
        l:
        for(int p = 2; p <= 2000; p++)
        {
            for(int j = 2; j < p; j++){
                if(p%j==0){
                    continue l;
                }
            }
            int res = 0;
            BigInteger bip = new BigInteger("" + p);

            main:
            for(int x = 1; x < p; x++){
                BigInteger bi = new BigInteger("" + x);
                BigInteger bipow = bi.pow(p-1);
                if(bipow.subtract(BigInteger.ONE).mod(bip).equals(BigInteger.ZERO)){
                    for(int i = 1; i < p-1; i++){
                        if(bi.subtract(BigInteger.ONE).mod(bip).equals(BigInteger.ZERO)){

                            continue main;
                        }
                        bi = bi.multiply(new BigInteger("" + x));
                    }
                    ++res;
                }
            }
            System.out.println("\"" + p + ":" + res + "\",");
        }
        */
     }

}
