### [Count Complete Tree Nodes](https://leetcode.com/problems/count-complete-tree-nodes/description/)

一个朴素的想法:

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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
```

针对所有二叉树都有效,但是这里会超时.
所以要充分利用完全二叉树的性质,减少计算量.
这里所谓的减少计算量,就是减少深搜的层数.
深搜的层数越少越好,但至少会搜到底一次.
所以这里就要减少同时搜索两个分支,最好只搜素一个分支
就能推算出节点的总数量.

Discuss中给出的方法,没有仔细观察完全二叉树的性质,但是这种方案的时间复杂度为 O((log(n)) ^ 2).即有
log(n) * log(n) < n 成立.

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
    static int level(TreeNode root) {
        return root == null ? 0 : 1 + level(root.left);
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = level(root.left);
        int rightHeight = level(root.right);
        if (leftHeight == rightHeight) return (1 << leftHeight)  + countNodes(root.right);
        else return (1 << rightHeight) + countNodes(root.left);
    }
}
```

这里有一篇文章,讲述了满二叉树,完全二叉树,完美二叉树的区别[完美二叉树, 完全二叉树和完满二叉树](http://www.cnblogs.com/idorax/p/6441043.html).对比记忆.

