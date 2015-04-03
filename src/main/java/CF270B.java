import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class CF270B {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");
        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);
        parts = br.readLine().split("\\s+");

        LinkedList<Integer> people = new LinkedList<Integer>();
        int[] dest = new int[n];
        for (int i = 0; i < n; i++) {
            dest[i] = Integer.parseInt(parts[i]) - 1;
        }

        Arrays.sort(dest);
        for (int i : dest) {
            people.add(i);
        }

        int count = 0;
        int floor = 0;
        while (!people.isEmpty()) {
            int nextFloor = people.get(0);
            int steps = people.size() / k + (people.size() % k == 0 ? 0 : 1);
            count += (2 * (steps - 1) + 1) * (nextFloor - floor);
            floor = nextFloor;

            Iterator<Integer> pIter = people.iterator();
            while (pIter.hasNext()) {
                Integer val = pIter.next();
                if (val == floor) {
                    pIter.remove();
                }
            }
        }

        System.out.println(count + floor);

    }
}
