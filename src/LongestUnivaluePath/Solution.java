package LongestUnivaluePath;

/**
 * Created by liutaotao on 2018/4/1.
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

    int maxLen = 0;

    int visit(TreeNode root) {
        if (root == null) return 0;
        int lh = visit(root.left);
        int rh = visit(root.right);
        int lmax = (root.left != null && root.left.val == root.val) ? (lh + 1) : 0;
        int rmax = (root.right != null && root.right.val == root.val) ? (rh + 1) : 0;
        maxLen = Math.max(maxLen, lmax + rmax);
        return Math.max(lmax, rmax);
    }

    public int longestUnivaluePath(TreeNode root) {
        visit(root);
        return maxLen;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(5);
        Solution solution = new Solution();
        System.out.println(solution.longestUnivaluePath(root));
    }
}
