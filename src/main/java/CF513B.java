import java.util.Scanner;

public class CF513B {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        char[] nums = sc.next().toCharArray();
        int carry = 0;
        int sum = 0;
        for(int i = nums.length - 1; i > 0; i--) {
            sum += 10 + ((nums[i] - '0')) - carry;
            carry = 1;
        }
        System.out.println(sum + (nums[0]-'0') - carry);


    }

}
