import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CF83C {

	public static class Result {
		int tank;
		int tap;
		int vol;

		public Result(int tank, int tap, int vol) {
			this.tank = tank;
			this.tap = tap;
			this.vol = vol;
		}
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().split("\\s+");
		int n = Integer.parseInt(parts[0]);
		int p = Integer.parseInt(parts[1]);
		int[][] graph = new int[n + 1][n + 1];
		for (int i = 0; i < p; i++) {
			parts = br.readLine().split("\\s+");
			int s = Integer.parseInt(parts[0]);
			int t = Integer.parseInt(parts[1]);
			int d = Integer.parseInt(parts[2]);
			graph[s][t] = d;
		}
		List<Result> res = new ArrayList<CF83C.Result>();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (graph[i][j] == 0)
					continue;
				int minFlow = graph[i][j];
				int new_i = i;
				int new_j = j;
				boolean isCycle = false;
				boolean found = false;
				do {
					found = false;
					for (int k = 1; k <= n; k++) {
						if (graph[k][new_i] != 0) {
							if (minFlow > graph[k][new_i])
								minFlow = graph[k][new_i];
							graph[k][new_i] = 0;
							new_i = k;
							if (new_i == i)
								isCycle = true;
							found = true;
							break;
						}
					}
				} while (found && !isCycle);
				if (!isCycle) {
					found = false;
					do {
						found = false;
						for (int k = 1; k <= n; k++) {
							if (graph[new_j][k] != 0) {
								if (minFlow > graph[new_j][k])
									minFlow = graph[new_j][k];
								graph[new_j][k] = 0;
								new_j = k;
								found = true;
								break;
							}
						}
					} while (found);
					Result result = new Result(new_i, new_j, minFlow);
					res.add(result);
				}
				graph[i][j] = 0;
			}
		}
		if (res.size() == 0) {
			System.out.println(0);
		} else {
			int[] tanks = new int[res.size()];
			int i = 0;
			for (Result result : res) {
				tanks[i++] = result.tank;
			}
			Arrays.sort(tanks);
			System.out.println(tanks.length);
			for (i = 0; i < tanks.length; i++) {
				int j = 0;
				for (Result result : res) {
					if (result.tank == tanks[i]) {
						System.out.println(result.tank + " " + result.tap + " "
								+ result.vol);
						break;
					}
					j++;
				}
				res.remove(j);
			}
		}

	}
}
