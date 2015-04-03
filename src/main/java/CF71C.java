import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CF71C {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[]taro = null;
		String line = null;
		String[]badStrs = null;
		int n = -1;
		while(null != (line = br.readLine())){
			if(n==-1){
				taro = new char[line.length()];
				for(int i = 0; i < line.length(); i++){
					taro[i] = line.charAt(i);
				}
				n = Integer.parseInt(br.readLine());
				badStrs = new String[n];
				continue;
			}
			badStrs[--n] = line;
			if(n<=0)break;
		}
		int maxPos = 0;
		int maxLen = -1;
		int currLen = 0;
		int currPos = 0;
		int shiftBack = -1;
		boolean isReset = true;
		for(int i = 0; i < taro.length; i++){
			if(isReset){
				isReset = false;
				if(maxLen<currLen){
					maxLen = currLen;
					maxPos = currPos;
				}
				i-=(shiftBack==-1?0:shiftBack-1);
				currPos = i;
				currLen = 0;
			}
			int numDiff = 0;
			shiftBack = taro.length+1;
			for(int j = 0; j < badStrs.length; j++){
				boolean wasDifferent = false;
				for(int k = badStrs[j].length()-1; k >= 0; k--){
					if(i-badStrs[j].length()+1+k<currPos||taro[i-badStrs[j].length()+1+k]!=badStrs[j].charAt(k)){
						wasDifferent = true;
						break;
					}
				}
				if(wasDifferent)numDiff++;
				else{
					if(shiftBack>badStrs[j].length())shiftBack = badStrs[j].length(); 
				}
			}
			if(numDiff==badStrs.length)currLen++;
			else isReset = true;
		}
		if(maxLen<currLen){
			maxLen = currLen;
			maxPos = currPos;
		}
		
		System.out.println(maxLen + " " + maxPos);
	}

}
