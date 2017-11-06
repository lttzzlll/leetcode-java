package BalancedBinaryTree;

/**
 * Created by liutaotao on 2017/11/6.
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
    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else if (root.left == null && root.right == null) {
            return true;
        } else if (root.left != null && root.right != null) {
            return isBalanced(root.left) && isBalanced(root.right)
                    && Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1;
        } else {
            return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left =new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        Solution solution = new Solution();
        System.out.println(solution.isBalanced(root));
    }
}
