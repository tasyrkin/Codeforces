import java.util.Scanner;


public class CF71A {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		boolean isFirst = true;
		while(100*x+10*y>=220){
			if(isFirst){
				if(x>=2&&y>=2){
					x-=2;
					y-=2;
				}
				else if(x>=1&&y>=12){
					x--;
					y-=12;
				}
				else if(y>=22){
					y-=22;
				}
				else{
					System.out.println("Hanako");
					return;
				}
			}
			else{
				if(y>=22){
					y-=22;
				}
				else if(x>=1&&y>=12){
					x--;
					y-=12;					
				}
				else if(x>=2&&y>=2){
					x-=2;
					y-=2;					
				}
				else{
					System.out.println("Ciel");
					return;					
				}
			}
			isFirst = !isFirst;
		}
		if(isFirst){
			System.out.println("Hanako");
		}
		else{
			System.out.println("Ciel");
		}
	}

}
