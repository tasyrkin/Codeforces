import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class KROK_QualA {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][] arr = new char[n][];
		int len = 0;
		for(int i = 0; i < n; i++){
			arr[i] = br.readLine().toCharArray();
			len = arr[i].length; 
		}
		int res = 0;
		main: for(int i = 0; i < len; i++){
			char ch = arr[0][i];
			for(int j = 1; j < n; j++){
				if(ch != arr[j][i])break main;
			}
			res++;
		}
		System.out.println(res);
	}

}
