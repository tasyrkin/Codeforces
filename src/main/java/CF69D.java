import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CF69D {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int t = -1;
		while(null != (line = br.readLine())){
			if(t == -1){
				t = Integer.parseInt(line);
				continue;
			}
			String[] parts = line.split("\\s+");
			double a = Integer.parseInt(parts[0]);
			double b = Integer.parseInt(parts[1]);
			//System.out.println("a:"+a+",b:"+b);
			double res = 0;
			if(a==0&&b==0){
				res = 1;
			}
			else if(a==0){
				res = (double)1/2;
			}
			else if(b==0){
				res = (double)1;
			}
			else if(a/4<=b){
				res = ((double)1/2+a/(16*b));
			}
			else if(a/4>b){
				res = ((double)1-b/a);
			}
			System.out.format("%f", res).println();
			if(--t<=0)break;
		}
	}
}
