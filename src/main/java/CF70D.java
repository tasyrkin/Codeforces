import java.util.Scanner;


public class CF70D {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int rad = scanner.nextInt();
		if(rad==1)System.out.println(0);
		else if(rad==2)System.out.println(1);
		else{
			int count = 0;
			if(rad%2==0){
				count+=6*(rad-2)/2;
				rad--;
			}
			for(int i = 1; i <= (rad-1)/2; i++){
				count+=6*i;
			}
			count++;
			System.out.println(count);
		}
	}

}
