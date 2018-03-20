### [Symmetric Tree](https://leetcode.com/problems/symmetric-tree/description/)

水题.

对于考察二叉树这类偏向数据结构的题,紧扣定义是解题的最好方法.代码通常二三行,因为二叉树的定义便是递归定义的.

代码:

```Java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    boolean isEqual(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null && right != null || right == null && left != null) return false;
        if (left.val != right.val) return false;
        return isEqual(left.left, right.right) && isEqual(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isEqual(root.left, root.right);
    }
}
```