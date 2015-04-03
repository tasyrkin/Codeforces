import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CFEND2013C {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[]ps = br.readLine().split("\\s+");
        int[]a = new int[n];
        int[]res = new int[n];
        Map<Integer, LinkedList<Integer>> m = new HashMap<Integer, LinkedList<Integer>>();
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(ps[i]);
            LinkedList<Integer> l = m.get(a[i]);
            if(l == null){
                l = new LinkedList<Integer>();
            }
            l.add(i);
            m.put(a[i], l);
        }
        Arrays.sort(a);
        int curr = -1;
        for(int i = 0; i < n; i++){
            if(curr == -1){
                curr = a[i];
            } else {
                if(a[i] <= curr){
                    curr++;
                } else {
                    curr = a[i];
                }
            }
            LinkedList<Integer> l = m.get(a[i]);
            int idx = l.removeFirst();
            m.put(a[i], l);
            res[idx] = curr;
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++){
            if(sb.length() > 0)sb.append(" ");
            sb.append(res[i]);
        }
        System.out.println(sb.toString());
    }

}
