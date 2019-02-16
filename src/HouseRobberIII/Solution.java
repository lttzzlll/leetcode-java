package HouseRobberIII;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public int rob(TreeNode root) {
        int[] maxVal = f(root);
        return Integer.max(maxVal[0], maxVal[1]);
    }

    private int[] f(TreeNode root) {
        if (root == null) return new int[2];
        int[] maxVal = new int [2];
        int[] leftMax = f(root.left);
        int[] rightMax = f(root.right);
        maxVal[0] = Integer.max(leftMax[0], leftMax[1]) + Integer.max(rightMax[0], rightMax[1]);
        maxVal[1] = leftMax[0] + rightMax[0] + root.val;
        return maxVal;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        Solution s = new Solution();
        int maxVal = s.rob(root);
        System.err.println(maxVal);
    }
}