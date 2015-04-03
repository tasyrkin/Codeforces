import java.io.*;


public class CF156E {

    /**
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        FileWriter fileWriter = new FileWriter(new File("output.txt"));
        String[] parts = br.readLine().split("\\s+");

        int b = Integer.parseInt(parts[0]);
        int g = Integer.parseInt(parts[1]);

        String first = "G";
        String second = "B";
        if(b > g){
            first = "B";
            second = "G";
        }

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < Math.min(b, g); i++){
            sb.append(first + second);
        }
        for(int i = Math.min(b, g); i < Math.max(b, g); i++){
            sb.append(first);
        }

        //System.out.println(sb.toString());
        fileWriter.write(sb.toString());
        fileWriter.close();
    }

}
