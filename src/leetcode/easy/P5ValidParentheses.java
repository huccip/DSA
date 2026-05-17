package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1><a href="https://leetcode.com/problems/valid-parentheses/description/" target="_blank">Problem 5 | Valid Parentheses</a></h1>
 * <br>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 3. Every close bracket has a corresponding open bracket of the same type.
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

class P5Solution {
    private boolean isAnOpening(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private boolean isSetOfParentheses(char cOpening, char cClosing) {
        return (cOpening == '(' && cClosing == ')') || (cOpening == '[' && cClosing == ']') || (cOpening == '{' && cClosing == '}');
    }

    public boolean isValid(String s) {
        int n = s.length();
        int numberOfSets = 0;

        if (n == 0) return true;
        if (n % 2 != 0) return false;

        int normalHangingOpenerCount = 0;
        int curlyHangingOpenerCount = 0;
        int bracketHangingOpenerCount = 0;

        for (int i = 0; i < n - 1; i++) {
            char cCurrent = s.charAt(i);
            char cNext = s.charAt(i + 1);

            if (i == n / 2 && !isSetOfParentheses(cCurrent, cNext)) return false;

            if (isSetOfParentheses(cCurrent, cNext)) {
                numberOfSets++;
                i++;
                continue;
            }

            if (!isAnOpening(cCurrent)) {
                if (normalHangingOpenerCount == 0 && bracketHangingOpenerCount == 0 && curlyHangingOpenerCount == 0) return false;
                else if (normalHangingOpenerCount > 0 && cCurrent == ')') {
                    normalHangingOpenerCount--;
                    numberOfSets++;
                }
                else if (curlyHangingOpenerCount > 0 && cCurrent == '}') {
                    curlyHangingOpenerCount--;
                    numberOfSets++;
                }
                else if (bracketHangingOpenerCount > 0 && cCurrent == ']') {
                    bracketHangingOpenerCount--;
                    numberOfSets++;
                }
            }
            else if (cCurrent == '(') normalHangingOpenerCount++;
            else if (cCurrent == '{') curlyHangingOpenerCount++;
            else if  (cCurrent == '[') bracketHangingOpenerCount++;

            if (!isAnOpening(cNext)) {
                if (normalHangingOpenerCount == 0 && bracketHangingOpenerCount == 0 && curlyHangingOpenerCount == 0) return false;
                else if (normalHangingOpenerCount > 0 && cNext == ')') {
                    normalHangingOpenerCount--;
                    numberOfSets++;
                }
                else if (curlyHangingOpenerCount > 0 && cNext == '}') {
                    curlyHangingOpenerCount--;
                    numberOfSets++;
                }
                else if (bracketHangingOpenerCount > 0 && cNext == ']') {
                    bracketHangingOpenerCount--;
                    numberOfSets++;
                }
            }
            else if (cNext == '(') normalHangingOpenerCount++;
            else if (cNext == '{') curlyHangingOpenerCount++;
            else if (cNext == '[') bracketHangingOpenerCount++;
        }

        return numberOfSets == n / 2;
    }
}

public class P5ValidParentheses {
    public static void main(String[] args) {
        P5Solution s = new P5Solution();
        String parentheses1 = "()[]{}";
        String parentheses2 = "(]";
        String parentheses3 = "([)]";
        String parentheses4 = "([])";
        String parentheses5 = "([]{()})";
        String parentheses6 = "([]{()}][)";

        System.out.println(s.isValid(parentheses1));
        System.out.println(s.isValid(parentheses2));
        System.out.println(s.isValid(parentheses3));
        System.out.println(s.isValid(parentheses4));
        System.out.println(s.isValid(parentheses5));
        System.out.println(s.isValid(parentheses6));
    }
}
