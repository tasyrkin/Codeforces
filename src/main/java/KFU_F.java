import java.util.HashSet;
import java.util.Scanner;

public class KFU_F {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        HashSet[] graph = new HashSet[N];

        for(int i = 0; i < N; i++){
            if(graph[i] == null){
                graph[i] = new HashSet<Integer>();
            }
            for(int j = i+1; j < N; j++){
                if(graph[j] == null){
                    graph[j] = new HashSet<Integer>();
                }
                graph[i].add(j);
                graph[j].add(i);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                if(graph[i].size() > K+1
                        && graph[j].size() > K+1
                        && graph[i].contains(j)){
                    graph[j].remove(i);
                    graph[i].remove(j);
                }
            }
        }

        int m = 0;
        for(int i = 0; i < N; i++){
            HashSet<Integer> ribs = graph[i];
            for(int j : ribs){
                if(i < j){
                    m++;
                }
            }
        }

        System.out.println(m);
        for(int i = 0; i < N; i++){
            HashSet<Integer> ribs = graph[i];
            for(int j : ribs){
                if(i < j){
                    System.out.println((i+1) + " " + (j+1));
                }
            }
        }

    }
}
