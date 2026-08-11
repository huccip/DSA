package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1><a href="https://leetcode.com/problems/3sum/" target="_blank">Problem 4 | 3Sum</a></h1>
 * <br>
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <br>
 * Notice that the solution set must not contain duplicate triplets.
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

public class P43Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1, high = nums.length - 1;
                int sum = -nums[i];

                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > sum) high--;
                    else low++;
                }
            }
        }

        return res;
    }
}

class P4Solution {
    public static void main(String[] args) {
        P43Sum p = new P43Sum();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = p.threeSum(nums);

        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}