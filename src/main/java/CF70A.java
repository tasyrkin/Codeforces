import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;



public class CF70A {
	public static HashSet<Character> vowels = new HashSet<Character>();
	public static void main(String[] args) throws IOException{
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = vowelsNum(br.readLine());
		if(count != 5){
			System.out.println("NO");
			return;
		}
		count = vowelsNum(br.readLine());
		if(count!=7){
			System.out.println("NO");
			return;			
		}
		count = vowelsNum(br.readLine());
		if(count!=5){
			System.out.println("NO");
			return;			
		}
		System.out.println("YES");
	}
	public static int vowelsNum(String str){
		int count = 0;
		for(int i = 0; i < str.length(); i++){
			if(vowels.contains(str.charAt(i))){
				count++;
			}
		}
		return count;
	}
}
