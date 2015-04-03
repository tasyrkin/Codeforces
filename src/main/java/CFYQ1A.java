import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class CFYQ1A {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] line = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<Character>();
		stack.push(line[0]);
		int i = 1;
		while(i<line.length){
			while(!stack.isEmpty()&&stack.peek()==line[i]){
				stack.pop();		
				i++;
				if(i>=line.length)break;
			}
			if(i>=line.length)break;
			stack.push(line[i++]);			
		}
		for(char ch : stack){
			System.out.print(ch);
		}
		System.out.println();
	}

	private static void method4() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Character> list = new ArrayList<Character>();
		char[]line = br.readLine().toCharArray();
		for(char ch : line){
			list.add(ch);
		}
		for(int i = 0; i < list.size()-1; i++){
			char dup = list.get(i);
			if(i+1>=list.size())break;
			if(list.get(i+1)==dup){
				list.remove(i+1);
				list.remove(i);
				i-=2;
			}
			if(i<0)i=-1;
		}
		for(char ch : list){
			System.out.print(ch);
		}
		System.out.println();
	}

	private static void method3() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[]line = br.readLine().toCharArray();
		int start = 0;
		int end = 0;
		while(start>=0&&start<line.length&&end>=0&&end<line.length){
			while(line[start]=='!'){
				if(++start>=line.length)break;
			}
			if(start>=line.length)break;
//			start = end;
			end = start+1;
			if(end>=line.length)break;			
			while(line[end]=='!'){
				if(++end>=line.length)break;
			}
			if(end>=line.length)break;
			boolean isDup = false;
			while(line[start]==line[end]){
				isDup = true;
				line[start] = '!';
				line[end] = '!';
				start--;
				end++;
				if((start<0||start>=line.length)||(end<0||end>=line.length))break;
			}
			if(!isDup)
			{
				start = end;
			}
			else{
				if(start<0)start = 0;
			}
			while(line[start]=='!'){
				if(--start<0)break;				
			}
			if(start<0)start=0;
		}
		
		for(int i = 0; i < line.length; i++){
			if(line[i]!='!')System.out.print(line[i]);
		}
		System.out.println();
	}

	private static void method2(BufferedReader br) throws IOException {
		ArrayList<Character> list = new ArrayList<Character>();
		char[]line = br.readLine().toCharArray();
		for(char ch : line){
			list.add(ch);
		}
		boolean dups = true;
		while(dups){
			dups = false;			
			for(int i = 0; i < list.size()-1; i++){
				char dup = list.get(i);
				int j = i+1;
				boolean isDup = false;
				while(list.get(j)==dup){
					isDup = true;
					dups = true;
					list.remove(j);
					if(j>=list.size())break;
				}
				if(isDup){
					list.remove(i);
					break;
				}
			}
		}
		for(char ch : list){
			System.out.print(ch);
		}
		System.out.println();
	}

	private static void method1(char[] line) {
		boolean dups = true;
		while(dups){
			dups = false;
			for(int i = 0; i < line.length-1; i++){
				char dup = line[i];
				if(dup=='!')continue;
				int j = i+1;
				boolean isDup = false;
				while(line[j]=='!'||line[j]==dup){
					if(line[j]==dup){
						dups = true;
						isDup = true;
					}
					line[j++] = '!';
					if(j>=line.length)break;
				}
				if(isDup)line[i] = '!';
			}
		}
		for(int i = 0; i < line.length; i++){
			if(line[i]!='!')System.out.print(line[i]);
		}
		System.out.println();
	}

}
