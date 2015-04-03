import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF220A {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");
        int cnt = 0;
        int n = Integer.parseInt(parts[cnt++]);
        int m = Integer.parseInt(parts[cnt++]);
        int i = Integer.parseInt(parts[cnt++]);
        int j = Integer.parseInt(parts[cnt++]);
        int a = Integer.parseInt(parts[cnt++]);
        int b = Integer.parseInt(parts[cnt++]);
        
        int res = Integer.MAX_VALUE;

        res = getMin(1-i, 1-j, a, b, res);
        res = getMin(1-i, m-j, a, b, res);
        res = getMin(n-i, 1-j, a, b, res);
        res = getMin(n-i, m-j, a, b, res);
        
        if(res == Integer.MAX_VALUE){
            System.out.println("Poor Inna and pony!");
        } else {
            if((n == 1 || m == 1) && res != 0){
                System.out.println("Poor Inna and pony!");
            } else {
                System.out.println(res);
            }

        }
    }

    private static int getMin(int v1, int v2, int a, int b, int res) {
        if(v1%a == 0 && v2%b == 0){
            int k = v1 / a;
            int l = v2 / b;
            if((k-l)%2 == 0){
                res = Math.min(res, Math.max(Math.abs(k), Math.abs(l)));
            }
        }
        return res;
    }

}
