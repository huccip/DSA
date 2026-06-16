package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * <h1><a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/description/" target="_blank">Problem 1 | Longest Substring Without Repeating Characters</a></h1>
 * <br>
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 * <br><br>
 *
 * <h1><u>Follow-up:</u></h1>
 * <br>
 * N/A
 *
 * <br><br>
 *
 * <h1><u>Optimization:</u></h1>
 * <br>
 * N/A
 *
 */

class P1Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            while (seen.contains(currentChar)) {
                seen.remove(s.charAt(left));
                left++;
            }

            seen.add(currentChar);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

public class P1LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";

        P1Solution solution = new P1Solution();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
