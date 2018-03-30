### [Binary Tree Paths](https://leetcode.com/problems/binary-tree-paths/description/)

水题一个,本质上还是二叉树的深度优先遍历,理解了这道题
[Path Sum II](https://leetcode.com/problems/path-sum-ii/description/),就好理解了.

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
    void visit(List<List<Integer>> list, List<Integer> curList, TreeNode root, int sum) {
        if (root == null) return;
        curList.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            list.add(curList.stream().collect(Collectors.toList()));
            curList.remove(curList.size() - 1);
            return;
        } 
        visit(list, curList, root.left, sum - root.val);
        visit(list, curList, root.right, sum - root.val);
        curList.remove(curList.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new LinkedList<>();
        visit(list, new ArrayList<>(), root, sum);
        return list;
    }
}
```
