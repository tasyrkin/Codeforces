public class Gen {
    public static void main(String[]args){
        int n = 300000;
        System.out.println(n);
        for(int i = 0; i < n; i++){
            if(i > 0){
                System.out.print(' ');
            }
            System.out.print("1");
        }
        System.out.println();
    }
}
//FAIL Unexpected character #13, but ' ' expected (stdin)
