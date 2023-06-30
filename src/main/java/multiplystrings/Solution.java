package multiplystrings;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Solution {
    public String multiply(String num1, String num2) {
        int maxLen = Math.max(num1.length(), num2.length());
        BiFunction<Integer, String, Integer> l = (i, s) -> i < s.length() ? Integer.parseInt(String.valueOf(s.charAt(s.length() - i - 1))) : 0;
        int k = 1;
        long n1 = 0;
        long n2 = 0;
        for (int i = 0; i < maxLen; i++) {
            Integer s1 = l.apply(i, num1);
            Integer s2 = l.apply(i, num2);
            n1 += s1 * k;
            n2 += s2 * k;
            k *= 10;
        }
        return Long.toString(n1 * n2);
    }

}
