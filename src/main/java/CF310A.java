
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class CF310A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[]arr = sc.next().toCharArray();
        LinkedList<Integer> ll = new LinkedList<>();
        for(int i = 0; i < arr.length; i++){
            ll.add(Integer.parseInt(""+arr[i]));
        }
        ListIterator<Integer> iter = ll.listIterator();

        int removed = 0;

        while(iter.hasNext()){
            int val = iter.next();
            if(val == 0){
                if(iter.hasNext()){
                    int next = iter.next();
                    if(next == 1){
                        iter.remove();
                        iter.previous();
                        iter.remove();
                        removed+=2;
                        if(iter.hasPrevious())iter.previous();
                    } else {
                        iter.previous();
                    }
                }
            } else {
                if(iter.hasNext()){
                    int next = iter.next();
                    if(next == 0){
                        iter.remove();
                        iter.previous();
                        iter.remove();
                        removed+=2;
                        if(iter.hasPrevious())iter.previous();
                    } else {
                        iter.previous();
                    }
                }
            }
        }
        System.out.println(n-removed);
    }
}
