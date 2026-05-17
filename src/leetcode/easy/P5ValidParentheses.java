package leetcode.easy;

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
 * There is not much to optimize here, but what we did was working with primitives (char[]) instead of object boxing (stack)
 *
 */

class P5Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack[++top] = ')';
            } else if (c == '{') {
                stack[++top] = '}';
            } else if (c == '[') {
                stack[++top] = ']';
            } else {
                if (top == -1 || stack[top--] != c) {
                    return false;
                }
            }
        }

        return top == -1;
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
