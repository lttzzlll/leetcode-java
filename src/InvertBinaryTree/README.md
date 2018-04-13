### [Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/description/)


传说中的翻转二叉树,虽然不值得一提,但是这道简单的关于二叉树的问题却包含了
一个很基本的理念-分治.即问题的分解与合并.

代码如下:


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

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.right = left;
            root.left = right;
        }
        return root;
    }
}
```

其中,

```Java
TreeNode left = invertTree(root.left);
TreeNode right = invertTree(root.right);
root.right = left;
root.left = right;
```

前两行是对原问题的分解,将一个大问题分解为两个小问题;后两行是对分解后子问题的合并,
将两个小的子问题的解合并为原问题的解.虽然就是这四句话,但也包含了原问题分解与子问题合并
两个步骤.对基本的问题越嚼越碎,才能越走越远.
