import java.io.*;


public class CF160A {

    /**
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");

        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);
        parts = br.readLine().split("\\s+");

        int cnt = 0;
        for(int i = 0; i < n; i++){
            char[] c = parts[i].toCharArray();
            int currCnt = 0;
            for(int j = 0; j < c.length; j++){
                if(c[j] == '7' || c[j] == '4'){
                    currCnt++;
                }
            }
            if(currCnt <= k){
                cnt++;
            }
        }
        System.out.println(cnt);

    }

}
