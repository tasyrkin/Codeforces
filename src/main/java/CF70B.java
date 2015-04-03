import java.util.HashSet;
import java.util.Scanner;


public class CF70B {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		char[] colors = {'R','O','Y','G','B','I','V'};
		char[] arr = new char[n];
		for(int i = 0; i < arr.length; i++)arr[i] = '_';
		arr[0] = 'R';
		arr[1] = 'O';
		arr[2] = 'Y';
		arr[3] = 'G';
		HashSet<Character> allColors = new HashSet<Character>();
		allColors.add('B');
		allColors.add('I');
		allColors.add('V');
		for(int i = 1; i < arr.length; i++){
			int place = i+3;
			if(place>=n)place-=n;
			if(arr[place]!='_')continue;
			int start = i;
			HashSet<Character> existingSet = new HashSet<Character>();
			for(int j = 0; j < 7; j++){
				existingSet.add(arr[start++]);
				if(start>=n)start=0;
			}
			char col = '_';
			for(int j = 0; j < 7; j++){
				if(!existingSet.contains(colors[j])){
					if(allColors.size()>0){
						Character ch = allColors.iterator().next();
						col = ch;
						allColors.remove(ch);
					}
					else{
						col = colors[j];						
					}
					break;
				}
			}
			arr[place] = col;
		}
		for(int i = 0; i<arr.length; i++){
			System.out.print(arr[i]);
		}
		System.out.print("\n");
	}
}
