import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CF80VDIV1C {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[]parts = br.readLine().split("\\s+");
		int n = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);
		int h = Integer.parseInt(parts[2]);
		int[] play = new int[m+1];
		parts = br.readLine().split("\\s+");
		for(int i = 0; i < parts.length; i++){
			play[i+1] = Integer.parseInt(parts[i]);
		}
	}
}
