import java.util.Scanner;

public class CF308A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][]arr = new int[n][4];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 4; j++){
                arr[i][j] = sc.nextInt()-1;
            }
        }
        int total = 0;
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                for(int i1 = 0; i1 < n; i1++){
                    if(arr[i1][0]<=i&&i<=arr[i1][2]&&arr[i1][1]<=j&&j<=arr[i1][3]){
                        total++;
                    }
                }
            }
        }
        System.out.println(total);
    }
}
