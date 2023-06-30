package weakestrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Solution {
//    public int[] kWeakestRows(int[][] mat, int k) {
//        ArrayList<int[]> counts = new ArrayList<>(mat.length);
//        for (int i = 0; i < mat.length; i++) {
//            counts.add(new int[]{i, getRowPower(mat[i])});
//        }
//        List<Integer> list = counts.stream().sorted(this::compareRows).limit(k).map(r -> r[0]).toList();
//        int[] res = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            res[i] = list.get(i);
//        }
//        return res;
//    }
//
//    private int compareRows(int[] a, int[] b) {
//        if (a[1] == b[1]) {
//            return Integer.compare(a[0], b[0]);
//        }
//        return Integer.compare(a[1], b[1]);
//    }

    public int[] kWeakestRows(int[][] mat, int k) {
        ArrayList<Pair<Integer, int[]>> rows = new ArrayList<>(mat.length);
        for (int i = 0; i < mat.length; i++) {
            rows.add(i, new Pair<>(i, mat[i]));
        }
        List<Integer> list = rows.stream().sorted(this::compareRows).limit(k).map(r -> r.first).toList();
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int compareRows(Pair<Integer, int[]> a, Pair<Integer, int[]> b) {
        int powerA = getRowPower(a.second);
        int powerB = getRowPower(b.second);
        if (powerA == powerB) {
            return Integer.compare(a.first, b.first);
        }
        return Integer.compare(powerA, powerB);
    }

    private int getRowPower(int[] row) {
        if (row[0] == 0) {
            return 0;
        }
        int right = row.length - 1;
        int left = 0;
        int maxOneIdx = 0;
        int prevCurrent = 0;
        while (left < right) {
            int current = left + (right - left) / 2;
            if (current == prevCurrent) {
                current++;
            }
            System.out.println(current);
            prevCurrent = current;
            if (row[current] == 0) {
                right = current - 1;
            } else {
                if (current > maxOneIdx) {
                    maxOneIdx = current;
                }
                left = current;
            }
        }
        return maxOneIdx + 1;
    }

    private record Pair<T, K>(T first, K second) {}

    public static void main(String[] args) {
        int[] ints = {1, 0};
        System.out.println(new Solution().getRowPower(ints));
//        int[][] mat = {{1, 0}, {0, 0}, {1, 0}};
//        System.out.println(Arrays.toString(new Solution().kWeakestRows(mat, 2)));
    }
}
