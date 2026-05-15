package leetcode.easy;

/**
 * <h1><a href="https://leetcode.com/problems/valid-palindrome/description/" target="_blank">Problem 4 | Valid Palindrome</a></h1>
 * <br>
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
 * it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
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
 */

class P4Solution {
    public boolean isPalindrome(String s) {
        int head = 0;
        int tail = s.length() - 1;

        while (head < tail) {
            while (head < tail && !Character.isLetterOrDigit(s.charAt(head))) {
                head++;
            }

            while (head < tail && !Character.isLetterOrDigit(s.charAt(tail))) {
                tail--;
            }

            if (Character.toLowerCase(s.charAt(head)) != Character.toLowerCase(s.charAt(tail))) {
                return false;
            }

            head++;
            tail--;
        }

        return true;
    }
}

public class P4ValidPalindrome {
    public static void main(String[] args) {
        P4Solution p4Solution = new P4Solution();
        System.out.println(p4Solution.isPalindrome("race a car"));
    }
}
