import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class CF156A {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");

        int n = Integer.parseInt(parts[0]);

        parts = br.readLine().split("\\s+");

        int[] res = new int[3];

        for(int i = 0; i < n; i++){
            res[i%3] += Integer.parseInt(parts[i]);
        }

        if(res[0] > res[1]){
            if(res[0] > res[2]){
                System.out.println("chest");
            } else {
                System.out.println("back");
            }
        } else {
            if(res[1] > res[2]){
                System.out.println("biceps");
            } else {
                System.out.println("back");
            }
        }

    }

}
