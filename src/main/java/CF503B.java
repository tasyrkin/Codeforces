import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF503B {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        int[] visitedStudents = new int[n];
        for (int student = 0; student < n; student++) {
            visitedStudents[student] = sc.nextInt();
        }
        final StringBuilder sb = new StringBuilder();
        for (int student = 1; student <= n; student++) {
            Set<Integer> studentsWithAHole = new HashSet<>();
            studentsWithAHole.add(student);

            for (final int visitedStudent : visitedStudents) {
                if (studentsWithAHole.contains(visitedStudent)) {
                    if (sb.length() > 0) {
                        sb.append(" ");
                    }
                    sb.append(visitedStudent);
                    break;
                }
                studentsWithAHole.add(visitedStudent);
            }
        }

        System.out.println(sb.toString());

    }
}
