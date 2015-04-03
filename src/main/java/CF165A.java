import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CF165A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[]parts = null;
        int[]ks = new int[n];
        int[]as = new int[n];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; i++){
            parts = br.readLine().split("\\s+");
            ks[i] = Integer.parseInt(parts[0]);
            as[i] = Integer.parseInt(parts[1]);
            map.put(ks[i], i);
        }

        Integer[] sides = map.keySet().toArray(new Integer[0]);

        Arrays.sort(sides);

        for(int i = 0; i < sides.length-1; i++){
            int idx1 = map.get(sides[i]);
            int idx2 = map.get(sides[i+1]);
            int divRes = as[idx1];
            for(int j = ks[idx1]; j < ks[idx2]; j++){
                divRes /= 4;
                if(divRes <= 0)break;
            }
            if(divRes > 0){
                int res = 1;
                for(int j = ks[idx1]; j < ks[idx2]; j++){
                    res *= 4;
                }
                int addition = as[idx1] % res != 0 ? 1 : 0;
                as[idx2] = Math.max(as[idx2], (as[idx1] / res) + addition);
            }
        }
        int idx = map.get(sides[sides.length-1]);
        int lastAmount = as[idx];
        int diff = 0;
        while(true){
            ++diff;
            if(lastAmount <= 4) {
                break;
            }
            int additional = lastAmount % 4 != 0? 1 : 0;
            lastAmount /= 4;
            lastAmount += additional;
        }
        System.out.println(ks[idx]+diff);
    }
}
