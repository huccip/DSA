package leetcode.easy;

/**
 * <h1><a href="https://leetcode.com/problems/valid-anagram/description/" target="_blank">Problem 7 | Valid Anagram</a></h1>
 * <br>
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise. (i.e. s should be re-arranged to form t)
 *
 * <br><br>
 *
 * <h1><u>Follow-up:</u></h1>
 * <br>
 * What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 *
 * <br><br>
 *
 * <h1><u>Optimization:</u></h1>
 * <br>
 * N/A
 *
 */

class P7Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        /**
         * each index represents a letter and the value in that index is just the frequency of it between the two input strings
         * 'a' <- 0, 'b' <- 1, ...
         * if s contains 'a' that means the value at index 0 will be incremented by 1
         * if t contains 'a' that means the value at index 0 will be decremented by 1
          */
        int[] alphabetFrequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabetFrequency[s.charAt(i) - 'a']++;
            alphabetFrequency[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (alphabetFrequency[i] != 0) return false;
        }
        return true;
    }
}

public class P7ValidAnagram {
    public static void main(String[] args) {
        P7Solution s = new P7Solution();
        System.out.println(s.isAnagram("anagram", "nagaram"));
        System.out.println(s.isAnagram("rat", "car"));
    }
}
