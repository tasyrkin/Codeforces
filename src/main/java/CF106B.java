import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CF106B {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println(((int)'0'-55) + " " + ((int)'Z'-55));
		String[]parts = br.readLine().split(":");
		List<Integer> res = new ArrayList<Integer>();
		char[] hrs = parts[0].toCharArray();
		char[] minutes = parts[1].toCharArray();
		boolean isHrsInf = true;
		for(int i = 0; i < hrs.length-1; i++){
			if(hrs[i]!='0')isHrsInf = false;
		}
		boolean isMinInf = true;		
		for(int i = 0; i < minutes.length-1; i++){
			if(minutes[i]!='0')isMinInf = false;
		}
		if(isHrsInf&&isMinInf){
			int hrsCurr = 0;
			if(hrs[hrs.length-1]>'9'){
				hrsCurr = (int)hrs[hrs.length-1]-55;
			} else {
				hrsCurr = Integer.parseInt(hrs[hrs.length-1]+"");
			}
			int minCurr = 0;			
			if(minutes[minutes.length-1]>'9'){
				minCurr = (int)minutes[minutes.length-1]-55;
			} else {
				minCurr = Integer.parseInt(minutes[minutes.length-1]+"");
			}
			if(hrsCurr>=0&&hrsCurr<=23&&minCurr>=0&&minCurr<=59){
				System.out.println(-1);
				return;
			}
		}
		maincycle:
		for(int i = 2; i <= 10000; i++){			
			
			int hrsTot = 0;
			for(int j = hrs.length-1; j >= 0; j--){
				int hrsCurr = 0;
				if(hrs[hrs.length-1-j]>'9'){
					hrsCurr = (int)hrs[hrs.length-1-j]-55; 
				} else {
					hrsCurr = Integer.parseInt(hrs[hrs.length-1-j]+"");
				}
				if(hrsCurr>=i)continue maincycle;
				hrsTot += hrsCurr*Math.pow(i, j);
			}			
			int minTot = 0;
			for(int j = minutes.length-1; j >= 0; j--){
				int minCurr = 0;
				if(minutes[minutes.length-1-j]>'9'){
					minCurr = (int)minutes[minutes.length-1-j]-55; 
				} else {
					minCurr = Integer.parseInt(minutes[minutes.length-1-j]+"");
				}
				if(minCurr>=i)continue maincycle;
				minTot += minCurr*Math.pow(i, j);
			}
			if(hrsTot>=0&&hrsTot<=23&&minTot>=0&&minTot<=59){
				res.add(i);
			}
		}
		if(res.size()==0){
			System.out.println(0);
		} else{
			boolean isFirst = true;
			for(Integer i : res){
				System.out.print((isFirst?"":" ") + i);
				isFirst = false;
			}
		}
	}

}
