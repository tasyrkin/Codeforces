import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class CF245C {
    
    private static class Info{
        int evenChanged;
        int oddChanged;
        int level;
        
        public Info(int ec, int oc, int l){
            evenChanged = ec;
            oddChanged = oc;
            level = l;
        }
    }

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList[] tree = new LinkedList[n+1];
        int[]init = new int[n+1];
        int[]goal = new int[n+1];

        String[]parts;
        for(int i = 0; i < n-1; i++){
            parts = br.readLine().split("\\s+");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            addEdge(tree, v1, v2);
            addEdge(tree, v2, v1);
        }
        String[]initStr = br.readLine().split("\\s+");
        String[]goalStr = br.readLine().split("\\s+");
        for(int i = 1; i <= n; i++){
            init[i] = Integer.parseInt(initStr[i-1]);
            goal[i] = Integer.parseInt(goalStr[i-1]);
        }

        Stack<Integer> stack = new Stack<Integer>();
        Stack<Info> infoStack = new Stack<Info>();
        stack.push(1);
        infoStack.push(new Info(0,0,0));
        LinkedList<Integer> steps = new LinkedList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        while(!stack.isEmpty()){
            Integer v = stack.pop();
            visited.add(v);
            Info vInfo = infoStack.pop();
            int currValue = (init[v] + (vInfo.level % 2 == 0 ? vInfo.evenChanged : vInfo.oddChanged))%2; 
            if(currValue != goal[v]){
                if(vInfo.level % 2 == 0){
                    vInfo.evenChanged++;
                } else {
                    vInfo.oddChanged++;
                }
                steps.add(v);
            }
            if(tree[v]!=null){
                for(Integer child : (LinkedList<Integer>)tree[v]){
                    if(visited.contains(child)) continue;
                    stack.push(child);
                    infoStack.push(new Info(vInfo.evenChanged, vInfo.oddChanged, vInfo.level+1));
                }
            }
        }
        
        System.out.println(steps.size());
        StringBuilder sb = new StringBuilder();
        for(Integer step : steps){
            sb.append(step);
            sb.append("\n");
        }
        System.out.println(sb.toString());
        

    }

    private static void addEdge(LinkedList[]tree, int v1, int v2) {
        LinkedList<Integer> l = tree[v1] == null ? new LinkedList<Integer>() : tree[v1];
        l.add(v2);
        tree[v1] = l;
    }

}
