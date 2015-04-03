import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CF111D {

	public static class Node{
		int weight = 0;
		int vertex;
		public Node(int weight, int vertex){
			this.weight = weight;
			this.vertex = vertex;
		}
	}
	
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a = br.readLine().split("\\s+");
		int n = Integer.parseInt(a[0]);
		int m = Integer.parseInt(a[1]);
		List<Node>[] graph = new ArrayList[n];
		for(int i = 0; i < m; i++){
			a = br.readLine().split("\\s+");
			int s = Integer.parseInt(a[0]);
			int e = Integer.parseInt(a[1]);
			int w = Integer.parseInt(a[2]);
			List<Node> list = graph[s];
			if(list == null){
				list = new ArrayList<CF111D.Node>();
			}
			list.add(new Node(w,e));
		}
		
	}

}
