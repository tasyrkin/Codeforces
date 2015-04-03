import java.util.Scanner;

public class CF272A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int min = Integer.MAX_VALUE;
        for(int k2 = 100000; k2 >= 0; k2--){
            int fm = n-k2;
            if(fm>0){
                if(fm%m==0){
                    int k1 = fm-k2;
                    if(k1>=0&&2*k2+k1==n)
                    if(fm<min)min = fm;
                }
            }
        }
        System.out.println(min==Integer.MAX_VALUE?-1:min);
    }    
}
