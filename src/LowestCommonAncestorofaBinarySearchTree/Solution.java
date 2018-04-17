package LowestCommonAncestorofaBinarySearchTree;

/**
 * Created by liutaotao on 2018/4/16.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public String toString() {
        return "{Node value: " + val + " }";
    }
}

public class Solution {


    /**
     * 这是一棵二叉排序树
     * 要充分利用这一特性
     * 然后利用二分查找
     * 来解决这个问题
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        if (root.val == p.val && root.val == q.val) return root;
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        Solution solution = new Solution();
        System.out.println(solution.lowestCommonAncestor(root, root.left.left, root.left.right.left));
    }
}
