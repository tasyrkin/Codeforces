import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author: tasyrkin
 * @since: 2014/01/05
 */
public class Hashes {

    public static final long MOD = 1511;
    public static final long PRIME = 31;

    static long[] gcd(long p, long q) {
        if (q == 0)
            return new long[] { p, 1, 0 };

        long[] vals = gcd(q, p % q);
        long d = vals[0];
        long a = vals[2];
        long b = vals[1] - (p / q) * vals[2];
        return new long[] { d, a, b };
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        char[] arr = s.toCharArray();

        long[] gcdres = gcd(MOD, PRIME);
        System.out.println("gcdres:" + Arrays.toString(gcdres));
        long revert = gcdres[2];


        long[]pows = new long[arr.length];
        pows[0] = 1;
        for(int i = 1; i < pows.length; i++){
            pows[i] = (pows[i-1] * PRIME) % MOD;
        }

        long lenHash = 0;
        for(int len = 1; len <= arr.length; len++){
            lenHash = (lenHash + (pows[len-1] * (arr[len-1] - 'a' + 1)) % MOD ) % MOD;

            Set<Long> metHashes = new HashSet<Long>();
            metHashes.add(lenHash);

            long currHash = lenHash;

            long calculatedHash = 0;
            long p = 1;
            for(int i = 0; i < len; i++){
                calculatedHash = (calculatedHash + ((arr[i]-'a' + 1) * p) % MOD) % MOD;
                p = (p*PRIME) % MOD;
            }

            if(calculatedHash != currHash)
            System.out.println(String.format("string [%s-%s]: fast %s, calculated: %s", 0, len-1, currHash, calculatedHash));
            

            for(int start = 1; start <= arr.length-len; start++){

                currHash = (currHash + MOD - ((arr[start-1]-'a' + 1)) % MOD) % MOD ;
                currHash = (currHash * revert) % MOD;
                currHash = (currHash + (pows[len-1] * (arr[start+len-1]-'a' + 1)) % MOD) % MOD ;
                
                //System.out.println(String.format("fast hash [%s-%s]: %s", start, start+len-1, currHash));
                
                calculatedHash = 0;
                p = 1;
                for(int i = start; i < start+len; i++){
                    calculatedHash = (calculatedHash + ((arr[i]-'a' + 1) * p) % MOD) % MOD;
                    p = (p*PRIME) % MOD;
                }

                if(calculatedHash != currHash)
                System.out.println(String.format("string [%s-%s]: fast %s, calculated: %s", start, start+len-1, currHash, calculatedHash));

            }
        }

    }
}
