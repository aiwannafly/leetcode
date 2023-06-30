package ransomnote;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<String, Integer> magazineMap = getCountMap(magazine);
        Map<String, Integer> ransomNoteMap = getCountMap(ransomNote);
        for (String s : ransomNoteMap.keySet()) {
            Integer required = ransomNoteMap.get(s);
            Integer available = magazineMap.get(s);
            System.out.println(s + " " + required + " " + available);
            if (available == null || required > available) {
                return false;
            }
        }
        return true;
    }

    private Map<String, Integer> getCountMap(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String letter = String.valueOf(s.charAt(i));
            Integer value = map.computeIfAbsent(letter, l -> 0);
            map.put(letter, value + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canConstruct("aa", "ab"));
    }
}
