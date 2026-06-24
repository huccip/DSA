package leetcode.medium;

/**
 * <h1><a href="https://leetcode.com/problems/longest-palindromic-substring/" target="_blank">Problem 2 | Longest Palindromic Substring</a></h1>
 * <br>
 * Given a string s, return the longest palindromic substring in s.
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

class P2Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}

public class P2LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "aababbbuaaau";

        P2Solution solution = new P2Solution();

        System.out.println(solution.longestPalindrome(s));
    }
}
