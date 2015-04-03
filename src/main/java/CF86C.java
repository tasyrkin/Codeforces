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

public class CF86C {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer n = Integer.parseInt(br.readLine());
		int[] mns = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			mns[i] = Integer.parseInt(br.readLine());
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			Integer level = map.get(mns[i]);
			int cnt = 0;
			int curr = i;
			if (level == null) {
				do {
					int p = mns[curr];
					if (p == -1) {
						level = 1;
						map.put(curr, level);
						break;
					}
					if (mns[p] == -1) {
						level = 1;
					} else {
						level = map.get(p);
					}
					curr = p;
					cnt++;
				} while (level == null);
				int currLevel = level + cnt;
				map.put(i, currLevel);
				if (max < currLevel)
					max = currLevel;
			} else {
				int currLevel = level + 1;
				map.put(i, currLevel);
				if (max < currLevel)
					max = currLevel;
			}
		}
		System.out.println(max);
	}
}
