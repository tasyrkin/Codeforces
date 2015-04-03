import java.util.Arrays;
import java.util.Scanner;

public class CF271C {

    private static class Point {
        int x;
        int y;

        private Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        public Point rotate(final Point home) {
            int newx = x - home.x;
            int newy = y - home.y;
            int rotatedx = -newy + home.x;
            int rotatedy = newx + home.y;

            return new Point(rotatedx, rotatedy);
        }

        @Override
        public String toString() {
            return "Point{" + "x=" + x + ", y=" + y + '}';
        }
    }

    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] positions = new Point[4];
        Point[] homes = new Point[4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                positions[j] = new Point(sc.nextInt(), sc.nextInt());
                homes[j] = new Point(sc.nextInt(), sc.nextInt());
            }

            int minRotations = determineRotations(positions, homes);
            System.out.println(minRotations == Integer.MAX_VALUE ? -1 : minRotations);
        }
    }

    private static int determineRotations(final Point[] positions, final Point[] homes) {
        Point[][] rotations = new Point[4][4];
        for (int crot = 0; crot < 4; crot++) {
            rotations[crot][0] = positions[crot];
            for (int rotation = 1; rotation < 4; rotation++) {
                rotations[crot][rotation] = rotations[crot][rotation - 1].rotate(homes[crot]);
            }
        }

        int[] used = new int[4];
        return solve(rotations, 0, 0, used);
    }

    private static int solve(final Point[][] rotations, final int crot, final int pos, final int[] used) {
        if (crot == 4) {
            Point[] toCheck = new Point[4];
            int moves = 0;
            for (int i = 0; i < 4; i++) {
                toCheck[i] = rotations[i][used[i]];
                moves += used[i];
            }

            if (isSquare(toCheck)) {
                return moves;
            }

            return Integer.MAX_VALUE;
        }

        int moves = Integer.MAX_VALUE;
        for (int currPos = pos; currPos < 4; currPos++) {
            used[crot] = currPos;
            moves = Math.min(solve(rotations, crot + 1, 0, used), moves);
        }

        return moves;
    }

    private static boolean isSquare(final Point[] toCheck) {
        long[] distSquare = new long[6];

        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                long xdiff = toCheck[i].x - toCheck[j].x;
                long ydiff = toCheck[i].y - toCheck[j].y;
                distSquare[cnt++] = xdiff * xdiff + ydiff * ydiff;
            }
        }

        Arrays.sort(distSquare);

        boolean isSquare = distSquare[4] == distSquare[5] && distSquare[5] > 0;
        isSquare = isSquare && distSquare[0] == distSquare[1] && distSquare[0] == distSquare[2]
                && distSquare[0] == distSquare[3];
        isSquare = isSquare && distSquare[4] == 2 * distSquare[0];
        return isSquare;
    }
}
