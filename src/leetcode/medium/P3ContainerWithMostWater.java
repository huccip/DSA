package leetcode.medium;

/**
 * <h1><a href="https://leetcode.com/problems/container-with-most-water/" target="_blank">Problem 3 | Container With Most Water</a></h1>
 * <br>
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * <br />
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * <br />
 * Return the maximum amount of water a container can store.
 * <br />
 * Notice that you may not slant the container.
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

public class P3ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height.length <= 1) return 0;

        int l = 0, r = height.length - 1;
        int maxArea = 0;

        while (l < r) {
            int currentArea = (r - l) *  Math.min(height[l], height[r]);

            maxArea = Math.max(maxArea, currentArea);

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }
}

class P3Solution {
    public static void main(String[] args) {
        P3ContainerWithMostWater p3 = new P3ContainerWithMostWater();
        int[] heights = {1,8,6,2,5,4,8,3,7};

        System.out.println(p3.maxArea(heights));
    }
}
