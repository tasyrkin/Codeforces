import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF225B {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ps = br.readLine().split("\\s+");
        int n = Integer.parseInt(ps[0]);
        int m = Integer.parseInt(ps[1]);
        int k = Integer.parseInt(ps[2]);
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            ps = br.readLine().split("\\s+");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(ps[j]);
            }
        }

        StringBuffer res = new StringBuffer();
        int cnt = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                boolean taken = false;
                for (int v = 0; v < n; v++) {
                    if (k == 0 && !taken) {
                        if (arr[v][j] < arr[v][i]) {
                            taken = true;
                            res.append((i + 1) + " " + (j + 1) + "\n");
                            cnt++;
                        }
                    } else if (k == 1 && !taken) {
                        if (arr[v][j] > arr[v][i]) {
                            taken = true;
                            res.append((j + 1) + " " + (i + 1) + "\n");
                            cnt++;
                        }
                    }

                    if ((k == 0 && arr[v][j] < arr[v][i]) || (k == 1 && arr[v][j] > arr[v][i])) {
                        int tmp = arr[v][j];
                        arr[v][j] = arr[v][i];
                        arr[v][i] = tmp;
                    }
                }
            }
        }

        System.out.println(cnt);
        System.out.print(res.toString());
    }
}
