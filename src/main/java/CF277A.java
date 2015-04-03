import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class CF277A {
    public static void main(final String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream(new File("test.in")));
        long n = sc.nextLong();

        if (n % 2 == 0) {
            System.out.println(n / 2);
        } else {
            System.out.println((n - 1) / 2 - n);
        }
    }
}
