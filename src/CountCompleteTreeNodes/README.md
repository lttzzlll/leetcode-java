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