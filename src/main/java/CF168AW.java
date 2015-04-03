
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF168AW {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");
        int n = Integer.parseInt(parts[0]);
        long k = Integer.parseInt(parts[1]);

        if(k == 1){
            System.out.println(n);
            return;
        }
        parts = br.readLine().split("\\s+");
        long[]arr = new long[n];
        boolean[]arrBool = new boolean[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(parts[i]);
        }

        Arrays.sort(arr);
        //List<Integer> sets = new ArrayList<Integer>();
        int cntTotal = 0;
        for(int i = 0; i < arr.length; i++){
            if(arrBool[i] || arr[i] == 0)continue;
            //System.out.println(i);
            long num = arr[i];
            arrBool[i] = true;
            int cnt = 1;

            int prevIdx = i;
            while(true){
                int idx = Arrays.binarySearch(arr, prevIdx+1, arr.length, num*k);
                if(idx < 0)break;
                arrBool[idx] = true;
                ++cnt;
                prevIdx = idx;
                //System.out.println(num);
                num = num*k;
            }
            //sets.add(cnt);
            if(cnt % 2 == 0){
                cntTotal += cnt/2;
            } else {
                cntTotal += (cnt/2) + 1;
            }
        }

        System.out.println(cntTotal);

    }

}
