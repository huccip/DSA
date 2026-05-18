package leetcode.easy;

/**
 * <h1><a href="https://leetcode.com/problems/number-of-1-bits/description/?envType=problem-list-v2&envId=oizxjoit" target="_blank">Problem 10 | Number of 1 Bits</a></h1>
 * <br>
 * Given a positive integer n, write a function that returns the number of set bits in its binary representation (also known as the Hamming weight).
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

class P10Solution {
    public int hammingWeight(int n) {
        int activeBitFrequency = 0;
        while (n != 0) {
            if (n % 2 == 1) activeBitFrequency++;
            n = n / 2;
        }
        return activeBitFrequency;
    }
}

public class P10NumberOf1Bits {
    public static void main(String[] args) {
        P10Solution s = new P10Solution();
        System.out.println(s.hammingWeight(11));
    }
}
