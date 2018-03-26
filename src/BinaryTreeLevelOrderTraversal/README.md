### [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/description/)

毕竟是水题.

会了[Binary Tree Level Order Traversal II](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/)
这道题也就会了.这两道题本质上是一样的.只不过形式不一样.

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
    void visit(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) return;
        if (level + 1 > list.size()) list.add(new LinkedList<>());
        list.get(level).add(root.val);
        visit(list, root.left, level + 1);
        visit(list, root.right, level + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root != null)
            visit(res, root, 0);

        return res;
    }
}
```
