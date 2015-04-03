import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  tasyrkin
 * @since   2013/07/13
 */
public class MemSQLA {

    private static class Sq {
        Pair botLeft;
        Pair topRight;

        public Sq(final Pair bl, final Pair tr) {
            botLeft = bl;
            topRight = tr;
        }
    }

    private static class Pair {
        int x;
        int y;

        Pair(final int a, final int b) {
            x = a;
            y = b;
        }

        public boolean equals(final Object o) {
            if (o instanceof Pair) {
                Pair pair = (Pair) o;
                return pair.x == x && pair.y == y;

            }

            return false;
        }

        public int hashCode() {
            return Integer.valueOf(x) + Integer.valueOf(y);
        }
    }

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Pair[][] sqs = new Pair[n][4];
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split("\\s+");
            int bx = Integer.parseInt(parts[0]);
            int by = Integer.parseInt(parts[1]);
            int tx = Integer.parseInt(parts[2]);
            int ty = Integer.parseInt(parts[3]);
            sqs[i][0] = new Pair(bx, by);
            sqs[i][1] = new Pair(bx, ty);
            sqs[i][2] = new Pair(tx, by);
            sqs[i][3] = new Pair(tx, ty);
        }

        for (int i1 = 0; i1 < sqs.length; i1++) {
            for (int j1 = 0; j1 < sqs[0].length; j1++) {
                for (int i2 = 0; i2 < sqs.length; i2++) {
                    for (int j2 = 0; j2 < sqs[0].length; j2++) {
                        if (sqs[i1][j1].x < sqs[i2][j2].x && sqs[i1][j1].y < sqs[i2][j2].y) {
                            if (sqs[i1][j1].x - sqs[i2][j2].x == sqs[i1][j1].y - sqs[i2][j2].y) {
                                for (int i = 1; i < 32; i++) {

                                    List<Integer> ys = new ArrayList<Integer>();

                                    if (((i >> 0) & 1) == 1) {
                                        ys.add(sqs[(i >> 0)][0].y);
                                    }

                                }
                            }
                        }
                    }
                }

            }
        }

    }
}
