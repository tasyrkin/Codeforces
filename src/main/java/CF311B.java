import java.util.Arrays;
import java.util.Scanner;

public class CF311B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[]a = new int[2*n];
        for(int i = 0; i < 2*n; i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int minGirls = a[0];
        int minBoys = a[n];

        double x = (double)w/(3*n);

        if(x > minGirls){
            x = minGirls;
        }
        if(2*x > minBoys){
            x = (double)minBoys / 2;
        }

        System.out.println(3*n*x);
    }
}
