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

    int visit(TreeNode root, TreeNode last) {
        if (root == null) return 0;
        if (last == null) {
            if (root.left == null && root.right == null) return 0;
            else if (root.left == null && root.right != null) {
                if (root.val == root.right.val) return visit(root.right, root);
                else return visit(root.right, null);
            } else if (root.right == null && root.left != null) {
                if (root.val == root.left.val) return visit(root.left, root);
                else return visit(root.left, null);
            } else {

                return Math.max(visit(root.left, root), visit(root.right, root));
            }
        } else {
            return -1;
        }
    }


    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        return visit(root, null);
    }

    public static void main(String[] args) {

    }
}
