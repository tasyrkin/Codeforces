import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF110C {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] s1 = br.readLine().toCharArray();
		char[] s2 = br.readLine().toCharArray();
		int min = Integer.MAX_VALUE;
		
//		for(int i = 0; i < s1.length; i++){
//			for(int j = i; j < s1.length; j++){
//				int currMax = j-i+1 + s2.length;
//				if(min>currMax)min = currMax;
//				int start = j;
//				while(start>=i){
//					int common = 0;
//					int cnt = 0;
//					for(int k = start; k <= j; k++){
//						if(k-start>=s2.length)break;
//						if(s1[k] == s2[k-start])common++;
//						cnt++;
//					}
//					int rem = start-i;
//					int change = cnt-common;
//					int add = s2.length-cnt;
//					if(min > rem+change+add)min = rem+change+add; 
//					start--;
//				}
//			}
//		}

		int start = s1.length-1;
		while(start>=0){
			int common = 0;
			int cnt = 0;
			for(int k = start; k <= s1.length-1; k++){
				if(k-start>=s2.length)break;
				if(s1[k] == s2[k-start])common++;
				cnt++;
			}
			int change = cnt-common;
			int add = s2.length-cnt;
			if(min > change+add)min = change+add; 
			start--;
		}
		
		
		System.out.println(min);
	}
	
//	public static int longestSubstr(char[] first, int s, int e, char[] second) {
//	    if (first == null || second == null || first.length == 0 || second.length == 0) {
//	        return 0;
//	    }
//	 
//	    int maxLen = 0;
//	    int fl = first.length;
//	    int sl = second.length;
//	    int[][] table = new int[fl][sl];
//	 
//	    for (int i = s; i <= e; i++) {
//	        for (int j = 0; j < sl; j++) {
//	            if (first[i] == second[j]) {
//	                if (i == 0 || j == 0) {
//	                    table[i][j] = 1;
//	                }
//	                else {
//	                    table[i][j] = table[i - 1][j - 1] + 1;
//	                }
//	                if (table[i][j] > maxLen) {
//	                    maxLen = table[i][j];
//	                }
//	            }
//	        }
//	    }
//	    return maxLen;
//	}	
}
