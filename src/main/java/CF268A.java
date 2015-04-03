import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashSet;
import java.util.Set;

public class CF268A {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] parts = br.readLine().split("\\s+");
        Set<String> s = new HashSet<String>();
        for (int i = 1; i < parts.length; i++) {
            s.add(parts[i]);
        }

        parts = br.readLine().split("\\s+");
        for (int i = 1; i < parts.length; i++) {
            s.add(parts[i]);
        }

        System.out.println(s.size() == n ? "I become the guy." : "Oh, my keyboard!");
    }
}
