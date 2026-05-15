package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1><a href="https://leetcode.com/problems/two-sum" target="_blank">Problem 1 | Two Sum</a></h1>
 * <br>
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 * <br><br>
 *
 * <h1><u>Constraints:</u></h1>
 * <br>
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 *
 * <br><br>
 *
 * <h1><u>Follow-up:</u></h1>
 * <br>
 * Can you come up with an algorithm that is less than O(n2) time complexity?
 *
 * <br><br>
 *
 * <h1><u>Optimization:</u></h1>
 * <br>
 * To optimize this from O(n²) to O(n), use a Hash Map. This allows you to trade a small amount of space for a significant gain in speed (traversal time).
 * <br>
 * => Instead of using two nested loops to find a pair, you can iterate through the array just once. As you visit each number, you calculate its complement (the value needed to reach the target).
 * <br>
 * => You then check if that complement already exists in your map.
 * <br>
 * => If so, return the map value of it and the value of num[i].
 * <br>
 * => Otherwise, keep on traversing the array until you find the complement (which is guaranteed in this case)
 *
 */

class P1Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);
        }

        return null;
    }
}

public class P1TwoSum {

    public static void main(String[] args) {
        P1Solution s = new P1Solution();

        int[] nums = {9, 1, 7, 2};
        int target = 9;
        int[] res = s.twoSum(nums, target);

        System.out.println(res[0] + " " + res[1]);
    }
}