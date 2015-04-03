import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


public class CFYQ1B {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String orig = br.readLine();
		String res = orig.replaceAll("\\s*,\\s*", ", ");
		res = res.replaceAll("\\s*\\.\\.\\.\\s*", " ...");
		if(orig.startsWith("...")){
			res = res.substring(1);
		}
		if(orig.endsWith(",")){
			res = res.substring(0, res.length()-1);
		}
		res = res.replaceAll("\\s+", " ");
//		System.out.println(res.length());
		System.out.println(res);
	}
	
	public static void method1() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String orig = br.readLine();//.replaceAll("\\s+", " ");		
		String[] parts = orig.split(",",orig.length());
		StringBuffer sbres = new StringBuffer();
		for(int i = 0; i<parts.length; i++){
			parts[i] = parts[i].trim();
			String[] internParts = parts[i].split("\\.\\.\\.",parts[i].length());
			StringBuffer sb = new StringBuffer();
			for(int j = 0; j < internParts.length; j++){
				internParts[j] = internParts[j].trim();
				String dots = ((i!=0||j!=0)?" ":"")+"..."; 
				sb.append(internParts[j]+(j+1==internParts.length?"":dots));
			}
			sbres.append(sb+(i+1==parts.length?"":", "));
		}
		String newStr = sbres.toString().replaceAll("\\s+", " ");
		String res = newStr;
		if(orig.charAt(orig.length()-1)==','){
			res = newStr.substring(0,newStr.length()-1);			
		}
		//System.out.println(res.length());
		System.out.println(res);
//		String line = ",...,";
//		String[] parts = line.split(",",line.length());
//		System.out.println(parts.length);
//		for(String s : parts){
//			System.out.println(s+":len:" + s.length());
//		}

	}

}
