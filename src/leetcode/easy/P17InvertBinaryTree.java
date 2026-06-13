package leetcode.easy;

/**
 * <h1><a href="https://leetcode.com/problems/invert-binary-tree/description/" target="_blank">Problem 17 | Invert Binary Tree</a></h1>
 * <br>
 * Given the root of a binary tree, invert the tree, and return its root.
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

class P17Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root ==null) return null;

        TreeNode tempLeft = root.left;
        root.left = root.right;
        root.right = tempLeft;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}

public class P17InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        P17Solution sol = new P17Solution();
        System.out.println(sol.invertTree(root).val);
    }
}
