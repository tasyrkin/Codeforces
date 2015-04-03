import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: tim
 * Date: 3/10/13
 * Time: 4:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class CF172A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if(str.length() > 0){
            System.out.print(str.substring(0,1).toUpperCase());
            System.out.println(str.substring(1));
        } else {
            System.out.println(str);
        }
    }

}
