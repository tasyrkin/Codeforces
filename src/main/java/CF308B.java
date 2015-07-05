import java.util.Scanner;

public class CF308B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = (""+n).length();
        long total = 0;

        long powTen = 1;
        for(int i = 1; i < len; i++, powTen*=10){
            total += 9*powTen*i;
        }
        total += (n-powTen+1)*len;

        System.out.println(total);
    }
}
