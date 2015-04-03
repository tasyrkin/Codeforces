
public class GeneratorVKCup2012R3C {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 100000;
		System.out.println(n);
		int val = 0;
		boolean isFirst = true;
		for(int i = 0; i < n; i++){
			System.out.print((isFirst?"":" ") + val++);
			isFirst = false;
		}
		System.out.println();
	}

}
