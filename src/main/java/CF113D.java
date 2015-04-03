import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


/**
 * not solved
 * @author tim
 *
 */
public class CF113D {
	
	public static class Client {
		int d;
		int l;
		public Client(int d, int l){
			this.d = d;
			this.l = l;
		}		
	}
	
	public static class Goods implements Comparable<Goods>{
		int c;
		Integer s;
		List<Integer> candidates = null;
		public Goods(int c, int s){
			this.c = c;
			this.s = s;
			candidates = new ArrayList<Integer>();
		}
		public void addCandidate(int num){
			candidates.add(num);
		}
		@Override
		public int compareTo(Goods o) {			
			return s.compareTo(o.s);
		}
		@Override
		public boolean equals(Object o){
			if(o != null && o instanceof Goods){
				Goods oth = (Goods)o;
				return s.equals(oth.s);
			}
			return false;
		}
	}
	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Goods[] goods = new Goods[n];
		String[]pairs = null;
		for(int i = 0; i < n; i++){
			pairs = br.readLine().split("\\s+");
			int c = Integer.parseInt(pairs[0]);
			int s = Integer.parseInt(pairs[1]);
			goods[i] = new Goods(c, s);
		}
		Arrays.sort(goods);
		int m = Integer.parseInt(br.readLine());
		Client[]clients = new Client[m];
		for(int i = 0; i < m; i++){
			pairs = br.readLine().split("\\s+");
			int d = Integer.parseInt(pairs[0]);
			int l = Integer.parseInt(pairs[1]);
			clients[i] = new Client(d, l);
			int idx = Arrays.binarySearch(goods, new Goods(-1,l));
			if(idx<0){
				idx++;
				idx*=-1;
				if(idx>=0&&idx<goods.length){
					if(goods[idx].s == l || goods[idx].s-1 == l){
						if(goods[idx].c<=d){
							goods[idx].addCandidate(i);
						}
					}
				}
				if(idx+1>=0&&idx+1<goods.length){
					if(goods[idx+1].s == l || goods[idx+1].s-1 == l){
						if(goods[idx+1].c<=d){
							goods[idx+1].addCandidate(i);
						}
					}					
				}
			} else {
				if(idx>=0&&idx<goods.length){
					if(goods[idx].s == l || goods[idx].s-1 == l){
						if(goods[idx].c<=d){
							goods[idx].addCandidate(i);
						}
					}
				}
				if(idx+1>=0&&idx+1<goods.length){
					if(goods[idx+1].s == l || goods[idx+1].s-1 == l){
						if(goods[idx+1].c<=d){
							goods[idx+1].addCandidate(i);
						}
					}					
				}
			}
		}
		long revenue = 0;
		int pair = 0;
		for(int i = 0; i < n; i++){			
			if(i==n-1){
				if(goods[i].candidates.size()>0){
					revenue += goods[i].c;
					pair++;
					while(goods[i].candidates.size()!=1){
						goods[i].candidates.remove(0);
					}
				}
			} else {
				int remainingCand = -1;
				for(Integer cand : goods[i].candidates){
					if(!goods[i+1].candidates.contains(cand)){
						revenue += goods[i].c;
						pair++;
						remainingCand = cand;						
						break;
					} else {
						if(goods[i+1].candidates.size()==1){						
							if(goods[i].candidates.size()==1&&goods[i+1].candidates.size()==1){
								if(goods[i].c > goods[i+1].c){
									goods[i+1].candidates.remove(new Integer(cand));
									remainingCand = cand;
									revenue += goods[i].c;
									pair++;
									break;
								} else {
									remainingCand = -2;
								}
							}
						} else {
							if(goods[i].candidates.size()==1){
								if(goods[i].c > goods[i+1].c){
									goods[i+1].candidates.remove(new Integer(cand));
									remainingCand = cand;
									revenue += goods[i].c;
									pair++;
									break;
								} else {
									remainingCand = -2;
								}								
							} else {
								remainingCand = i;
								break;
							}
						}
					} 
				}
				if(remainingCand != -1){
					Iterator<Integer> iter = goods[i].candidates.iterator();
					while(iter.hasNext()){
						if(iter.next() != remainingCand){
							iter.remove();
						}
					}
				} else if(remainingCand == -2){
					goods[i].candidates.clear();
				}
			}
		}
		System.out.println(revenue);
		System.out.println(pair);
		for(int i = 0; i < n; i++){
			if(goods[i].candidates.size()>0){
				System.out.println((goods[i].candidates.get(0)+1) + " " + (i+1));
			}
		}
	}

}
