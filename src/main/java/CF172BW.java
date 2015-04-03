import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: tim
 * Date: 3/10/13
 * Time: 4:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class CF172BW {

    public static class PairComparator implements Comparator<Pair>{

        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.x*o2.y - o1.y * o2.x;
        }
    }

    private static class Pair {
        int x;
        int y;
        Pair(int x1, int y1, boolean simplify){
            int g = gcd(x1, y1);
            if(!simplify)g = 1;
            x = x1/g;
            y = y1/g;
        }
        public boolean equals(Object o){
            if(o != null && o instanceof Pair){
                Pair p = (Pair)o;
                Pair th = new Pair(x, y, true);
                Pair an = new Pair(p.x, p.y, true);
                return th.x == an.x && th.y == an.y;
            }
            return false;
        }
        public int hashCode(){
            int code = 31;
            code += Integer.valueOf(x).hashCode();
            code += Integer.valueOf(y).hashCode();

            return code;
        }
        public String toString(){
            return x + "/" + y;
        }
    }

    public static int gcd (int a, int b){
        if(a < b)return gcd(b,a);
        if(b == 0)return a;
        return gcd(b, a%b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");

        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        int n = Integer.parseInt(parts[2]);

        if(n >= y){
            Pair p = new Pair(x,y, true);
            System.out.println(p.toString());
            return;
        }

        Map<Pair, Set<Pair>> diffs = new HashMap<Pair, Set<Pair>>();
        for(int denom = 1; denom <= n; denom++){
            long f = denom*x;
            long div = f/y;
            double min = Double.MAX_VALUE;
            long nomin = -1;
            long denomNew = y*denom;
            for(long i = 0; i <= n; i++){
                double curr = ((double)Math.abs(f-(long)y*i))/denomNew;
                if(curr < min){
                    min = curr;
                    nomin = i;
                }
            }
            Pair p = new Pair((int)Math.abs(f-y*nomin), y*denom, true);
            Set<Pair> set = diffs.get(p);
            if(set == null){
                set = new HashSet<Pair>();
            }
            set.add(new Pair((int)nomin, (int)denom, true));
            diffs.put(p, set);
        }
        Pair[]arr = diffs.keySet().toArray(new Pair[0]);
        Arrays.sort(arr, new PairComparator());
        Set<Pair> result = diffs.get(arr[0]);

        int minimalDenom = Integer.MAX_VALUE;
        for(Pair p : result){
            if(minimalDenom > p.y)minimalDenom = p.y;
        }

        List<Pair> sameDenom = new ArrayList<Pair>();
        for(Pair p : result){
            if(minimalDenom == p.y)sameDenom.add(p);
        }

        int minimalNom = Integer.MAX_VALUE;

        for(Pair p : sameDenom){
            if(minimalNom > p.x)minimalNom = p.x;
        }

        Pair res = null;
        for(Pair p : sameDenom){
            if(minimalNom == p.x){
                res = p;
                break;
            }
        }


        System.out.println(res.x + "/" + res.y);
    }

}
