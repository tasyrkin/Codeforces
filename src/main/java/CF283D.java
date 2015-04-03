import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CF283D {

    private static class Node {
        public static final Node ZERO = new Node(0, 0);

        int ones = 0;
        int twos = 0;

        public Node(final int ones, final int twos) {
            this.ones = ones;
            this.twos = twos;
        }

        public Node sum(final Node n) {
            return new Node(ones + n.ones, twos + n.twos);
        }

    }

    private static class Result implements Comparable<Result> {
        Integer s;
        Integer t;

        public Result(final Integer s, final Integer t) {
            this.s = s;
            this.t = t;
        }

        @Override
        public int compareTo(final Result o) {

            if (s.compareTo(o.s) == 0) {
                return t.compareTo(o.t);
            }

            return s.compareTo(o.s);
        }
    }

    public static void main(final String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] s = new int[n];
        int ones = 0;
        int twos = 0;
        for (int i = 0; i < s.length; i++) {
            s[i] = sc.nextInt();
            if (s[i] == 1) {
                ones++;
            } else {
                twos++;
            }
        }

        List<Result> result = new LinkedList<Result>();

        if (ones != twos) {
            if (ones > twos && s[n - 1] == 1) {
                result.add(new Result(ones, 1));
            }

            if (twos > ones && s[n - 1] == 2) {
                result.add(new Result(twos, 1));
            }

        }

        Node[] segTree = new Node[4 * n];

        build(segTree, s, 1, 0, n - 1);

        for (int t = 2; t <= n; t++) {
            int curr = 0;
            ones = 0;
            twos = 0;

            while (curr < n) {
                int start = curr + t - 1;
                int end = start + t - 1;

                boolean found = false;
                int mid = (start + end) / 2;
                while (start <= end) {
                    mid = (start + end) / 2;
                    if (mid < n) {
                        Node status = sum(segTree, 1, 0, n - 1, curr, mid);

                        if (status.ones == t) {
                            if (status.twos < t && s[mid] == 1) {
                                found = true;
                                ones++;
                            }

                            break;
                        } else if (status.twos == t) {
                            if (status.ones < t && s[mid] == 2) {
                                found = true;
                                twos++;
                            }

                            break;
                        } else if (status.ones > t || status.twos > t) {
                            end = mid - 1;
                        } else {
                            start = mid + 1;
                        }
                    } else {
                        end = mid - 1;
                    }
                }

                if (!found) {
                    break;
                }

                curr = mid + 1;

            }

            if (curr == n && ones != twos) {
                result.add(new Result(Math.max(ones, twos), t));
            }
        }

        Result[] res = result.toArray(new Result[0]);
        Arrays.sort(res);

        StringBuilder sb = new StringBuilder();
        for (Result r : res) {
            if (sb.length() > 0) {
                sb.append("\n");
            }

            sb.append(r.s + " " + r.t);
        }

        System.out.println(res.length);
        if (res.length > 0) {
            System.out.println(sb.toString());
        }

    }

    static void build(final Node[] tree, final int[] a, final int v, final int tl, final int tr) {
        if (tl == tr) {
            tree[v] = (a[tl] == 1 ? new Node(1, 0) : new Node(0, 1));
        } else {
            int tm = (tl + tr) / 2;
            build(tree, a, v * 2, tl, tm);
            build(tree, a, v * 2 + 1, tm + 1, tr);
            tree[v] = tree[v * 2].sum(tree[v * 2 + 1]);
        }
    }

    static Node sum(final Node[] tree, final int v, final int tl, final int tr, final int l, final int r) {
        if (l > r) {
            return Node.ZERO;
        }

        if (l == tl && r == tr) {
            return tree[v];
        }

        int tm = (tl + tr) / 2;
        return sum(tree, v * 2, tl, tm, l, Math.min(r, tm)).sum(sum(tree, v * 2 + 1, tm + 1, tr, Math.max(l, tm + 1),
                    r));

    }
}
