import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CF222C {
    
    public static class Pair{
        int x;
        int y;
        public Pair(int i, int j){
            x = i;
            y = j;
        }
    }

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]ps = br.readLine().split("\\s+");
        int n = Integer.parseInt(ps[0]);
        int m = Integer.parseInt(ps[1]);
        int k = Integer.parseInt(ps[2]);
        int[][]a = new int[n][m];
        int s = 0;
        int x = -1;
        int y = -1;
        for(int i = 0; i < n; i++){
            char[] rs = br.readLine().toCharArray();
            for(int j = 0; j < m; j++){
                a[i][j] = rs[j] == '.' ? 2 : 1;
                if(a[i][j] == 2){
                    s++;
                    x = i;
                    y = j;
                }
            }
        }

        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(x, y));
        //System.out.println(x + "," + y);
        for(int i = 0; i < s-k; i++){
            //out(a);
            Pair p = q.poll();
            a[p.x][p.y] = 0;
            for(int x1 = -1; x1 <= 1; x1++){
                for(int y1 = -1; y1 <= 1; y1++){
                    if(x1 == 0 && y1 == 0)continue;
                    if(x1 != 0 && y1 != 0)continue;
                    if(p.x+x1>=0 && p.x+x1<n && p.y+y1 >= 0 && p.y+y1 < m && a[p.x+x1][p.y+y1] == 2){
                        q.add(new Pair(p.x+x1, p.y+y1));
                        a[p.x+x1][p.y+y1] = 3;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            StringBuffer sb = new StringBuffer();
            for(int j = 0; j < m; j++){
                if(a[i][j] == 0){
                    sb.append(".");
                } else if(a[i][j] == 1) {
                    sb.append("#");
                } else {
                    sb.append("X");
                }
            }
            System.out.println(sb.toString());
        }

    }

    public static void out(int[][]a) {
        for(int i = 0; i < a.length; i++){
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println();
    }

}
