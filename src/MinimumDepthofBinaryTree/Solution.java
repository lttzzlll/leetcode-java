package MinimumDepthofBinaryTree;

/**
 * Created by liutaotao on 2018/3/16.
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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    /**
     * 1
     * 2  11
     * 3
     * 4
     * 5
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(-1);
        root.left.left.left = new TreeNode(5);
//        root.left.left.right = new TreeNode(1);
//        root.right.left.right = new TreeNode(6);
//        root.right.right.right = new TreeNode(8);
        Solution solution = new Solution();
        System.out.println(solution.minDepth(root));
    }
}
