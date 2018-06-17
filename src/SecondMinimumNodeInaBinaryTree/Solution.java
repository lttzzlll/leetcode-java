package SecondMinimumNodeInaBinaryTree;

/**
 * Created by liutaotao on 2018/6/13.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {

    int visit(TreeNode root, int parentVal) {
        if (root.left == null || root.right == null) return parentVal;
        return Math.max(visit(root.left, root.val), visit(root.right, root.val));
    }

    public int findSecondMinimumValue(TreeNode root) {
        return visit(root, -1);
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(5);
//        root.right.left = new TreeNode(5);
//        root.right.right = new TreeNode(7);
//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(2);
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        Solution solution = new Solution();
        System.out.println(solution.findSecondMinimumValue(root));
    }
}
