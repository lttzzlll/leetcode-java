package DiameterofBinaryTree;

/**
 * Created by liutaotao on 2018/4/12.
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
    int maxLen;

    int visit(TreeNode root) {
        if (root == null) return 0;
        int leftLength = root.left == null ? 0 : visit(root.left) + 1;
        int rightLength = root.right == null ? 0 : visit(root.right) + 1;
        maxLen = Math.max(maxLen, leftLength + rightLength);
        return Math.max(leftLength, rightLength);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        visit(root);
        return maxLen;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        Solution solution = new Solution();
        System.out.println(solution.diameterOfBinaryTree(root));
    }
}
