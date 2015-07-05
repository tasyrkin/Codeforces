import java.util.HashSet;
import java.util.Scanner;

public class CF308C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int m = sc.nextInt();

        boolean isSolvable = solve(w, m, new HashSet<Long>());

        System.out.println(isSolvable ? "YES" : "NO");
    }

    private static boolean solve(int w, long m, HashSet<Long> used) {

        if(m == 0)return true;

        long higher = 1;

        while(true){
            if(higher >= m && !used.contains(higher))break;
            higher *= w;
        }

        if(higher - m < m){
            used.add(higher);
            boolean isSolvable = solve(w, higher - m, used);
            used.remove(higher);
            if(isSolvable)return true;
        }

        long lower = 1;
        Long selectedLower = null;

        while(true){
            if(lower <= m && !used.contains(lower)){
                selectedLower = lower;
            }
            if(lower > m)break;
            lower *= w;
        }

        if(selectedLower != null && m - selectedLower < m){
            used.add(selectedLower);
            boolean isSolvable = solve(w, m - selectedLower, used);
            used.remove(selectedLower);
            if(isSolvable)return true;
        }

        return false;
    }
}
