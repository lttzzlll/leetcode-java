package SymmetricTree;

/**
 * Created by liutaotao on 2018/3/20.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    boolean isEqual(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null && right != null || right == null && left != null) return false;
        if (left.val != right.val) return false;
        return isEqual(left.left, right.right) && isEqual(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isEqual(root.left, root.right);
    }
}
