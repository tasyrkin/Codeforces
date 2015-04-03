import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CF272B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[]inp = sc.next().toCharArray();
        char[]out = sc.next().toCharArray();
        int fin = 0;
        for(char c : inp){
            if(c=='+')fin++;
            else fin--;
        }
        List<Long> poss = new LinkedList<Long>();
        solve(out, 0, poss, 0);
        int cnt = 0;
        for(Long pos : poss){
            if(fin == pos)cnt++;
        }
        System.out.println((double)cnt/poss.size());
    }

    private static void solve(char[] out, int i, List<Long> poss, long pos) {
        if(i>=out.length){
            poss.add(pos);
            return;
        }
        if(out[i]=='?'){
            out[i] = '+';
            solve(out, i, poss, pos);
            out[i] = '-';
            solve(out, i, poss, pos);
            out[i] = '?';
        } else {
            if(out[i] == '+'){
                solve(out, i+1, poss, pos+1);
            } else {
                solve(out, i+1, poss, pos-1);
            }
        }
    }
}
