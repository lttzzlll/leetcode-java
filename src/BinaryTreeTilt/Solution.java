package BinaryTreeTilt;

/**
 * Created by liutaotao on 2017/12/28.
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

//    private int weight(TreeNode root) {
//        if (root == null) return 0;
//        return weight(root.left) + weight(root.right) + root.val;
//    }
//
//    public int findTilt(TreeNode root) {
//        if (root == null) return 0;
//        return findTilt(root.left) + findTilt(root.right) +
//                Math.abs(weight(root.left) - weight(root.right));
//    }

    int gVal = 0;

    private int weight(TreeNode root) {
        if (root == null) return 0;
        int left = weight(root.left);
        int right = weight(root.right);
        gVal += Math.abs(left - right);
        return left + right + root.val;
    }

    public int findTilt(TreeNode root) {
        weight(root);
        return gVal;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        Solution s = new Solution();
        int res = s.findTilt(root);
        System.out.println(res);
    }
}
