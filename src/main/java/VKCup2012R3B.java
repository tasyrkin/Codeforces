import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class VKCup2012R3B {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[]a = br.readLine().toCharArray();
		StringBuffer sb = new StringBuffer();
		boolean isFirst = true;
		List<String> arr = new ArrayList<String>();
		for(int i = 0; i < a.length; i++){
			if(a[i]=='.'){
				if(isFirst == true){
					isFirst = false;
					if(sb.length()==0||sb.length()>8){
						System.out.println("NO");
						return;
					} 
					arr.add(sb.toString());
				} else {
					if(sb.length()>=2&&sb.length()<=11){}
					else {
						System.out.println("NO");
						return;
					}
					int len = 1;
					while(true){
						if(sb.length()-len<=8){
							String prev = arr.remove(arr.size()-1);
							arr.add(prev + "." + sb.toString().substring(0,len));
							arr.add(sb.toString().substring(len));
							break;
						} else {
							len++;
						}
					}					
				}
				sb = new StringBuffer();
			} else {
				sb.append(a[i]);
			}
		}
		if(sb.length()>=1&&sb.length()<=3){
			if(arr.size() == 0){
				System.out.println("NO");
				return;
			}
			String prev = arr.remove(arr.size()-1);			
			arr.add(prev + "." + sb.toString());
		} else{ 
			System.out.println("NO");
			return;
		}
		System.out.println("YES");
		for(String s : arr){
			System.out.println(s);
		}
	}
}
