import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class CF69E {
	public static class Node{
		String id;
		Integer beavers;
		public Node(String id, Integer beavers){
			this.id = id;
			this.beavers = beavers;
		}
		public int hashCode(){
			return id.hashCode();
		}
		public String toString(){
			return "(" + id + "," + beavers + ")";
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = -1;
		String line = null;
		String[] parts = null;
		String vertex = null;
		HashMap<String, ArrayList<Node>> graph = new HashMap<String, ArrayList<Node>>();
		HashMap<String, Node> vertices = new HashMap<String, Node>();	
		while(null != (line = br.readLine())){
			if(n == -1){
				n = Integer.parseInt(line);
				parts = br.readLine().split("\\s+");
				for(int i = 1; i <=n; i++){
					Node node = new Node(""+i, Integer.parseInt(parts[i-1]));
					vertices.put(""+i,node);
				}
				continue;
			}
			parts = line.split("\\s+");
			ArrayList<Node> list = graph.get(parts[0]);
			if(list==null){
				list = new ArrayList<Node>();
			}
			list.add(vertices.get(parts[1]));
			graph.put(parts[0], list);
			//undirected graph => adding reverse edge
			list = graph.get(parts[1]);
			if(list==null){
				list = new ArrayList<Node>();
			}
			list.add(vertices.get(parts[0]));
			graph.put(parts[1], list);
			if(--n<=1){
				vertex = br.readLine();
				break;
			}
		}
		Iterator<String> idIter = graph.keySet().iterator();
		while(idIter.hasNext()){
			String id = idIter.next();
			System.out.print(vertices.get(id).toString() + " => ");
			ArrayList<Node> list = graph.get(id);
			if(list!=null){
				for(Node node : list){
					System.out.print(node.toString() + " ");
				}
			}
			System.out.println();
		}
		if(vertices.get(vertex).beavers==0){
			System.out.println(0);
			return;
		}
		HashMap<String, Integer> distances = BFS(graph,vertex);
		
		int count = 0;
		String vertexToExplore = vertex;
		while(true){
			int currDistance = distances.get(vertexToExplore);
			Node currNode = vertices.get(vertexToExplore);
			//System.out.println("Node2Explore:" + currNode.toString());
			ArrayList<Node> siblings = graph.get(vertexToExplore);
//			System.out.print("SIBLINGS: ");
//			for(Node sib : siblings){
//				System.out.print(sib.toString() + " ");
//			}
//			System.out.println();
			int maxLevel = -1;
			int maxNodes = -1;
			int maxBeavers = -1;
			Node maxBeaversNode = null;
			
			System.out.print("NEXT2CHOOSE for " + currNode + " with currDistance("+currDistance+"):");
			for(Node sib : siblings){
				System.out.print(sib.toString() + "+dist(" + distances.get(sib.id) + ")");
				if(currNode.beavers==0&&currNode.id.equals(vertex)){
					break;
				}
				if(currNode.beavers==0){
					if(currDistance>=distances.get(sib.id)){
						maxBeaversNode = sib;
					}
				}
				else{
					if(maxLevel==-1){
						maxLevel = distances.get(sib.id);
						maxBeaversNode = sib;
						maxNodes = graph.get(sib.id).size();
						maxBeavers = sib.beavers;
					}
					if(maxBeavers<sib.beavers&&sib.beavers!=0){
						maxLevel = distances.get(sib.id);
						maxBeaversNode = sib;
						maxNodes = graph.get(sib.id).size();
						maxBeavers = sib.beavers;
					}
					else if(maxLevel<distances.get(sib.id)&&sib.beavers!=0){
						maxLevel = distances.get(sib.id);
						maxBeaversNode = sib;
						maxNodes = graph.get(sib.id).size();
						maxBeavers = sib.beavers;
					}
					else if(maxLevel==distances.get(sib.id)&&sib.beavers!=0){
						if(maxNodes<graph.get(sib.id).size()){
							maxLevel = distances.get(sib.id);
							maxBeaversNode = sib;
							maxBeavers = sib.beavers;
						}
					}
				}
			}
			System.out.println();
			if(maxBeaversNode==null||maxBeaversNode.beavers==0){
				break;					
			}
			System.out.println("next:"+maxBeaversNode.toString()+",explored:" + vertices.get(vertexToExplore).toString());
			maxBeaversNode.beavers--;
			count++;
			vertexToExplore = maxBeaversNode.id;
		}
		System.out.println(count);
	}
	private static HashMap<String,Integer> BFS(HashMap<String, ArrayList<Node>> graph, String v){
		HashMap<String,Integer> res = new HashMap<String, Integer>();
		HashSet<String> visited = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		queue.add(v);
		visited.add(v);
		res.put(v, 0);
		while(queue.size()>0){
			String curr = queue.remove();
			ArrayList<Node> siblings = graph.get(curr);
			Integer dist = res.get(curr);
			if(siblings!=null){
				for(Node sib : siblings){
					if(!visited.contains(sib.id)){
						visited.add(sib.id);
						queue.add(sib.id);
						res.put(sib.id, dist+1);
					}
				}
			}
		}
		return res;
	}

}
