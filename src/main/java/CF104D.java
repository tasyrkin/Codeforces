import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Not solved
 * @author Compaq_Cq
 *
 */
public class CF104D {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().split("\\s+");
		int v4 = Integer.parseInt(parts[0]);
		int v7 = Integer.parseInt(parts[1]);
		int v47 = Integer.parseInt(parts[2]);
		int v74 = Integer.parseInt(parts[3]);
		if(Math.abs(v47-v74)>1){
			System.out.println(-1);
			return;
		}
		if(v47==v74){
			if(v47>v4 || v47>v7){
				System.out.println(-1);
				return;				
			}
			if(v4>v47){
				System.out.println(replicate("4", v4-v47-1) + replicate("47", v47) + replicate("7", v7-v74) + "4");
			} else if(v4 == v47) {
				System.out.println(replicate("7", v7-v74) + replicate("74", v74));
			} else {
				System.out.println(-1);
			}
				
		}
	}
	
	public static String replicate(String s, int times){
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < times; i++){
			sb.append(s);
		}
		return sb.toString();
	}
}
