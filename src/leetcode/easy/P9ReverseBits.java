package leetcode.easy;

/**
 * <h1><a href="https://leetcode.com/problems/reverse-bits/description/?envType=problem-list-v2&envId=oizxjoit" target="_blank">Problem 9 | Reverse Bits</a></h1>
 * <br>
 * Reverse bits of a given 32 bits signed integer.
 *
 * <br><br>
 *
 * <h1><u>Follow-up:</u></h1>
 * <br>
 * If this function is called many times, how would you optimize it?
 *
 * <br><br>
 *
 * <h1><u>Optimization:</u></h1>
 * <br>
 * N/A
 *
 */

class P9Solution {
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {

            result <<= 1;

            int lastBit = n & 1;

            result |= lastBit;

            n >>>= 1;
        }

        return result;
    }
}

public class P9ReverseBits {
    public static void main(String[] args) {
        P9Solution s = new P9Solution();
        System.out.println(s.reverseBits(43261596));
    }
}
