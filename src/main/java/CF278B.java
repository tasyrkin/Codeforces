import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF278B {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println("YES");
            System.out.println("1\n1\n3\n3");
        } else {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            for (int x1 = 1; x1 <= 500; x1++) {
                int x4 = 3 * x1;
                for (int x2 = x1; x2 <= x4; x2++) {
                    for (int x3 = x2; x3 <= x4; x3++) {
                        if (check(x1, x2, x3, x4)) {
                            Set<Integer> s = new HashSet<Integer>();
                            Set<Integer> s1 = new HashSet<Integer>();
                            int[] newArr = new int[] {x1, x2, x3, x4};
                            for (int i = 0; i < newArr.length; i++) {
                                for (int j = 0; j < arr.length; j++) {
                                    if (newArr[i] == arr[j] && !s.contains(j)) {
                                        s.add(j);
                                        s1.add(i);
                                        break;
                                    }
                                }
                            }

                            if (s.size() == n) {
                                System.out.println("YES");
                                for (int i = 0; i < newArr.length; i++) {
                                    if (!s1.contains(i)) {
                                        System.out.println(newArr[i]);
                                    }
                                }

                                return;
                            }
                        }
                    }
                }
            }

            System.out.println("NO");

        }
    }

    private static boolean check(final int x1, final int x2, final int x3, final int x4) {
        return x4 == 3 * x1 && (4 * x1 == x2 + x3) && (x2 + x3 == 2 * (x4 - x1)) && x1 > 0 && x2 > 0 && x3 > 0
                && x4 > 0;
    }
}
