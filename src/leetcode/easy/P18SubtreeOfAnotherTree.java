package leetcode.easy;

/**
 * <h1><a href="https://leetcode.com/problems/subtree-of-another-tree/description/" target="_blank">Problem 18 | Subtree of Another Tree</a></h1>
 * <br>
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 * <br><br>
 * A subtree of a binary tree "tree" is a tree that consists of a node in tree and all of this node's descendants. The tree "tree" could also be considered as a subtree of itself.
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

class P18Solution {
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;


        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}

public class P18SubtreeOfAnotherTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        P18Solution sol = new P18Solution();
        System.out.println(sol.isSubtree(root, subRoot));
    }
}
