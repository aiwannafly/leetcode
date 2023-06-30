package longestuniquesubstring;

import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
//        Set<Character> currChars = new HashSet<>();
//        int maxLen = 0;
//        int currLen = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char curr = s.charAt(i);
//            if (!currChars.contains(curr)) {
//                currChars.add(curr);
//                currLen++;
//                continue;
//            }
//            currChars.clear();
//            if (maxLen < currLen) {
//                maxLen = currLen;
//            }
//            currChars.add(curr);
//            currLen = 1;
//        }
//        if (maxLen < currLen) {
//            maxLen = currLen;
//        }

        Map<Character, Integer> positions = new HashMap<>();
        Set<Character> toRemove = new HashSet<>();
        int maxLen = 0;
        int currLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            Integer prevPos = positions.get(curr);
            if (prevPos == null) {
                positions.put(curr, i);
                currLen++;
                continue;
            }
            toRemove.clear();
            for (Character character : positions.keySet()) {
                if (positions.get(character) < prevPos) {
                    toRemove.add(character);
                }
            }
            for (Character character : toRemove) {
                positions.remove(character);
            }
            currLen = i - prevPos;
            maxLen = Math.max(maxLen, currLen);
            positions.put(curr, i);
        }
        return Math.max(maxLen, currLen);
    }

//    private static class CharacterPos implements Comparable<CharacterPos> {
//        private final char value;
//        private final int pos;
//
//        CharacterPos(char value, int pos) {
//            this.value = value;
//            this.pos = pos;
//        }
//
//        public char getValue() {
//            return value;
//        }
//
//        public int getPos() {
//            return pos;
//        }
//
//        @Override
//        public int compareTo(CharacterPos o) {
//            return Integer.compare(pos, o.pos);
//        }
//    }
}
