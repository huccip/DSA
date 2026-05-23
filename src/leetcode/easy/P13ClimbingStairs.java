package leetcode.easy;

/**
 * <h1><a href="https://leetcode.com/problems/climbing-stairs/description/?envType=problem-list-v2&envId=oizxjoit" target="_blank">Problem 13 | Climbing Stairs</a></h1>
 * <br>
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
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

class P13Solution {
    // brute force solution O(2^n) time O(n) space
//    public int climbStairs(int n) {
//        if (n == 1) return 1;
//        if (n == 2) return 2;
//
//        return climbStairs(n - 1) + climbStairs(n - 2);
//    }

    // optimized solution O(n) time O(1) space
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int twoStepsBehind = 1;
        int oneStepBehind = 2;
        int currentWays = 0;

        for (int i = 3; i <= n; i++) {
            currentWays = oneStepBehind + twoStepsBehind;

            twoStepsBehind = oneStepBehind;
            oneStepBehind = currentWays;
        }

        return currentWays;
    }
}

public class P13ClimbingStairs {
    public static void main(String[] args) {
        P13Solution sol = new P13Solution();
        System.out.println(sol.climbStairs(4));
        System.out.println(sol.climbStairs(5));
        System.out.println(sol.climbStairs(6));
        System.out.println(sol.climbStairs(7));
    }
}
