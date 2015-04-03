import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CF83VDIV1A {

	public static class Result implements Comparable {
		Integer tank;
		Integer tap;
		Integer diam;

		public Result(int tank, int tap, int diam) {
			this.tank = tank;
			this.tap = tap;
			this.diam = diam;
		}

		@Override
		public int compareTo(Object arg0) {
			Result r = (Result) arg0;
			return this.tank.compareTo(r.tank);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().split("\\s+");
		int n = Integer.parseInt(parts[0]);
		int p = Integer.parseInt(parts[1]);
		int[] diam = new int[n];
		int[] graph = new int[n];
		Arrays.fill(graph, -1);
		if(p==0){
			System.out.println(0);
			return;
		}
		// Map<Integer, ArrayList<Integer>> map = new HashMap<Integer,
		// ArrayList<Integer>>();
		for (int i = 0; i < p; i++) {
			parts = br.readLine().split("\\s+");
			int a = Integer.parseInt(parts[0]);
			int b = Integer.parseInt(parts[1]);
			int d = Integer.parseInt(parts[2]);
			diam[a - 1] = d;
			graph[a - 1] = b - 1;
		}
		ArrayList<Result> res = new ArrayList<CF83VDIV1A.Result>();
		Set<Integer> visited = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			if (visited.contains(i))
				continue;
			visited.add(i);
			int prev = i;
			int next = i;
			int min = Integer.MAX_VALUE;
			boolean isCycle = false;
			while (graph[next] != -1) {
				if (min > diam[next]) {
					min = diam[next];
				}
				next = graph[next];
				visited.add(next);
				if (next == i) {
					isCycle = true;
					break;
				}
			}
			if (!isCycle&&prev!=next) {
				boolean found = true;
				while (found) {
					found = false;
					for (int j = 0; j < n; j++) {
						if (graph[j] == prev) {
							visited.add(j);
							if (min > diam[j]) {
								min = diam[j];
							}
							prev = j;
							found = true;
							break;
						}
					}
				}
				res.add(new Result(prev, next, (min == Integer.MAX_VALUE ? 0
						: min)));
			}
		}
		System.out.println(res.size());
		Result[] arrRes = res.toArray(new Result[res.size()]);
		Arrays.sort(arrRes);
		for (Result r : arrRes) {
			System.out.println((r.tank + 1) + " " + (r.tap + 1) + " " + r.diam);
		}
	}
}
