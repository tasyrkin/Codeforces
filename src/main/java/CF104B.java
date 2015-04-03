import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CF104B {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().split("\\s+");
		int len1 = parts[0].length();
		int len2 = parts[1].length();
		int a = Integer.parseInt(parts[0]);
		int b = Integer.parseInt(parts[1]);
		if(len1 < len2){
			System.out.println(b);
		} else if (len1 >= len2){
			for(int i = a+1; ; i++){
				char[]arr = (i+"").toCharArray();
				StringBuffer sb = new StringBuffer();
				for(int j = 0; j < arr.length; j++){
					if(arr[j] == '4' || arr[j] == '7'){
						sb.append(arr[j]);
					}
				}
				if(sb.length()==0)continue;
				int n = Integer.parseInt(sb.toString());
				if(n == b){
					System.out.println(i);
					return;
				}
			}
		}
	}

}
