### [Sum of Left Leaves](https://leetcode.com/problems/sum-of-left-leaves/description/)

水题.读懂题意后就会做了.

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
    boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return sumOfLeftLeaves(root.right);
        if (isLeaf(root.left)) return root.left.val + sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);

    }
}
```
