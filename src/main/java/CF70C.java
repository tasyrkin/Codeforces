import java.util.Scanner;


public class CF70C {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int k = scanner.nextInt();
		if(isPossibleToDivide(m, k)){
			if(n%2==0)System.out.println("Marsel");
			else System.out.println("Timur");
		}
		else{
			System.out.println("Marsel");
		}
	}
	
	public static boolean isPossibleToDivide(int m, int k){
		if(k==1&&m!=1)return true;
		for(int i = 2; i*i <= m; i++){
			if(m%i==0&&(m/i>=k||i>=k))return true;
		}
		return false;
	}
}
