### [Two Sum IV - Input is a BST](https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/)

实在想不出来可以利用二叉树的性质遍历一边并且不利用外部空间就解决这个问题的方法.
所以最后使用了HashSet.这样就忽视了二叉排序树的特点.



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
    HashSet<Integer> set = new HashSet<>();

    boolean dfs(TreeNode root, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return dfs(root.left, k) || dfs(root.right, k);
    }

    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, k);
    }
}
```

这里也有其他的方法,但是其他的方案时间空间复杂度很高,而且比较麻烦.