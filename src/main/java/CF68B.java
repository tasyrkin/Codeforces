import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF68B {

	static final String TO_HEAD = "to head".trim();
	static final String TO_TAIL = "to tail".trim();
	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().split("\\s+");
		int n = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);
		int k = Integer.parseInt(parts[2]);
		String direction = br.readLine().trim();
		String states = br.readLine().trim();
		boolean isCaught = false;
		int move = 0;
		for(move = 0; move < states.length(); move++){
			//System.out.println("n:" + n + ",m:" + m + ",k:" + k + ",state:" + states.charAt(move) + ",direction:" + direction);
			if(m==k){
				isCaught = true;
				break;
			}
			if(states.charAt(move)=='1'){
				if(direction.equals(TO_HEAD)){
					if(--k<=0){
						k+=2;
						direction = TO_TAIL;
					}				
				}
				else{
					if(++k>n){
						k-=2;
						direction = TO_HEAD;
					}
				}				
				if(direction.equals(TO_HEAD)&&k!=n)m=n;
				else if(direction.equals(TO_HEAD))m=1;
				if(direction.equals(TO_TAIL)&&k!=1)m=1;
				else if(direction.equals(TO_TAIL))m=n;
			}
			else{
				if(direction.equals(TO_HEAD)&&m<k)m=1;
				else if(direction.equals(TO_HEAD)&&m>k)m=n;
				else if(direction.equals(TO_TAIL)&&m<k)m=1;
				else if(direction.equals(TO_TAIL)&&m>k)m=n;
				if(direction.equals(TO_HEAD)){
					if(--k<=0){
						k+=2;
						direction = TO_TAIL;
					}				
				}
				else{
					if(++k>n){
						k-=2;
						direction = TO_HEAD;
					}
				}
			}			
		}
		if(isCaught){
			System.out.println("Controller " + (move));
		}
		else{
			System.out.println("Stowaway");
		}
	}

	private static int getDistance(int n, int m, int k, String direction) {
		int distance = 0;
		if(m < k && direction.equals(TO_HEAD)){
			distance = k-1;
		}
		else if(m > k && direction.equals(TO_TAIL)){	
			distance = n-k;
		}
		else if(m < k && direction.equals(TO_TAIL)){
			distance = n-k+n-1;
		}
		else if(m > k && direction.equals(TO_HEAD)){
			distance = n-1+k-1;
		}
		return distance;
	}
}
