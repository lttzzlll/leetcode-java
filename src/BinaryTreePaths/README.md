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
    void visit(List<String> list, LinkedList<String> buf, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            buf.add(String.valueOf(root.val));
            String str = buf.toString();
            list.add(str.substring(1, str.length() - 1).replaceAll(", ", ""));
            buf.remove(buf.size() - 1);
        } else {
            buf.add(String.valueOf(root.val) + "->");
            visit(list, buf, root.left);
            visit(list, buf, root.right);
            buf.remove(buf.size() - 1);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<>();
        visit(list, new LinkedList<String>(), root);
        return list;
    }
}
```

Discuss中有一个更简洁的方法,利用了字符串的不变性.

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
    void visit(List<String> list, String path, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) list.add(path + root.val);
        if (root.left != null) visit(list, path + root.val + "->", root.left);
        if (root.right != null) visit(list, path + root.val + "->", root.right);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<>();
        visit(list, "", root);
        return list;
    }
}
```


