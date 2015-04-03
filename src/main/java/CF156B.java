import java.io.*;


public class CF156B {

    /**
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();

        int nx = 0;
        int ny = 0;
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == 'x')nx++;
            if(chars[i] == 'y')ny++;
        }
        if(nx > ny){
            for(int i = 0; i < (nx-ny); i++){
                System.out.print("x");
            }
        } else{
            for(int i = 0; i < (ny-nx); i++){
                System.out.print("y");
            }
        }
        System.out.println();
    }

}
