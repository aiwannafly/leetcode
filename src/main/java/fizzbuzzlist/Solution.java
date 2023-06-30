package fizzbuzzlist;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> res = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            res.add(i, convertIdxToString(i + 1));
        }
        return res;
    }

    private String convertIdxToString(int i) {
        if (i % 15 == 0) {
            return "FizzBuzz";
        }
        if (i % 5 == 0) {
            return "Buzz";
        }
        if (i % 3 == 0) {
            return "Fizz";
        }
        return Integer.toString(i);
    }
}
