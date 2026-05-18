package leetcode.easy;

import java.util.Arrays;

/**
 * <h1><a href="https://leetcode.com/problems/counting-bits/description/?envType=problem-list-v2&envId=oizxjoit" target="_blank">Problem 11 | Counting Bits</a></h1>
 * <br>
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 *
 * <br><br>
 *
 * <h1><u>Follow-up:</u></h1>
 * <br>
 * - It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
 * <br>
 * - Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?
 *
 * <br><br>
 *
 * <h1><u>Optimization:</u></h1>
 * <br>
 * N/A
 *
 */

class P11Solution {
    public int[] countBits(int n) {
        int[] bitFrequencies = new int[n + 1];

        bitFrequencies[0] = 0;

        for (int i = 1; i <= n; i++) {
            bitFrequencies[i] = bitFrequencies[i / 2] + (i % 2);
        }

        return bitFrequencies;
    }
}

public class P11CountingBits {
    public static void main(String[] args) {
        P11Solution s = new P11Solution();
        System.out.println(Arrays.toString(s.countBits(2)));
    }
}
