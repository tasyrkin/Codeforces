import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class CF221B {
    
    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        HashMap<Integer, Integer>[] g = new HashMap[n];
        for(int i = 0; i < n; i++){
            g[i] = new HashMap<Integer, Integer>();
        }
        
        for(int i = 0; i < m; i++){
            parts = br.readLine().split("\\s+");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            int c = Integer.parseInt(parts[2]);
            g[a-1].put(b-1, c);
        }
        
        
        for(int i = 0; i < n; i++){

            HashMap<Integer, Integer> newMap = new HashMap<Integer, Integer>();
            for(Map.Entry<Integer, Integer> on : g[i].entrySet()){
                
                if(on.getValue() == 0)continue;

                HashMap<Integer, Integer> map = g[on.getKey()];

                
                for(Map.Entry<Integer, Integer> entry :  map.entrySet()){
                    
                    if(entry.getValue() == 0)continue;
                    
                    if(entry.getValue() <= on.getValue()){
                        int val = entry.getValue(); 
                        on.setValue(on.getValue()-entry.getValue());
                        entry.setValue(0);
                        if(i!=entry.getKey()){
                            Integer newEntry = g[i].get(entry.getKey());
                            if(newEntry == null){
                                newMap.put(entry.getKey(), val);
                            } else {
                                newMap.put(entry.getKey(), val + newEntry);
                            }
                        }
                        
                    }else {
                        int val = on.getValue();
                        on.setValue(0);
                        entry.setValue(entry.getValue()-val);
                        if(i != entry.getKey()){
                            Integer newEntry = g[i].get(entry.getKey());
                            if(newEntry == null){
                                newMap.put(entry.getKey(), val);
                            } else {
                                newMap.put(entry.getKey(), newEntry + val);
                            }
                        }
                    }
                }
                if(newMap.values().size() > 0)break;
            }

            for(Map.Entry<Integer, Integer> entry : newMap.entrySet()){
                g[i].put(entry.getKey(), entry.getValue());
            }
            if(newMap.values().size() > 0)i = -1;
        }
        
        int res = 0;
        for(int i = 0; i < n; i++){
            for(Map.Entry<Integer, Integer> entry : g[i].entrySet()){
                res += entry.getValue();
            }
        }

        System.out.println(res);
    }

}
