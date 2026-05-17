package leetcode.easy;

/**
 * <h1><a href="https://leetcode.com/problems/missing-number" target="_blank">Problem 3 | Missing Number</a></h1>
 * <br>
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 *
 * <br><br>
 *
 * <h1><u>Follow-up:</u></h1>
 * <br>
 * Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 *
 * <br><br>
 *
 * <h1><u>Optimization:</u></h1>
 * <br>
 * Super simple, range and nums input arrays both have the same members except ONE that is within range.
 * <br>
 * => I have thought "since range is already sorted out, how about sorting nums array then compare first with first, second with second, ...Etc which is O(n) time right? Well... Sorting algorithms are O(n²) yikes".
 * <br>
 * => Which led me to think about the first statement again, then a sum of each array made total sense, difference of the two sums would filter the culprit out.
 *
 */

class P3Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int numsSum = 0;
        int rangeSum = 0;
        for (int num : nums) {
            numsSum += num;
        }
        for (int i = 0; i <= n; i++) {
            rangeSum += i;
        }

        return Math.abs(rangeSum - numsSum);
    }
}

public class P3MissingNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        P3Solution s = new P3Solution();
        System.out.println(s.missingNumber(nums));
    }
}
