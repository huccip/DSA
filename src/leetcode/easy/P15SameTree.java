package leetcode.easy;

/**
 * <h1><a href="https://leetcode.com/problems/same-tree/description" target="_blank">Problem 15 | Same Tree</a></h1>
 * <br>
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * <br>
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
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

class P15Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

public class P15SameTree {
    public static void main(String[] args) {
        P15Solution sol = new P15Solution();

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(7);

        System.out.println(sol.isSameTree(root1, root2));
    }
}
