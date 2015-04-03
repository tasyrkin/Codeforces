import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CF156C {

    /**
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");

        int n = Integer.parseInt(parts[0]);

        if(n == 1){
            System.out.println(1);
            return;
        }

        parts = br.readLine().split("\\s+");

        int[] arr = new int[n];

        //List<HashMap<Integer, Integer>> maps = new ArrayList<HashMap<Integer, Integer>>(n);

        HashMap<Integer, Integer>[] maps = new HashMap[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(parts[i]);
            maps[i] = new HashMap<Integer, Integer>();
            //maps.add(new HashMap<Integer, Integer>());
        }


        int res = 1;

        for(int i = 1; i < n; i++){
            for(int j = i-1; j>=0; j--){
                int delta = arr[i]-arr[j];

                HashMap<Integer, Integer> map = maps[j];

                Integer count = map.get(-1 * delta);
                if(count == null){
                    count = 1;
                }
                count++;

                if(res < count){
                    res = count;
                }

                HashMap<Integer, Integer> map1 = maps[i];

                Integer existing = map1.get(delta);

                if(existing == null){
                    existing = 1;
                }

                if(existing < count){
                    map1.put(delta, count);
                    maps[i] = map1;
                }
            }
        }

        System.out.println(res);

    }

}
