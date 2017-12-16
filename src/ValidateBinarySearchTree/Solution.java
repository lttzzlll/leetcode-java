package ValidateBinarySearchTree;

import java.math.BigInteger;

/**
 * Created by liutaotao on 2017/12/13.
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

    private BigInteger lastMaxVal = new BigInteger("-2147483649");

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        String numStr = String.valueOf(root.val);
        BigInteger num = new BigInteger(numStr);
        if (num.compareTo(lastMaxVal) != 1) return false;
        lastMaxVal = num;
        return isValidBST(root.right);
    }


    public static void main(String[] args) {
//        TreeNode root = new TreeNode(10);
//        root.left = new TreeNode(5);
//        root.right = new TreeNode(15);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(20);

//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(1);
//        root.left.left = new TreeNode(0);
//        root.left.right = new TreeNode(2);
//        root.left.right.right = new TreeNode(3);
//        root.right = new TreeNode(5);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(6);

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(1);
//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);
//System.out.println(Integer.MIN_VALUE);
//        TreeNode root = new TreeNode(-2147483648);

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(1);

        TreeNode root = new TreeNode(Integer.MIN_VALUE);
//        root.left = new TreeNode(Integer.MIN_VALUE);
//        root.right = new TreeNode(Integer.MAX_VALUE);
        Solution solution = new Solution();
        System.out.print(solution.isValidBST(root));
    }
}
