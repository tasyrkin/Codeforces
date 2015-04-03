import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CF94B {

	public static class Node {
		Integer val;
		boolean inPrs;

		public Node(Integer val, boolean inPrs) {
			this.val = val;
			this.inPrs = inPrs;
		}

		public boolean equals(Object o) {
			if (o != null && o instanceof Node) {
				Node n = (Node) o;
				return val == n.val;
			}
			return false;
		}

		public int hashCode() {
			return val.hashCode();
		}
		public String toString(){
			return val + ":" + inPrs;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().split("\\s+");
		int n = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);
		Map<Node, ArrayList<Node>> graph = new HashMap<Node, ArrayList<Node>>();
		for (int i = 0; i < m; i++) {
			parts = br.readLine().split("\\s+");
			int a = Integer.parseInt(parts[0]);
			int b = Integer.parseInt(parts[1]);
			Node A = new Node(a, false);
			Node B = new Node(b, false);
			ArrayList<Node> list = graph.get(A);
			if (list == null) {
				list = new ArrayList<CF94B.Node>();
			}
			list.add(B);
			graph.put(A, list);

			list = graph.get(B);
			if (list == null) {
				list = new ArrayList<CF94B.Node>();
			}
			list.add(A);
			graph.put(B, list);
		}

		boolean flag = true;
		int count = 0;
		while (flag) {
			flag = false;
			Iterator<Node> iter = graph.keySet().iterator();
			while (iter.hasNext()) {
				Node nod = iter.next();
				ArrayList<Node> list = graph.get(nod);
				if (list != null && list.size() == 1) {
					flag = true;
					nod.inPrs = true;
				}
			}
			Iterator<Entry<Node,ArrayList<Node>>> entrIter = graph.entrySet().iterator();
			Set<Node> toRem = new HashSet<Node>();
			while(entrIter.hasNext()){
				Entry<Node,ArrayList<Node>> entr = entrIter.next();
				if(entr.getKey().inPrs){
					toRem.add(entr.getKey());					
				}
			}
			for(Node nod : toRem){
				graph.remove(nod);
				Iterator<Node> iter1 = graph.keySet().iterator();
				while (iter1.hasNext()) {
					Node nod1 = iter1.next();
					ArrayList<Node> list = graph.get(nod1);
					list.remove(nod);
				}				
			}
			if(flag)count++;
		}
		System.out.println(count);
	}
}
