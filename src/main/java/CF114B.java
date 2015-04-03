import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CF114B {
	
	public static class Pair{
		String s = null;
		boolean isPow = false;
		public Pair(String s, boolean isPow){
			this.s = s;
			this.isPow = isPow;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = null;
		List<Pair> res = new ArrayList<Pair>();
		while (null != (str = br.readLine())) {
			int l = str.length();
			boolean nowIsPower = false;
			for (int i = 0; i < l; i++) {
				if ((int)str.charAt(i) != 0x20) {
					if((int)str.charAt(i) == 0x23){
						nowIsPower = true;
					}
					break;
				}
			}			
			if(!nowIsPower){
				str = str.replaceAll((char)0x20+"", "");
			}
			res.add(new Pair(str, nowIsPower));
		}	
		StringBuffer sb = new StringBuffer();
		boolean isInit = false;
		for(Pair p : res){
			if(p.isPow){
				if(isInit){
					System.out.println(sb.toString());
					sb = new StringBuffer();
					isInit = false;
				}
				System.out.println(p.s);
			} else {
				isInit = true;
				sb.append(p.s);
			}
		}
		if(isInit){
			System.out.println(sb.toString());
		}
	}
}
