package roman;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private final Map<String, Integer> romanTwins = new HashMap<>();
    private final Map<String, Integer> romanOnes = new HashMap<>();

    public Solution() {
        romanOnes.put("I", 1);
        romanOnes.put("V", 5);
        romanOnes.put("X", 10);
        romanOnes.put("L", 50);
        romanOnes.put("C", 100);
        romanOnes.put("D", 500);
        romanOnes.put("M", 1000);
        romanTwins.put("IV", 4);
        romanTwins.put("IX", 9);
        romanTwins.put("XL", 40);
        romanTwins.put("XC", 90);
        romanTwins.put("CD", 400);
        romanTwins.put("CM", 900);
    }

    public int romanToInt(String s) {
        int res = 0;
        int len = s.length();
        int idx = 0;
        while (idx < len) {
            if (idx == len - 1) {
                res += romanOnes.get(String.valueOf(s.charAt(idx)));
                idx++;
                continue;
            }
            Integer twinRes = romanTwins.get(s.substring(idx, idx + 2));
            if (twinRes == null) {
                res += romanOnes.get(String.valueOf(s.charAt(idx)));
                idx++;
                continue;
            }
            res += twinRes;
            idx += 2;
        }
        return res;
    }
}
