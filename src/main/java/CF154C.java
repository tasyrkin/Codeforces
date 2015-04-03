import java.io.*;
import java.util.*;


public class CF154C {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fileWriter = new FileWriter("output.txt");
        String[] parts = br.readLine().split("\\s+");
        int n = Integer.parseInt(parts[0]);

        int[]strs = new int[n];
        parts = br.readLine().split("\\s+");
        int m = 0;
        for(int i = 0; i < n; i++){
            strs[i] = Integer.parseInt(parts[i])+1;
            if(m < strs[i]){
                m = strs[i];
            }
        }

        parts = br.readLine().split("\\s+");

        int sx = Integer.parseInt(parts[0])-1;
        int sy = Integer.parseInt(parts[1])-1;
        int ex = Integer.parseInt(parts[2])-1;
        int ey = Integer.parseInt(parts[3])-1;


        int level = -1;

        Queue<Pair> q = new LinkedList<Pair>();

        Pair start = new Pair(sx, sy, 0);
        q.add(start);

        //set.add(start);


        boolean[][]used = new boolean[n+1][m+1];
        used[sx][sy] = true;

        //Set<Pair> set = new HashSet<Pair>(n*m+1);
        //Set<String> set = new HashSet<String>(n*m+1);

        //long ms = System.currentTimeMillis();

        int loopcnt = 0;

        while(!q.isEmpty()){

            loopcnt++;

            Pair p = q.poll();

            if(p.x == ex && p.y == ey){
                level = p.level;
                break;
            }

            if(p.y>0){
                Pair l = new Pair(p.x, p.y-1, p.level+1);
                String s = l.x + "," + l.y;
                if(!used[l.x][l.y]){
                //if(!set.contains(s)){
                    q.add(l);
                    used[l.x][l.y] = true;
                    //set.add(s);
                }
            }
            if(p.y+1 < strs[p.x]){
                Pair r = new Pair(p.x, p.y+1, p.level+1);
                String s = r.x + "," + r.y;
                if(!used[r.x][r.y]){
                //if(!set.contains(s)){
                    q.add(r);
                    used[r.x][r.y] = true;
                    //set.add(s);
                }
            }
            if(p.x > 0){
                int newy = Math.min(strs[p.x-1]-1,p.y);
                Pair up = new Pair(p.x-1, newy, p.level+1);
                //String s = up.x + "," + up.y;
                if(!used[up.x][up.y]){
                //if(!set.contains(s)){
                    q.add(up);
                    used[up.x][up.y] = true;
                    //set.add(s);
                }
            }
            if(p.x+1 < n){
                int newy = Math.min(strs[p.x+1]-1,p.y);
                Pair down = new Pair(p.x+1, newy, p.level+1);
                String s = down.x + "," + down.y;
                if(!used[down.x][down.y]){
                //if(!set.contains(s)){
                    q.add(down);
                    used[down.x][down.y] = true;
                    //set.add(s);
                }
            }
            //if(System.currentTimeMillis() - ms > 1000){
            if(loopcnt%1000000 == 0){
                System.out.println(loopcnt);
                //ms = System.currentTimeMillis();
            }
        }
        //System.out.println(level);
        fileWriter.write(""+level);
        fileWriter.close();
    }

    private static class Pair{
        public Pair(int x, int y, int level){
            this.x = x;
            this.y = y;
            this.level = level;
        }
        int x;
        int y;
        int level;

        public boolean equals(Object o){
            if(o != null && o instanceof Pair){
                Pair p = (Pair)o;
                return x == p.x && y == p.y;
            }
            return false;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

}
