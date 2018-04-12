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
        int leftHeight = visit(root.left);
        int rightHeight = visit(root.right);
        int leftMaxHeight =
                (root.left != null && root.left.val == root.val) ? (1 + leftHeight) : 0;
        int rightMaxHeight =
                (root.right != null && root.right.val == root.val) ? (1 + rightHeight) : 0;

        maxLen = Math.max(maxLen, leftMaxHeight + rightMaxHeight);
        return Math.max(leftMaxHeight, rightMaxHeight);
    }

    public int longestUnivaluePath(TreeNode root) {
        visit(root);
        return maxLen;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(5);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        Solution solution = new Solution();
        System.out.println(solution.longestUnivaluePath(root));
    }
}
