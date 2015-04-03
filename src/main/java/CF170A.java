import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF170A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");

        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        int personsKnowingNoLanguage = 0;
        int[][] languages = new int[n][m+1];
        for(int i = 0; i < n; i++){
            parts = br.readLine().split("\\s+");
            int j = Integer.parseInt(parts[0]);
            if(j == 0){
                ++personsKnowingNoLanguage;
            }
            for(int k = 1; k <= j; k++){
                languages[i][Integer.parseInt(parts[k])] = 1;
            }
        }

        Set[] graph = new HashSet[n];

        for(int k = 1; k <= m; k++){
            Set<Integer> set = new HashSet<Integer>();
            for(int i = 0; i < n; i++){
                if(languages[i][k] > 0){
                    set.add(i);
                }
            }
            if(set.size() > 0){
                for(Integer person : set){
                    Set<Integer> adjacencyList = new HashSet<Integer>();
                    for(Integer anotherPerson : set){
                        if(person == anotherPerson)continue;
                        adjacencyList.add(anotherPerson);
                    }
                    if(graph[person] == null){
                        graph[person] = adjacencyList;
                    }else {
                        graph[person].addAll(adjacencyList);
                    }
                }
            }
        }

        Set<Integer> visited = new HashSet<Integer>();

        int cnt = 0;
        for(int person = 0; person < n; person++){
            if(visited.contains(person))continue;
            ++cnt;
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(person);
            while(!queue.isEmpty()){
                Integer currPerson = queue.poll();
                visited.add(currPerson);

                Set<Integer> friends = graph[currPerson];
                if(friends != null && friends.size() > 0){
                    for(Integer anotherPerson : friends){
                        if(visited.contains(anotherPerson))continue;
                        queue.offer(anotherPerson);
                    }
                }
            }
        }
        System.out.println(Math.max(cnt-1, personsKnowingNoLanguage));
    }

}
