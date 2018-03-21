### [Path Sum](https://leetcode.com/problems/path-sum/description/)

果然是水题.

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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root != null) {
            if (root.val == sum && root.left == null && root.right == null) return true;
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
        return false;
    }
}
```