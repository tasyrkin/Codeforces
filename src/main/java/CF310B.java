import java.util.Scanner;

public class CF310B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[]arr = new int[n];
        for(int i = 0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }

        boolean isTrue = checkTrue(arr);

        for(int i = 0; i < arr.length && !isTrue; i++){
            for(int j = 0; j < arr.length; j++){
                if(j%2==0){
                    arr[j] = (arr[j]+1)%n;
                }else{
                    arr[j]--;
                    if(arr[j]<0)arr[j]+=n;
                }
            }
            isTrue = checkTrue(arr);
        }

        System.out.println(isTrue ? "Yes" : "No");

    }

    private static boolean checkTrue(int[] arr) {
        for(int j = 0; j < arr.length; j++){
            if(arr[j] != j)return false;
        }
        return true;
    }
}
