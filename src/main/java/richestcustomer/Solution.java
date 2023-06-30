package richestcustomer;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maximumWealth(int[][] accounts) {
//        int max = 0;
//        for (int[] account : accounts) {
//            int sum = 0;
//            for (int i : account) {
//                sum += i;
//            }
//            if (sum > max) {
//                max = sum;
//            }
//        }
//        return max;
        return Arrays.stream(accounts).map(a -> Arrays.stream(a).sum()).max(Integer::compare).get();
    }
}
