import java.math.BigInteger;
import java.util.Scanner;

public class CF272C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        long res = 0;
        long mod = 1000000007;
        long tmp = (((b*(b-1))/2))%mod;
        for(long i = 1; i <= a; i++){
            long curr = (i*b+1)%mod;
            curr = (curr*tmp)%mod; 
            res = (curr + res)%mod;
        }
        System.out.println(res);
    }                           
}
