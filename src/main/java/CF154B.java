import java.io.*;
import java.util.*;


public class CF154B {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fileWriter = new FileWriter("output.txt");
        String[] parts = br.readLine().split("\\s+");

        int n = Integer.parseInt(parts[0]);

        parts = br.readLine().split("\\s+");

        Integer[] array = new Integer[n];

        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(parts[i]);
        }

        Arrays.sort(array);

        int max = -1;

        //StringBuffer sb = new StringBuffer();

        for(int i = 0; i < n; i++){
            int found = Arrays.binarySearch(array, i, n-1, array[i]*2);
            if(found > 0){
                int found1 = Arrays.binarySearch(array, i, n-1, array[i]*2 + 1);
                if(found1 > 0){
                    found = found1-1;
                } else {
                    int newidx = -(found1+1);
                    while(newidx < n && array[newidx] < array[i]*2 + 1){
                        newidx++;
                    }
                    found = newidx-1;
                }
                int curr = found-i+1;
                if(max < curr){
                    max = curr;
                }
            } else {
                int newidx = -(found+1);
                while(newidx < n && array[newidx] < array[i]*2 + 1){
                    newidx++;
                }
                int curr = newidx-1-i+1;
                if(max < curr){
                    max = curr;
                }
            }
        }
        int res = 0;
        if(max == -1){
            res = 0;
        } else {
            res = n - max;
        }
        fileWriter.write(""+res);
        fileWriter.close();
    }

}
