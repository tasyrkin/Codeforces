import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class KROK_QualDE {

	public static class Node{
		Node parent = null;
		String value;
		List<Node> childs = new ArrayList<Node>();		
	}
	
	public static int solve(Node parent, char[]docArr, int start){
		main: for(int i = start; i < docArr.length;){
			for(int j = i; j < docArr.length; j++){
				if(docArr[j] == '>' && j-1>0 && docArr[j-1]!='/'){
					Node n = new Node();
					n.value = new String(docArr, i+1, j-1-i);
					n.parent = parent;
					parent.childs.add(n);
					i = solve(n, docArr, j+1);
					continue main;
				}
				if(docArr[j] == '>' && j-1>0 && docArr[j-1]=='/'){
					Node n = new Node();
					n.value = new String(docArr, i+1, j-2-i);
					n.parent = parent;
					n.parent.childs.add(n);
					i = j+1;
					continue main;
				}
				if(docArr[j] == '/' && j-1>=0 && docArr[j-1] == '<'){
					int cnt = j;					
					while(docArr[cnt] != '>')cnt++;
					String closeTag = new String(docArr, j+1, cnt-1-j);
					if(parent.value.equals(closeTag)){
						return cnt+1;
					}
					i = cnt+1;
					return cnt+1;
				}
			}
		}
		return start;
	}
	
	static long res = 0;
	
	public static void solve2(List<Node> nodes, String[]reqs, int i){
		if(i == reqs.length){
			res++;
			return;
		}
		for(Node n : nodes){
			if(n.value.equals(reqs[i])){
				solve2(n.childs, reqs, i+1);
			} 
			solve2(n.childs, reqs, i);
			
		}
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] docArr = br.readLine().toCharArray();
		List<Node> roots = new ArrayList<Node>();
		main: for(int i = 0; i < docArr.length;){
			for(int j = i; j < docArr.length; j++){
				if(docArr[j] == '>' && j-1>0 && docArr[j-1]!='/'){
					Node n = new Node();
					n.value = new String(docArr, i+1, j-1-i);
					n.parent = null;
					roots.add(n);
					i = solve(n, docArr, j+1);
					continue main;
				}
				if(docArr[j] == '>' && j-1>0 && docArr[j-1]=='/'){
					Node n = new Node();
					n.value = new String(docArr, i+1, j-2-i);
					n.parent = null;
					roots.add(n);
					i = j+1;
					continue main;					
				}
				if(docArr[j] == '/' && j-1>0 && docArr[j-1]=='<'){
					i = j+1;
					continue main;					
				}
			}
		}
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++){
			String[] parts = br.readLine().split("\\s+");
			solve2(roots, parts, 0);
			System.out.println(res);
			res = 0;
		}
	}

}
