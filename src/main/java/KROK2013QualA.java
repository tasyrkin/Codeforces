import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA. User: admin Date: 4/13/13 Time: 3:35 PM To change this template use File | Settings |
 * File Templates.
 */
public class KROK2013QualA {
    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<String, Integer>();
        String[] parts = br.readLine().split("\\s+");
        for (int i = 0; i < n; i++) {
            if ("0".equals(parts[i])) {
                continue;
            }

            Integer num = map.get(parts[i]);
            if (num == null) {
                num = 0;
            }

            ++num;
            map.put(parts[i], num);
        }

        int res = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                continue;
            } else if (e.getValue() == 2) {
                ++res;
            } else {
                System.out.println("-1");
                return;
            }
        }

        System.out.println(res);
    }
}
