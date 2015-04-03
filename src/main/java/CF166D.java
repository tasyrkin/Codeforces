import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author: tasyrkin
 * @since: 2014/01/05
 */
public class CF166D {
    
    public static final long MOD = 1405695061l; 
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
        char[]arr = sc.nextLine().toCharArray();
        char[]badGood = sc.nextLine().toCharArray();
        int k = Integer.parseInt(sc.nextLine());

        long[] gcdres = gcd(MOD, PRIME);
        //System.out.println("gcdres:" + Arrays.toString(gcdres));
        long revert = gcdres[2];
        
        long[]pows = new long[arr.length];
        pows[0] = 1;
        for(int i = 1; i < pows.length; i++){
            pows[i] = (pows[i-1] * PRIME) % MOD;
        }
        
        long result = 0; 
        int lenNumBad = 0;
        long lenHash = 0;
        for(int len = 1; len <= arr.length; len++){
            lenNumBad += badGood[arr[len-1]-'a'] == '1' ? 0 : 1;
            lenHash = (lenHash + (pows[len-1] * (arr[len-1] - 'a' + 1)) % MOD ) % MOD;
            lenHash = lenHash % MOD;

            Set<Long> metHashes = new HashSet<Long>();
            metHashes.add(lenHash);
            if(lenNumBad <= k){
                result++;
                //System.out.println(String.format("hash [%s-%s]: %s", 0, len, lenHash));
            }
            
            int currNumBad = lenNumBad;
            long currHash = lenHash;
            
            for(int start = 1; start <= arr.length-len; start++){
                int minusBad = badGood[arr[start-1]-'a'] == '1' ? 0 : 1;
                int plusBad = badGood[arr[start+len-1]-'a'] == '1' ? 0 : 1;

                currNumBad += plusBad - minusBad;

                currHash = (currHash - ((arr[start-1]-'a' + 1)) % MOD) % MOD;
                currHash = (currHash * revert) % MOD;
                currHash = (currHash + (pows[len-1] * (arr[start+len-1]-'a' + 1)) % MOD) % MOD;
                currHash = currHash % MOD;
                
                /*if(currHash < 0){
                }*/
                                
                if(!metHashes.contains(currHash)){
                    //System.out.println(String.format("hash [%s-%s]: %s", start, start+len-1, currHash));
                    metHashes.add(currHash);
                    if(currNumBad <= k)result++;
                }
            }
        }
        System.out.println(result);
    }
}

