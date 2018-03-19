package SumofLeftLeaves;

/**
 * Created by liutaotao on 2018/3/19.
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
    boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return sumOfLeftLeaves(root.right);
        if (isLeaf(root.left)) return root.left.val + sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
        Solution solution = new Solution();
        System.out.println(solution.sumOfLeftLeaves(root));
    }
}
