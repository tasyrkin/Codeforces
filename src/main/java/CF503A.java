import java.util.Scanner;

public class CF503A {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int h = sc.nextInt();
        final int a = sc.nextInt();
        final int b = sc.nextInt();
        final int k = sc.nextInt();

        for (int query = 0; query < k; query++) {
            Position init = new Position(sc.nextInt(), sc.nextInt());
            Position finish = new Position(sc.nextInt(), sc.nextInt());

            if (init.tower > finish.tower) {
                swap(init, finish);
            }

            if (init.tower == finish.tower) {
                System.out.println(Math.abs(init.floor - finish.floor));
            } else {
                int towerComponent = finish.tower - init.tower;
                Pair initFloorPair = getFloorComponent(a, b, init);
                Pair finisFloorPair = getFloorComponent(a, b, finish);
                int betweenFloors = Math.abs(initFloorPair.second - finisFloorPair.second);

                System.out.println(towerComponent + initFloorPair.first + finisFloorPair.first + betweenFloors);
            }

        }

    }

    private static Pair getFloorComponent(final int a, final int b, final Position init) {

        int floorComponent = 0;
        int newFloor = init.floor;
        if (init.floor < a) {
            floorComponent = a - init.floor;
            newFloor = a;
        } else if (init.floor > b) {
            floorComponent = init.floor - b;
            newFloor = b;
        }
        return new Pair(floorComponent, newFloor);
    }

    private static void swap(Position p1, Position p2) {
        int tmp = p1.floor;
        p1.floor = p2.floor;
        p2.floor = tmp;

        tmp = p1.tower;
        p1.tower = p2.tower;
        p2.tower = tmp;
    }

    private static class Pair {
        int first;
        int second;

        public Pair(final int first, final int second) {
            this.first = first;
            this.second = second;
        }
    }

    private static class Position {
        int tower;
        int floor;

        public Position(final int tower, final int floor) {
            this.tower = tower;
            this.floor = floor;
        }
    }
}
