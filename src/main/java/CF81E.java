import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF81E {

	private static class Person{
		String name;
		int initPos;
		int pos;
		int move;
		int thrw;
		Person takenPerson = null;
		boolean canMove = true;
		boolean canThrow = true;
		boolean canTake = true;
		boolean isTaken = false;
		
		public Person(String name, int initPos, int pos, int move, int thrw){
			this.name = name;
			this.initPos = initPos;
			this.pos = pos;
			this.move = move;
			this.thrw = thrw;			
		}		
		@Override
		public Person clone(){
			Person newPerson = new Person(name, initPos, pos, move, thrw);
			newPerson.canMove = this.canMove;
			newPerson.canThrow = this.canThrow;
			newPerson.canTake = this.canTake;
			newPerson.isTaken = this.isTaken;
			newPerson.takenPerson = takenPerson != null ? takenPerson.clone() : null;
			return newPerson;
		}
		
		public boolean canMove(){
			return canMove&&!isTaken;
		}		
		
		public boolean canTake(){
			return canTake;
		}
		public boolean canThrow(){
			return canThrow;
		}
		public boolean canAct(){
			return canMove() || canTake() || canThrow();
		}
		
		public boolean takePerson(Person person){
			if(this.canTake 
					&& Math.abs(this.pos-person.pos)==1
					&& !person.isTaken
					&& !this.isTaken){
				this.canTake = false;
				person.pos = this.pos;
				takenPerson = person;
				takenPerson.isTaken = true;
				return true;
			}
			return false;
		}		
		public boolean throwLeft(int steps,Person obstacle){
			return throwRight(-1*steps, obstacle);
		}
		public boolean throwRight(int steps, Person obstacle){
			if(this.canThrow
					&& !this.canTake
					&& !this.isTaken
					&& takenPerson!=null
					&& this.thrw>=Math.abs(steps)
					&& (obstacle!=null?
							(this.pos+steps!=obstacle.pos):true)){
					takenPerson.pos+=this.thrw;
					if(takenPerson.takenPerson!=null)takenPerson.takenPerson.pos = takenPerson.pos;
					this.canThrow = false;
					takenPerson.isTaken = false;
					takenPerson = null;
					return true;
				}
				return false;		
			
		}
		public boolean moveLeft(int steps, Person obstacle1, Person obstacle2){
			return moveRight(-1*steps, obstacle1, obstacle2);
		}
		public boolean moveRight(int steps, Person obstacle1, Person obstacle2){
			if(canMove()
					//&&this.move>=steps
					&&Math.abs(this.initPos-(this.pos+steps))<=this.move
					&&(obstacle1!=null?(this.pos+steps!=obstacle1.pos):true)
					&&(obstacle2!=null?(this.pos+steps!=obstacle2.pos):true)){
				this.pos+=steps;
				canMove = false;
				return true;
			}
			return false;
		}
		
		@Override
		public boolean equals(Object o){
			if(o != null && o instanceof Person){
				Person person = (Person)o;
				return name.equals(person.name);
			}
			return false;
		}
		
		@Override
		public int hashCode(){
			return name.hashCode();
		}
	}
	private static String LAHARL = "Laharl";
	private static String ETHNA = "Ethna";
	private static String FLONN = "Flonn";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[]parts = br.readLine().split("\\s+");
		int initPos = Integer.parseInt(parts[0]);
		int pos = Integer.parseInt(parts[0]);
		int move = Integer.parseInt(parts[1]);
		int thrw = Integer.parseInt(parts[2]);
		Person first = new Person(LAHARL, initPos, pos, move, thrw); 
		parts = br.readLine().split("\\s+");		
		initPos = Integer.parseInt(parts[0]);
		pos = Integer.parseInt(parts[0]);
		move = Integer.parseInt(parts[1]);
		thrw = Integer.parseInt(parts[2]);
		Person second = new Person(ETHNA, initPos, pos, move, thrw);		
		parts = br.readLine().split("\\s+");
		initPos = Integer.parseInt(parts[0]);
		pos = Integer.parseInt(parts[0]);
		move = Integer.parseInt(parts[1]);
		thrw = Integer.parseInt(parts[2]);
		Person third = new Person(FLONN, initPos, pos, move, thrw);
		start = System.currentTimeMillis();
		solve(first, second, third);
		System.out.println(maxPos);
	}
	private static int maxPos = Integer.MIN_VALUE;
	private static long start = Integer.MIN_VALUE;
	
	private static int solve(Person first, Person second, Person third) {
//		if(!(first.name.equals(LAHARL)&&second.name.equals(ETHNA)&&third.name.equals(FLONN))){
//			//System.out.println("false input");
//		}
		int currPos = Math.max(first.pos, Math.max(second.pos, third.pos));
		if(maxPos<currPos){
			maxPos = currPos;
			//System.out.println("maxPos:" + maxPos);
		}
		long finish = System.currentTimeMillis();
		if((finish-start) >= 10000)return 0;
		
		Person newFirst = null;
		Person newSecond = null;
		Person newThird = null;
		boolean opResult = false;
		for(int i = -1*first.move; i <= first.move && first.canMove(); i++){
			if(i==0)continue;
			newFirst = first.clone();
			opResult = newFirst.moveLeft(i, second, third);
			if(opResult){
				solve(newFirst, second, third);
			}
		}
//		for(int i = 1; i <= 10; i++){
//			newFirst = first.clone();
//			opResult = newFirst.moveRight(i, second, third);
//			if(opResult){
//				solve(newFirst, second, third);
//			}
//		}
		for(int i = -second.move; i <= second.move && second.canMove(); i++){
			if(i==0)continue;
			newSecond = second.clone();
			opResult = newSecond.moveLeft(i, first, third);
			if(opResult){
				solve(first, newSecond, third);
			}						
		}
//		for(int i = 1; i <= 10; i++){
//			newSecond = second.clone();
//			opResult = newSecond.moveRight(i, first, third);
//			if(opResult){
//				solve(first, newSecond, third);
//			}
//		}
		for(int i = -third.move; i <= third.move && third.canMove(); i++){
			if(i==0)continue;
			newThird = third.clone();
			opResult = newThird.moveLeft(i, first, second);
			if(opResult){
				solve(first, second, newThird);
			}			
		}
//		for(int i = 1; i <= 10; i++){
//			newThird = third.clone();
//			opResult = newThird.moveRight(i, first, second);
//			if(opResult){
//				solve(first, second, newThird);
//			}			
//		}
		newFirst = first.clone();
		newSecond = second.clone();
		opResult = newFirst.takePerson(newSecond);
		if(opResult){
			solve(newFirst, newSecond, third);
		}
		newFirst = first.clone();
		newThird = third.clone();
		opResult = newFirst.takePerson(newThird);
		if(opResult){
			solve(newFirst, second, newThird);
		}
		newSecond = second.clone();
		newFirst = first.clone();
		opResult = newSecond.takePerson(newFirst);
		if(opResult){
			solve(newFirst, newSecond, third);
		}
		newSecond = second.clone();
		newThird = third.clone();
		opResult = newSecond.takePerson(newThird);
		if(opResult){
			solve(first, newSecond, newThird);
		}
		newThird = third.clone();
		newFirst = first.clone();
		opResult = newThird.takePerson(newFirst);
		if(opResult){
			solve(newFirst, second, newThird);
		}
		newSecond = second.clone(); 
		newThird = third.clone();
		opResult = newThird.takePerson(newSecond);
		if(opResult){
			solve(first, newSecond, newThird);
		}		
		for(int i = -first.thrw; i <= first.thrw; i++){
			if(i==0)continue;
			newFirst = first.clone();
			newSecond = second;
			newThird = third;
			Person obstacle = null;
			if(newFirst.takenPerson!=null&&newFirst.takenPerson.equals(second)){
				newSecond = newFirst.takenPerson;
				if(newSecond.takenPerson!=null){
					newThird = newSecond.takenPerson;
				}
				else{
					obstacle = third;
				}
			}
			else if(newFirst.takenPerson!=null&&newFirst.takenPerson.equals(third)){
				newThird = newFirst.takenPerson;
				if(newThird.takenPerson!=null){
					newSecond = newThird.takenPerson;
				}
				else{
					obstacle = second;
				}
			}
			opResult = newFirst.throwLeft(i, obstacle);
			if(opResult){
				solve(newFirst, newSecond, newThird);
			}
		}
		for(int i = -second.thrw; i <= second.thrw; i++){
			if(i==0)continue;
			newSecond = second.clone();
			newFirst = first;
			newThird = third;
			Person obstacle = null;
			if(newSecond.takenPerson!=null&&newSecond.takenPerson.equals(first)){
				newFirst = newSecond.takenPerson;
				if(newFirst.takenPerson!=null){
					newThird = newFirst.takenPerson;
				}
				else{
					obstacle = third;
				}
			}
			else if(newSecond.takenPerson!=null&&newSecond.takenPerson.equals(third)){
				newThird = newSecond.takenPerson;
				if(newThird.takenPerson!=null){
					newFirst = newThird.takenPerson;
				}
				else{
					obstacle = first;
				}
			}
			opResult = newSecond.throwLeft(i, obstacle);
			if(opResult){
				solve(newFirst, newSecond, newThird);
			}
		}
		for(int i = -third.thrw; i <= third.thrw; i++){
			if(i==0)continue;
			newThird = third.clone();
			newFirst = first;
			newSecond = second;
			Person obstacle = null;
			if(newThird.takenPerson!=null&&newThird.takenPerson.equals(first)){
				newFirst = newThird.takenPerson;
				if(newFirst.takenPerson!=null){
					newSecond = newFirst.takenPerson;
				}
				else{
					obstacle = second;
				}
			}
			else if(newThird.takenPerson!=null&&newThird.takenPerson.equals(second)){
				newSecond = newThird.takenPerson;
				if(newSecond.takenPerson!=null){
					newFirst = newSecond.takenPerson;
				}
				else{
					obstacle = first;
				}
			}
			opResult = newThird.throwLeft(i, obstacle);
			if(opResult){
				solve(newFirst, newSecond, newThird);
			}
		}
		
		
		return 0;
	}

}
