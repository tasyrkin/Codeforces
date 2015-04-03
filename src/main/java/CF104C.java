import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CF104C {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] a = br.readLine().toCharArray();
		char[] b = br.readLine().toCharArray();
		int a4 = 0, a7 = 0;
		int b4 = 0, b7 = 0;
		int misplaced = 0;
		for(int i = 0; i < a.length; i++){
			if(a[i] == '4')a4++;
			if(a[i] == '7')a7++;
			if(b[i] == '4')b4++;
			if(b[i] == '7')b7++;
			if(a[i] != b[i])misplaced++;
		}
		int diff = Math.abs(a4-b4);
		System.out.println((misplaced-diff)/2 + diff);
	}

}
