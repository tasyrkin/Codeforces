import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


public class CFYQ1C {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] parts = br.readLine().split("\\s+");
		int a = Integer.parseInt(parts[0]), b = Integer.parseInt(parts[1]);
		parts = br.readLine().split("\\s+");
		int[] marks = new int[n];
		for(int i = 0; i < n; i++)marks[i] = Integer.parseInt(parts[i]);
		if(a==b){
			for(int i = 0; i < n; i++){
				if(a>0){
					System.out.print("1");
					--a;
				}
				else System.out.print("2");
				if(i<n-1)System.out.print(" ");
			}
			System.out.println();
			return;
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++){
			if(marks[i]<min)min = marks[i];
			if(marks[i]>max)max = marks[i];
		}
		char[] res = new char[n];
		Arrays.fill(res, '!');
		if(a>b){
			for(int val = min; val <= max; val++){
				for(int i = 0; i < n; i++){
					if(marks[i]==val&&a>0){
						res[i] = '1';
						--a;
					}
				}			
				if(a<=0)break;
			}
			for(int i = 0; i < n; i++){
				if(res[i]=='!')res[i]='2';
			}
		}
		else{
			for(int val = min; val <= max; val++){
				for(int i = n-1; i >= 0; i--){
					if(marks[i]==val&&b>0){
						res[i] = '2';
						--b;
					}
				}			
				if(b<=0)break;
			}
			for(int i = 0; i < n; i++){
				if(res[i]=='!')res[i]='1';
			}			
		}
		for(int i = 0; i < n; i++){
			System.out.print(res[i]);
			if(i<n-1)System.out.print(" ");
		}			
		System.out.println();
	}

}
