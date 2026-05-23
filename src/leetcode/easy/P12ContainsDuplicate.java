package leetcode.easy;

import java.util.HashSet;

/**
 * <h1><a href="https://leetcode.com/problems/contains-duplicate/description/?envType=problem-list-v2&envId=oizxjoit" target="_blank">Problem 12 | Contains Duplicate</a></h1>
 * <br>
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
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

class P12Solution {
    //brute force solution
//    public boolean containsDuplicate(int[] nums) {
//        for (int i=0; i<nums.length; i++){
//            for (int j=i+1; j<nums.length; j++){
//                if (nums[i] == nums[j]){
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }

    //optimized solution
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }

        return false;
    }
}

public class P12ContainsDuplicate {
    public static void main(String[] args) {
        P12Solution s = new P12Solution();
        int[] nums = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(s.containsDuplicate(nums));
        System.out.println(s.containsDuplicate(nums2));
    }
}
