import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        ListIterator<Integer> iter = l.listIterator();
        iter.remove();
        System.out.println("Some");
    }

}
