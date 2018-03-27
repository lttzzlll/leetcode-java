package CountCompleteTreeNodes.PathSumIII;

/**
 * Created by liutaotao on 2018/3/27.
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
    int calc(TreeNode root, int sum) {
        if (root == null) return 0;
//        if (root.val > sum) return 0;
        if (root.val == sum) return 1 + calc(root.left, sum - root.val) + calc(root.right, sum - root.val);
        return calc(root.left, sum - root.val) + calc(root.right, sum - root.val);
    }

    int visit(TreeNode root, int sum) {
        if (root == null) return 0;
        return calc(root, sum) + visit(root.left, sum) + visit(root.right, sum);
    }

    public int pathSum(TreeNode root, int sum) {
        return visit(root, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);
        Solution solution = new Solution();
        int cnt = solution.pathSum(root, 8);
        System.out.println(cnt);
    }

}
