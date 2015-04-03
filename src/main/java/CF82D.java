import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class CF82D {

	private static class Pair {
		int i;
		int j;
		Character ch;
		boolean valid = true;

		public Pair(int i, int j, char ch) {
			this.i = i;
			this.j = j;
			this.ch = ch;
		}

		public String toString() {
			return "i:" + i + ",j:" + j + ",valid:" + valid + ",ch:" + ch;
		}
	}

	public static int NORTH = 0;
	public static int EAST = 1;
	public static int SOUTH = 2;
	public static int WEST = 3;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().split("\\s+");
		int n = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);
		char[][] map = new char[n][m];
		int[][][] seaSteps = new int[n][m][4];
		ArrayList<Pair> dosts = new ArrayList<Pair>();
		for (int i = 0; i < n; i++) {
			char[] mapRow = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = mapRow[j];
				if (map[i][j] != '.' && map[i][j] != '#') {
					Pair pair = new Pair(i, j, map[i][j]);
					dosts.add(pair);
				}
				if (map[i][j] == '#') {
					continue;
				}
				int tmp_i = i;
				if (i != 0) {
					if (seaSteps[i - 1][j][NORTH] != 0) {
						seaSteps[i][j][NORTH] = seaSteps[i - 1][j][NORTH] + 1;
					} else {
						while (map[--tmp_i][j] != '#') {
							seaSteps[i][j][NORTH]++;
						}
					}
				}
				int tmp_j = j;
				if (j != 0) {
					if (seaSteps[i][j - 1][WEST] != 0) {
						seaSteps[i][j][WEST] = seaSteps[i][j - 1][WEST] + 1;
					} else {
						while (map[i][--tmp_j] != '#') {
							seaSteps[i][j][WEST]++;
						}
					}
				}
			}
		}
		for (int i = n - 2; i > 0; i--) {
			for (int j = m - 2; j > 0; j--) {
				if (map[i][j] == '#')
					continue;
				int tmp_i = i;
				if (seaSteps[i + 1][j][SOUTH] != 0) {
					seaSteps[i][j][SOUTH] = seaSteps[i + 1][j][SOUTH] + 1;
				} else {
					while (map[++tmp_i][j] != '#') {
						seaSteps[i][j][SOUTH]++;
					}
				}
				int tmp_j = j;
				if (seaSteps[i][j + 1][EAST] != 0) {
					seaSteps[i][j][EAST] = seaSteps[i][j + 1][EAST] + 1;
				} else {
					while (map[i][++tmp_j] != '#') {
						seaSteps[i][j][EAST]++;
					}
				}
			}
		}

		int k = Integer.parseInt(br.readLine());
		for (int k_cnt = 0; k_cnt < k; k_cnt++) {
			parts = br.readLine().split("\\s+");
			char dir = parts[0].charAt(0);
			int len = Integer.parseInt(parts[1]);
			for (Pair dost : dosts) {
				if (!dost.valid)
					continue;
				int i = dost.i;
				int j = dost.j;
				if (dir == 'N') {
					if (seaSteps[i][j][0] < len) {
						dost.valid = false;
					} else {
						dost.i = i - len;
					}
				}
				if (dir == 'S') {
					if (seaSteps[i][j][2] < len) {
						dost.valid = false;
					} else {
						dost.i = i + len;
					}
				}
				if (dir == 'E') {
					if (seaSteps[i][j][1] < len) {
						dost.valid = false;
					} else {
						dost.j = j + len;
					}
				}
				if (dir == 'W') {
					if (seaSteps[i][j][3] < len) {
						dost.valid = false;
					} else {
						dost.j = j - len;
					}
				}
			}
		}
		ArrayList<Character> res = new ArrayList<Character>();
		for (Pair dost : dosts) {
			if (dost.valid) {
				res.add(dost.ch);
			}
		}
		if (res.size() == 0) {
			System.out.println("no solution");
		} else {
			Character[] resChar = res.toArray(new Character[res.size()]);
			Arrays.sort(resChar);
			for (Character ch : resChar) {
				System.out.print(ch);
			}
			System.out.println();
		}
	}
}
