### [Longest Univalue Path](https://leetcode.com/problems/longest-univalue-path/description/)

做了不算太多二叉树的题,总结一下,关于二叉树的问题,本质上还是二叉树的遍历,要么深搜,
要么广搜.深搜中又分先序,中序,后序遍历.


Discuss中代码如下:

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

    int max = 0;

    int visit(TreeNode root) {
        if (root == null) return 0;
        int lh = visit(root.left);
        int rh = visit(root.right);
        int lmax = (root.left != null && root.left.val == root.val) ? (lh + 1) : 0;
        int rmax = (root.right != null && root.right.val == root.val) ? (rh + 1) : 0;
        max = Math.max(max, lmax + rmax);
        return Math.max(lmax, rmax);
    }

    public int longestUnivaluePath(TreeNode root) {
        visit(root);
        return max;
    }
}
```

从这个问题的解法中看出,先求解小问题,再求解大问题,是否可以用动态规划解决?

之前做的题虽然也是递归,也是大问题分解为小问题,但是所有的重点似乎都是在问题的"分解"上,
只要问题分解对了,答案似乎就出来了.而这道题则不同,问题分解很容易,但是在小问题合并为大问题的
时候则很比较麻烦,所以重点在问题的"合并"上;所以总结一下:关于递归的问题,有的侧重问题的"分解",
有的侧重问题的"合并",就如同排序算法中的快速排序和归并排序一样,前者分解很难,但是合并很容易;而后者
则是分解容易合并难.

这道题就是属于分解容易合并难.