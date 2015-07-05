import java.util.Scanner;

public class CF310C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int overall = n-1;
        int first = 0;
        for(int i = 0; i < k; i++){
            int ki = sc.nextInt();
            overall += ki-1;
            boolean isTrue = true;
            for(int j = 0; j < ki; j++){
                if(sc.nextInt() == j+1 && isTrue){
                    first++;
                } else {
                    isTrue = false;
                }
            }
        }
        System.out.println(overall-(first>0?2*(first-1):0));
    }
}
