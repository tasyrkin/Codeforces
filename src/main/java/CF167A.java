import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF167A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[]parts = br.readLine().split("\\s+");
        int[]arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(parts[i]);
        }
        long[] tree = new long[4*n];
        build(tree, arr, 1, 0, n-1);

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            parts = br.readLine().split("\\s+");
            int weight = Integer.parseInt(parts[0])-1;
            int height = Integer.parseInt(parts[1]);
            long max = max(tree, 1, 0, n-1, 0, weight);
            //if(sb.length() > 0)sb.append(" ");
            sb.append("" + max + "\n");
            //update(tree, 1, 0, n-1, 0, weight, max+height);
            update(tree, 1, 0, n-1, 0, max+height);
        }
        System.out.println(sb.toString());
    }

    static void update (long[]tree, int v, int tl, int tr, int pos, long new_val) {
        if (tl == tr)
            tree[v] = new_val;
        else {
            int tm = (tl + tr) / 2;
            if (pos <= tm)
                update (tree, v*2, tl, tm, pos, new_val);
            else
                update (tree, v*2+1, tm+1, tr, pos, new_val);
            tree[v] = Math.max(tree[v*2],tree[v*2+1]);
        }
    }

    public static void build(long[] tree, int[]arr, int v, int tl, int tr){
        if(tl == tr){
            tree[v] = arr[tl];
        } else {
            int tm = (tl+tr)/2;
            build(tree, arr, v*2, tl, tm);
            build(tree, arr, v*2+1,tm+1, tr);
            tree[v] = Math.max(tree[v*2], tree[v*2+1]);
        }
    }

    public static long max (long[]tree, int v, int tl, int tr, int l, int r) {
        if (l > r)
            return 0;
        if (l == tl && r == tr)
            return tree[v];
        int tm = (tl + tr) / 2;
        return Math.max(max(tree, v*2, tl, tm, l, Math.min(r,tm)) ,max(tree, v * 2 + 1, tm + 1, tr, Math.max(l, tm + 1), r));
    }

    static void push (long[]tree, int v) {
        if (tree[v] != -1) {
            tree[v*2] = tree[v*2+1] = tree[v];
            tree[v] = -1;
        }
    }

    static void update (long[]tree, int v, int tl, int tr, int l, int r, long color) {
        if (l > r)
            return;
        if (l == tl && tr == r)
            tree[v] = color;
        else {
            push (tree, v);
            int tm = (tl + tr) / 2;
            update (tree, v*2, tl, tm, l, Math.min(r, tm), color);
            update (tree, v*2+1, tm+1, tr, Math.max(l, tm + 1), r, color);
        }
    }

    static long get (long[]tree, int v, int tl, int tr, int pos) {
        if (tl == tr)
            return tree[v];
        push (tree, v);
        int tm = (tl + tr) / 2;
        if (pos <= tm)
            return get (tree, v*2, tl, tm, pos);
        else
            return get (tree, v*2+1, tm+1, tr, pos);
    }
}
