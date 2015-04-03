import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CFT9D {

    private static class Item {
        Integer pos;
        int level;
        Item prev;

        public Item(final Integer[] p, final int lvl, final Item pr) {
            pos = toInt(p);
            level = lvl;
            prev = pr;
        }

        public Item(final Integer p, final int lvl, final Item pr) {
            pos = p;
            level = lvl;
            prev = pr;
        }
    }

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] m = new char[n][n];
        String[] ps = br.readLine().split("\\s+");
        Integer[] a = new Integer[3];
        for (int i = 0; i < ps.length; i++) {
            a[i] = Integer.parseInt(ps[i]) - 1;
        }

        for (int i = 0; i < n; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < ch.length; j++) {
                m[i][j] = ch[j];
            }
        }

        Queue<Item> q = new LinkedList<Item>();
        q.add(new Item(a, 0, null));

        // Set<Integer> set = new HashSet<Integer>();
        int[][][] set = new int[70][70][70];
        while (!q.isEmpty()) {
            Item curr = q.poll();

            // Integer s = toString(curr.pos);
            Integer[] currPos = toArray(curr.pos);
            Arrays.sort(currPos);
            if (set[currPos[0]][currPos[1]][currPos[2]] != 2) {
                set[currPos[0]][currPos[1]][currPos[2]] = 2;
                if (currPos[0] == 0 && currPos[1] == 1 && currPos[2] == 2) {
                    System.out.println(curr.level);

                    Item tmp = curr;
                    LinkedList<String> moves = new LinkedList<String>();
                    while (tmp.prev != null) {
                        Integer[] prPos = toArray(tmp.prev.pos);
                        Integer[] crPos = toArray(tmp.pos);
                        Set<Integer> foundInBoth = new HashSet<Integer>();
                        for (int i = 0; i < prPos.length; i++) {
                            for (int j = 0; j < prPos.length; j++) {
                                if (prPos[i] == crPos[j]) {

                                    // moves.addLast((prPos[i] + 1) + " " + (crPos[i] + 1));
                                    foundInBoth.add(crPos[j]);
                                    break;
                                }
                            }
                        }

                        int prevInt = -1;
                        int currInt = -1;
                        for (int i = 0; i < prPos.length; i++) {
                            if (!foundInBoth.contains(prPos[i])) {
                                prevInt = prPos[i];
                            }

                            if (!foundInBoth.contains(crPos[i])) {
                                currInt = crPos[i];
                            }
                        }

                        moves.addFirst((prevInt + 1) + " " + (currInt + 1));

                        tmp = tmp.prev;
                    }

                    StringBuffer sb = new StringBuffer();
                    for (String mov : moves) {
                        sb.append(mov + "\n");
                    }

                    System.out.println(sb.toString());
                    return;
                }

                for (int i = 0; i < 3; i++) {
                    int next = (i + 1) % 3;
                    int nextNext = (i + 2) % 3;
                    for (int j = 0; j < n; j++) {
                        if (j != currPos[next] && j != currPos[nextNext] && j != currPos[i]
                                && m[currPos[next]][currPos[nextNext]] == m[j][currPos[i]]) {
                            Integer[] nextMove = new Integer[3];
                            nextMove[i] = j;
                            nextMove[next] = currPos[next];
                            nextMove[nextNext] = currPos[nextNext];
                            Arrays.sort(nextMove);

                            // if (!set.contains(toString(nextMove))) {
                            if (set[nextMove[0]][nextMove[1]][nextMove[2]] == 0) {
                                set[nextMove[0]][nextMove[1]][nextMove[2]] = 1;
                                q.add(new Item(nextMove, curr.level + 1, curr));
                            }
                        }
                    }
                }
            }

        }

        System.out.println(-1);

    }

    private static Integer toInt(final Integer[] a) {
        return 10000 * a[0] + 100 * a[1] + a[2];
    }

    private static Integer[] toArray(final Integer a) {
        Integer[] res = new Integer[3];
        res[2] = a % 100;
        res[1] = ((a - res[2]) % 10000) / 100;
        res[0] = a / 10000;
        return res;
    }

}
