import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CF88C_Failed {

	private static final int INIT_LEVEL = -100;

	private static class Node {
		Short value;
		Short level;

		public Node(short value) {
			this.value = value;
			this.level = INIT_LEVEL;
		}

		public boolean equals(Object o) {
			if (o != null && o instanceof Node) {
				Node n = (Node) o;
				return n.value == value;
			}
			return false;
		}

		public int hashCode() {
			return value.hashCode();
		}
	}

	private static String cycle = null;

	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Node[]nodes = new Node[n];
		for(int i = 0; i < n; i++){
			nodes[i] = new Node((short)i);
		}
		Map<Node, HashSet<Node>> graph = new HashMap<Node, HashSet<Node>>();
		for (int i = 0; i < n; i++) {
			char[] row = br.readLine().toCharArray();
			for (int j = 0; j < row.length; j++) {
				if (row[j] == '1') {
					Node node_i = nodes[i];
					HashSet<Node> list = graph.get(node_i);
					if (list == null) {
						list = new HashSet<Node>();
					}
					list.add(nodes[j]);
					graph.put(node_i, list);
				}
			}
		}
		Set<Node> visited = new HashSet<Node>();
		Iterator<Node> iter = graph.keySet().iterator();
		while (iter.hasNext()) {
			Node curr = iter.next();
			if (visited.contains(curr)) {
				continue;
			}
			curr.level = 1;
			solve(graph, curr,visited);
			curr.level = INIT_LEVEL;
			if(cycle!=null)break;
		}
		if (cycle == null) {
			System.out.println(-1);
		} else {
			System.out.println(cycle);
		}
	}

	private static void solve(Map<Node, HashSet<Node>> graph, Node curr, Set<Node> visited) {
		if (cycle != null)
			return;
		if(visited.contains(visited)){
			return;
		}
		visited.add(curr);
		HashSet<Node> list = graph.get(curr);
		if (list == null)
			return;
		for (Node n : list) {
			if(cycle!=null)return;
			if(n.level!=INIT_LEVEL&&curr.level - n.level > 2)continue;
			if (curr.level - n.level == 2) {				
				HashSet<Node> list2 = graph.get(n);
				if (list2 != null) {
					for (Node n2 : list2) {
						if(cycle!=null)return;
						if (curr.level - n2.level == 1
								&& n2.level - n.level == 1) {
							HashSet<Node> list3 = graph.get(n2);
							if(list3!=null&&list3.contains(curr)){
								cycle = (n.value+1) + " " + (n2.value+1) + " " + (curr.value+1);
								return;
							}
						}
					}
				}
			} else if (n.level == INIT_LEVEL) {
				n.level = (short) (curr.level + 1);
				solve(graph, n, visited);
				n.level = INIT_LEVEL;
			}
		}
	}

	// private static void solve(int i) {
	// String a = "abcdefghijklmnopqrstuvwxyz";
	// int[]m = new int[1000];
	// long[]c = new long[1000];
	// System.out.println(i);
	// solve(i+1);
	// }

}
