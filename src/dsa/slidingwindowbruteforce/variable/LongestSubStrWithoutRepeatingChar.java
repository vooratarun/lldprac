package dsa.slidingwindowbruteforce.variable;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStrWithoutRepeatingChar {
    public static void main(String[] args) {

    }

    public static int longestSubstring(String s) {
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();

            for (int j = i; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) break;

                set.add(s.charAt(j));
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }
}
