import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;

public class CF243C {

    private static class Seg {
        int sum;
        int[] arr;

        public Seg(final int[] arr) {
            this.arr = arr;
            for (int i : arr) {
                sum += i;
            }

            Arrays.sort(this.arr);
        }

        public Seg(final int val) {
            arr = new int[1];
            arr[0] = val;
            sum += val;
        }

        static Seg merge(final Seg s1, final Seg s2) {
            if (s1 == null && s2 == null) {
                return null;
            } else if (s1 == null) {
                int[] a = new int[s2.arr.length];
                for (int i = 0; i < s2.arr.length; i++) {
                    a[i] = s2.arr[i];
                }

                return new Seg(a);
            } else if (s2 == null) {
                int[] a = new int[s1.arr.length];
                for (int i = 0; i < s1.arr.length; i++) {
                    a[i] = s1.arr[i];
                }

                return new Seg(a);
            } else {
                int[] arr = new int[s1.arr.length + s2.arr.length];
                int i = 0;
                for (int v : s1.arr) {
                    arr[i++] = v;
                }

                for (int v : s2.arr) {
                    arr[i++] = v;
                }

                return new Seg(arr);
            }
        }

    }

    static void build(final int[] a, final int v, final int tl, final int tr, final Seg[] seg) {
        if (tl == tr) {
            seg[v] = new Seg(a[tl]);
        } else {
            int tm = (tl + tr) / 2;
            build(a, v * 2, tl, tm, seg);
            build(a, v * 2 + 1, tm + 1, tr, seg);

            Seg l = seg[v * 2];
            Seg r = seg[v * 2 + 1];
            seg[v] = Seg.merge(l, r);
        }
    }

    static Seg query(final int v, final int tl, final int tr, final int l, final int r, final Seg[] seg) {
        if (l > r) {
            return null;
        }

        if (l == tl && r == tr) {
            return seg[v];
        }

        int tm = (tl + tr) / 2;
        Seg left = query(v * 2, tl, tm, l, Math.min(r, tm), seg);
        Seg right = query(v * 2 + 1, tm + 1, tr, Math.max(l, tm + 1), r, seg);

        if (left == null && right == null) {
            return null;
        } else if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return Seg.merge(left, right);
        }

    }

    /*
     * static void update(final int v, final int tl, final int tr, final int pos, final int new_val, final Seg[] seg) {
     *  if (tl == tr) {
     *      seg[v] = new Seg(new_val, new_val, new_val);
     *  } else {
     *      int tm = (tl + tr) / 2;
     *      if (pos <= tm) {
     *          update(v * 2, tl, tm, pos, new_val, seg);
     *      } else {
     *          update(v * 2 + 1, tm + 1, tr, pos, new_val, seg);
     *      }
     *
     *      Seg l = seg[v * 2];
     *      Seg r = seg[v * 2 + 1];
     *      seg[v] = new Seg(l.sum + r.sum, Math.min(l.min, r.min), Math.max(l.max, r.max));
     *  }
     * }
     */

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("\\s+");
        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);
        int[] a = new int[n];
        Seg[] seg = new Seg[4 * n];
        parts = br.readLine().split("\\s+");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(parts[i]);
        }

        build(a, 1, 0, n - 1, seg);

        int maxSum = Integer.MIN_VALUE;
        for (int l = 1; l <= a.length; l++) {
            for (int s = 0; s + l <= a.length; s++) {
                Seg curr = query(1, 0, n - 1, s, s + l - 1, seg);
                Seg left = query(1, 0, n - 1, 0, s - 1, seg);
                Seg right = query(1, 0, n - 1, s + l, n - 1, seg);
                int[] la = left != null ? left.arr : new int[] {};
                int[] ra = right != null ? right.arr : new int[] {};

                int sum = curr.sum;
                int idxl = la.length - 1;
                int idxr = ra.length - 1;
                for (int i = 0; i < k && i < curr.arr.length; i++) {
                    int currMax = Integer.MIN_VALUE;
                    if (idxl < 0 && idxr < 0) {
                        break;
                    } else if (idxl < 0) {
                        currMax = ra[idxr--];
                    } else if (idxr < 0) {
                        currMax = la[idxl--];
                    } else {
                        if (ra[idxr] > la[idxl]) {
                            currMax = ra[idxr--];
                        } else {
                            currMax = la[idxl--];
                        }
                    }

                    if (curr.arr[i] < currMax) {
                        sum += currMax - curr.arr[i];
                    }
                }

                if (maxSum < sum) {
                    maxSum = sum;
                }

            }
        }

        System.out.println(maxSum);

    }
}
