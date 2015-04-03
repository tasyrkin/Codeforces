import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CF173BW {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set[]G = new HashSet[1001];
        Set[]S = new HashSet[1001];
        char[]chars = new char[n];
        int[][] arr = new int[n][2];

        String[]pairs = null;
        for(int i = 0; i < n; i++){
            pairs = br.readLine().split("\\s+");
            int gs = Integer.parseInt(pairs[0]);
            int ss = Integer.parseInt(pairs[1]);
            arr[i][0] = gs;
            arr[i][1] = ss;
            if(G[gs] == null){
                G[gs] = new HashSet();
            }
            G[gs].add(i);
            if(S[ss] == null){
                S[ss] = new HashSet();
            }
            S[ss].add(i);
        }
        int gs = 1000;
        long sumG = 0;
        int ss = 1000;
        long sumS = 0;
        int cnt = n;
        int sumtG = 0;
        int sumtS = 0;
        int gsIdxt = -1;
        int ssIdxt = -1;
        while(cnt > 0){
            while(gs>=0 && (G[gs] == null || G[gs].size() == 0)){
                --gs;
            }
            if(gs >= 0){
                int gsIdx = -1;
                for(Object i : G[gs]){
                   gsIdx = (Integer)i;
                   break;
                }
                if(cnt > 1){
                    sumG += arr[gsIdx][0];
                    chars[gsIdx] = 'A';
                    G[gs].remove(gsIdx);
                    S[arr[gsIdx][1]].remove(gsIdx);
                    --cnt;
                } else {
                    gsIdxt = gsIdx;
                    sumtG = arr[gsIdx][0];
                }
            }
            while(ss>=0 && (S[ss] == null || S[ss].size() == 0)){
                --ss;
            }
            if(ss>=0){
                int ssIdx = -1;
                for(Object i : S[ss]){
                    ssIdx = (Integer)i;
                    break;
                }
                if(cnt > 1){
                    sumS += arr[ssIdx][1];
                    S[ss].remove(ssIdx);
                    G[arr[ssIdx][0]].remove(ssIdx);
                    chars[ssIdx] = 'G';
                    --cnt;
                } else {
                    ssIdxt = ssIdx;
                    sumtS = arr[ssIdx][1];
                }
            }
            if(cnt == 1 && ssIdxt != -1){
                if(sumG > sumS){
                    sumS += sumtS;
                    chars[ssIdxt] = 'G';
                } else if (sumS > sumG) {
                    sumG += sumtG;
                    chars[gsIdxt] = 'A';
                } else {
                    if(sumtS < sumtG){
                        sumS += sumtS;
                        chars[ssIdxt] = 'G';
                    } else {
                        sumG += sumtG;
                        chars[gsIdxt] = 'A';
                    }
                }
                --cnt;
            }
        }
        if(Math.abs(sumG - sumS) <= 500){
            System.out.println(new String(chars));
        } else {
            System.out.println(-1);
        }
    }

}
