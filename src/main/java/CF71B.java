import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;


public class CF71B {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int n = -1, m = -1, k = -1, t = -1;
		String[] wasted = null;
		int cnt = 0;
		String[]parts = null;
		while(null != (line = br.readLine())){
			if(n==-1){
				parts = line.split("\\s+");
				n = Integer.parseInt(parts[0]);
				m = Integer.parseInt(parts[1]);
				k = Integer.parseInt(parts[2]);
				t = Integer.parseInt(parts[3]);
				wasted = new String[k];
				continue;
			}
			if(cnt<k){
				parts = line.split("\\s+");
				wasted[cnt++] = getStringIndex(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]));
				if(cnt==k){
					Arrays.sort(wasted);
//					for(int i = 0; i < wasted.length; i++){
//						System.out.println(wasted[i]);
//					}
				}				
			}
			else{
				parts = line.split("\\s+");
				int i = Integer.parseInt(parts[0]);
				int j = Integer.parseInt(parts[1]);
				String key = getStringIndex(i,j);
				int idx = Arrays.binarySearch(wasted, key);
				//System.out.println("key:"+key+",idx_orig:"+idx);
				if(idx>=0){
					System.out.println("Waste");
				}				
				else{
					idx = (-1)*(idx+1);
					int num = (i-1)*m+j;
					num-=idx;
					//System.out.println("idx:"+idx+",num:"+num);
					if(num%3==1){
						System.out.println("Carrots");
					}
					else if(num%3==2){
						System.out.println("Kiwis");
					}
					else{
						System.out.println("Grapes");
					}
				}
				if(--t<=0)break;
			}
		}
	}	
	
	public static String getStringIndex(int i, int j){		
		return intToString(i) + "," + intToString(j);
	}
	
	public static String intToString(int num) {
		int digits = 5;
	    char[] zeros = new char[digits];
	    Arrays.fill(zeros, '0');
	    // format number as String
	    DecimalFormat df = new DecimalFormat(String.valueOf(zeros));

	    return df.format(num);
	}

}
