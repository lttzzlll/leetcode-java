package TwoSumIVInputisaBST;

/**
 * Created by liutaotao on 2018/4/18.
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
    /**
     * 如何转化为一个搜索的问题?
     * 问题的转化非常重要
     */

    boolean find(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val < target) return find(root.right, target);
        else if (root.val > target) return find(root.left, target);
        else return true;
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        if (root.val < k)
            return k - root.val < root.val ? find(root.left, k - root.val) : find(root.right, k - root.val);
        if (root.val > k)
            return root.val - k < root.val ? find(root.left, root.val - k) : find(root.right, root.val - k);
        return 0 < root.val ? find(root.left, 0) : find(root.right, 0);
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(3);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
//        root.right = new TreeNode(6);
//        root.right.right = new TreeNode(7);
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        Solution solution = new Solution();
        System.out.println(solution.findTarget(root, 4));
    }
}
