import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CF272D {
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        Set[]factors = new Set[10000001];
        Set<Integer> s2 = new HashSet();
        s2.add(2);
        factors[2] = s2;
        for(int i = 2; i < factors.length; i++){
            if(factors[i].size() == 1 && ((Set<Integer>)factors[i]).iterator().next() == i){
                for(long j = i*i; j < factors.length; j+=i){
                    if(factors[(int)j]==null){
                        factors[(int)j] = new HashSet();
                    }
                    factors[(int)j].add(i);
                    int div = (int)j / i;
                    factors[(int)j].addAll(factors[div]);
                }
            }
        }

        LinkedList<Integer[]> res = new LinkedList<Integer[]>();
        res.add(new Integer[]{1,2,3,5});
        
        LinkedList<Integer>unused = new LinkedList<Integer>();
        int maxVal = 6;
        
        while(res.size() < n){
            Integer start = unused.removeFirst();
            int idx = 1;
            Integer[]sub = new Integer[4];
            sub[0] = start;
            while(idx<4){
                boolean wasDivided = false;
                for(int i = 0; i < idx; i++){
                    Set<Integer> currFactors = factors[sub[i]];
                    for(Integer fact : currFactors){
                        int mod = maxVal%fact;
                        if(mod == 0){
                            wasDivided = true;
                            break;
                        }
                    }
                }
                if(!wasDivided){
                    sub[idx++] = maxVal;
                } else {
                    unused.addLast(maxVal);
                } 
                maxVal++;
                
            }
            res.add(sub);
        }
        
        StringBuilder sb = new StringBuilder();
        long realMax = -1;
        for(Integer[] r : res){
            int cnt = 0;
            for(Integer v : r){
                if(cnt++!=0)sb.append(" ");
                long newVal = v*k;
                sb.append(newVal);
                if(realMax<newVal)realMax = newVal;
            }
            sb.append("\n");
        }
        System.out.println(realMax);
        System.out.println(sb.toString());
    }
    
}
