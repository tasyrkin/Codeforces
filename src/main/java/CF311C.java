import java.util.*;

public class CF311C {

    private static class Part{
        int length;
        int index;

        public Part(int length, int index) {
            this.length = length;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Part{" +
                    "length=" + length +
                    ", index=" + index +
                    '}';
        }
    }

    private static class Pair{
        int min;
        int max;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Part[]length = new Part[n];
        Map<Integer, Part> lengthMap = new HashMap<>();
        for(int i = 0; i < length.length; i++){
            length[i] = new Part(sc.nextInt(), i);
            lengthMap.put(i, length[i]);
        }
        Set[]energy = new Set[201];
        int[]energyIdx = new int[n];
        int fullEnergy = 0;
        Pair[]energyBorders = new Pair[201];
        for(int i = 0; i < n; i++){
            int en = sc.nextInt();
            if(energy[en] == null){
                energy[en] = new HashSet();
            }
            energy[en].add(i);
            energyIdx[i] = en;
            fullEnergy += en;

            if(energyBorders[en] == null){
                energyBorders[en] = new Pair(length[i].length, length[i].length);
            } else {
                if(energyBorders[en].min>length[i].length){
                    energyBorders[en].min = length[i].length;
                }
                if(energyBorders[en].max<length[i].length){
                    energyBorders[en].max = length[i].length;
                }
            }
        }

        Arrays.sort(length, new MyComparator());

        int minEnergy = Integer.MAX_VALUE;

        Part currLen = length[0];
        Set<Integer> currIdx = new HashSet<>();
        currIdx.add(length[0].index);
        int currEnergy = energyIdx[length[0].index];
        for(int i = 1; i < length.length; i++){
            if(length[i].length != currLen.length){
                int needFind = currIdx.size() - 1;
                int found = 0;
                engy: for(int j = energy.length-1; j >= 0; j--){
                    if(energy[j] == null)continue;
                    if(currLen.length>=energyBorders[j].min) {
                        for (Integer energyIndex : (Set<Integer>) energy[j]) {
                            if (found >= needFind) break engy;
                            if (!currIdx.contains(energyIndex) && currLen.length >= lengthMap.get(energyIndex).length) {
                                currIdx.add(energyIndex);
                                currEnergy += j;
                                found++;
                            }
                        }
                    }
                }
                if(fullEnergy - currEnergy < minEnergy)minEnergy = fullEnergy - currEnergy;

                currLen = length[i];
                currIdx = new HashSet<>();
                currIdx.add(length[i].index);
                currEnergy = energyIdx[length[i].index];

            } else {
                currIdx.add(length[i].index);
                currEnergy += energyIdx[length[i].index];
            }
        }

        int needFind = currIdx.size() - 1;
        int found = 0;
        engy: for(int j = energy.length - 1; j >= 0; j--){
            if(energy[j] == null)continue;
            if(currLen.length>=energyBorders[j].min) {
                for (Integer energyIndex : (Set<Integer>) energy[j]) {
                    if (found >= needFind) break engy;
                    if (!currIdx.contains(energyIndex) && currLen.length >= lengthMap.get(energyIndex).length) {
                        currIdx.add(energyIndex);
                        currEnergy += j;
                        found++;
                    }
                }
            }
        }
        if(fullEnergy - currEnergy < minEnergy)minEnergy = fullEnergy - currEnergy;


        System.out.println(minEnergy);

    }

    private static class MyComparator implements java.util.Comparator<Part> {
        @Override
        public int compare(Part o1, Part o2) {
            return Integer.valueOf(o1.length).compareTo(o2.length);
        }
    }
}
