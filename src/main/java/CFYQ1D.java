import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


public class CFYQ1D {

	public static class Pair{
		int idx;
		int qty;
		public Pair(int idx, int qty){
			this.idx = idx;
			this.qty = qty;
		}
		public String toString(){
			return "(" + idx + "," + qty + ")";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[]parts = br.readLine().split("\\s+");
		int n = Integer.parseInt(parts[0]);
		int N = n;
		int m = Integer.parseInt(parts[1]);
		Pair[] albs = new Pair[41001];
		parts = br.readLine().split("\\s+");
		for(int i = 0; i < parts.length; i++){
			int qty = Integer.parseInt(parts[i]);
			int index = qty*1000;
			while(albs[index]!=null)index++;
			albs[index] = new Pair(i+1,qty);
		}
//		for(int i = 0; i < albs.length; i++){
//			if(albs[i]!=null)
//				System.out.print(albs[i] + " ");
//		}
		StringBuffer sb = new StringBuffer();
		int i = albs.length-1;
		while(albs[i]==null)i--;
		int j = i-1;
		boolean isFirst = true;
		while(i>=0&&j>=0&&n>0){
			if(isFirst){
				while(albs[i]==null||albs[i].qty<=0){
					i--;
					if(i<0)break;
				}
				if(i<0)continue;
				if(i==j){
					i = j-1;
					continue;
				}				
				albs[i].qty--;
				sb.append(albs[i].idx + " ");
			}
			else{
				while(albs[j]==null||albs[j].qty<=0){
					j--;
					if(j<0)break;
				}
				if(j<0)continue;
				if(i==j){
					j = Math.min(i-1, j-1);
					continue;
				}				
				albs[j].qty--;
				sb.append(albs[j].idx + " ");
			}
			isFirst = !isFirst;
			n--;
			if(n==1&&N%2==1)break;
		}
		if((i<0||j<0)&&n>0)
		{
			System.out.println(-1);
			return;
		}
		else if(n==1&&N%2==1){
			int idx = Math.min(i, j)-1;
			if(idx<0){
				System.out.println(-1);
				return;
			}
			while(albs[idx]==null){
				idx--;
				if(idx<0)break;
			}
			if(idx<0){
				System.out.println(-1);
				return;
			}
			sb.append(albs[idx].idx);
		}
		System.out.println(sb);
	}
	
}
