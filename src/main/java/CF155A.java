import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class CF155A {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        FileWriter fileWriter = new FileWriter("output.txt");
        String[] parts = br.readLine().split("\\s+");

        int n = Integer.parseInt(parts[0]);

        Map<String, List<Integer>> m = new HashMap<String, List<Integer>>();

        parts = br.readLine().split("\\s+");

        for(int i = 0; i < parts.length; i++){
            List<Integer> l = m.get(parts[i]);
            if(l == null){
                l = new ArrayList<Integer>();
            }
            l.add(i);
            m.put(parts[i], l);
        }

        String[] s = new String[n];

        int cnt = 0;
        for(Map.Entry<String, List<Integer>> e : m.entrySet()){
            if(e.getValue().size() % 2 == 1){
                fileWriter.write("-1\n");
                fileWriter.close();
                return;
            }
            Integer[]arr = e.getValue().toArray(new Integer[0]);
            for(int i = 0; i < arr.length; i+=2){
                s[cnt++] = (arr[i]+1) + " " + (arr[i+1]+1) + "\n";
            }
        }

        for(String str : s){
            fileWriter.write(str);
        }
        fileWriter.close();

    }

}
