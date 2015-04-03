import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF174C {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]parts = null;
        int n = Integer.parseInt(br.readLine());
        long sum = 0;
        int num = 0;
        int[]adds = new int[n+1];
        int[]arr = new int[n+1];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            parts = br.readLine().split("\\s+");
            int t = Integer.parseInt(parts[0]);
            if(t == 1){
                int a = Integer.parseInt(parts[1]);
                int x = Integer.parseInt(parts[2]);
                sum += x*a;
                adds[a-1] += x;
            } else if(t == 2){
                int k = Integer.parseInt(parts[1]);
                sum += k;
                arr[++num] = k;
            } else {
                int k = arr[num] + adds[num];
                adds[num-1] = adds[num-1] + adds[num];
                adds[num] = 0;
                --num;
                sum-=k;
            }
            sb.append("" + ((double)sum/(num+1)) + "\n");
        }
        System.out.println(sb.toString());
    }

}
