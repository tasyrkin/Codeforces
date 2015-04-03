import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CF222B {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[]semi1 = new int[n];
        int[]semi1sorted = new int[n];
        int[]semi2 = new int[n];
        int[]semi2sorted = new int[n];
        int[]common = new int[2*n];
        for(int i = 0; i < n; i++){
            String[] ps = br.readLine().split("\\s+");
            semi1sorted[i] = semi1[i] = Integer.parseInt(ps[0]);
            semi2sorted[i] = semi2[i] = Integer.parseInt(ps[1]);
            common[2*i] = semi1[i]; 
            common[2*i+1] = semi2[i]; 
        }
        Arrays.sort(common);
        Arrays.sort(semi1sorted);
        Arrays.sort(semi2sorted);
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        for(int i = 0; i < n; i++){
            
            char ch1 = '0';
            int idxs1 = Arrays.binarySearch(semi1sorted, semi1[i]);
            if(idxs1 < n/2){
                ch1 = '1';
            }

            char ch2 = '0';
            int idxs2 = Arrays.binarySearch(semi2sorted, semi2[i]);
            if(idxs2 < n/2){
                ch2 = '1';
            }

            int idx1 = Arrays.binarySearch(common, semi1[i]);
            if(idx1 < n){
                ch1 = '1';
            }
            int idx2 = Arrays.binarySearch(common, semi2[i]);
            if(idx2 < n){
                ch2 = '1';
            }
            
            s1.append(ch1);
            s2.append(ch2);
            
        }
        System.out.println(s1.toString());
        System.out.println(s2.toString());
    }

}
