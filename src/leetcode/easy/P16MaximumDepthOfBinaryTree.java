package leetcode.easy;

/**
 * <h1><a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/description/" target="_blank">Problem 16 | Maximum Depth of Binary Tree</a></h1>
 * <br>
 * Given the root of a binary tree, return its maximum depth.
 * <br>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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

class P16Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else if (root.left == null && root.right == null) return 1;
        else return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

public class P16MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        P16Solution sol = new P16Solution();
        System.out.println(sol.maxDepth(root));
    }
}
