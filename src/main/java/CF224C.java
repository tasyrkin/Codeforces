import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CF224C {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String[] ps = br.readLine().split("\\s+");
        for (int i = 0; i < ps.length; i++) {
            a[i] = Integer.parseInt(ps[i]);
        }

        if (n == 1) {
            System.out.println(-1);
            return;
        } else {
            Arrays.sort(a);
            if (n == 2) {
                int diff = a[1] - a[0];
                if (diff % 2 == 0 && diff > 0) {
                    System.out.println(3);
                    System.out.println((a[0] - diff) + " " + (a[0] + diff / 2) + " " + (a[1] + diff));
                } else {
                    if (diff == 0) {
                        System.out.println(1);
                        System.out.println(a[0]);
                    } else {
                        System.out.println(2);
                        System.out.println((a[0] - diff) + " " + (a[1] + diff));

                    }

                }

                return;
            } else {

                Map<Integer, Integer> m = new HashMap<Integer, Integer>();
                for (int i = 1; i < n; i++) {
                    int diff = a[i] - a[i - 1];
                    Integer cnt = m.get(diff);
                    if (cnt == null) {
                        cnt = 0;
                    }

                    ++cnt;
                    m.put(diff, cnt);
                }

                if (m.keySet().size() == 1) {
                    int diff = m.keySet().iterator().next();
                    if (diff == 0) {
                        System.out.println(1);
                        System.out.println(a[0]);
                    } else {
                        System.out.println(2);
                        System.out.println((a[0] - diff) + " " + (a[a.length - 1] + diff));
                    }

                    return;
                } else if (m.keySet().size() == 2) {
                    Iterator<Integer> it = m.keySet().iterator();
                    int diff1 = it.next();
                    int diff2 = it.next();
                    if (m.get(diff1) == 1 || m.get(diff2) == 1) {
                        if (m.get(diff1) == 1) {
                            if (diff1 % 2 == 0 && diff1 > 0) {
                                System.out.println(1);
                                for (int i = 1; i < n; i++) {
                                    int diff = a[i] - a[i - 1];
                                    if (diff == diff1) {
                                        System.out.println(a[i - 1] + diff / 2);
                                        return;
                                    }
                                }

                            }
                        } else if (m.get(diff2) == 1) {
                            if (diff2 % 2 == 0 && diff2 > 0) {
                                System.out.println(1);
                                for (int i = 1; i < n; i++) {
                                    int diff = a[i] - a[i - 1];
                                    if (diff == diff2) {
                                        System.out.println(a[i - 1] + diff / 2);
                                        return;
                                    }
                                }

                            }
                        }
                    }
                }

            }

            System.out.println(0);
        }

    }
}
