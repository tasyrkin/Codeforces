import java.util.Scanner;

public class CF311A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]min = new int[3];
        int[]max = new int[3];
        for(int i = 0; i < 3; i++){
            min[i] = sc.nextInt();
            max[i] = sc.nextInt();
        }
        int first = n - min[1] - min[2];
        if(first > max[0]){
            first = max[0];
        }
        n -= first;
        int second = n - min[2];
        if(second > max[1]){
            second = max[1];
        }
        n-= second;
        System.out.println(String.format("%s %s %s", first, second, n));
    }
}
