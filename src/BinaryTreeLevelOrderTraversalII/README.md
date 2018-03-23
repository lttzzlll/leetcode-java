### [Binary Tree Level Order Traversal II](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/)

> 本质上还是水题一个.编写过程有点麻烦.或许有更简单的方法.

代码如下:

```Java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    int maxLevel = 0;

    class Record {
        int level;
        TreeNode node;

        public Record(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    void visit(List<Record> list, TreeNode root, int level) {
        if (root != null) {
            Record record = new Record(root, level);
            list.add(record);
            visit(list, root.left, level + 1);
            visit(list, root.right, level + 1);
            if (level + 1 > maxLevel) maxLevel = level + 1;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>(0);
        List<Record> records = new ArrayList<>();
        visit(records, root, 0);
        List<List<Integer>> list = new ArrayList<>(records.get(records.size() - 1).level + 1);
        for (int i = 0; i < maxLevel; i++) {
            list.add(new LinkedList<>());
        }
        for (Record record : records) {
            list.get(maxLevel - record.level - 1).add(record.node.val);
        }

        return list;
    }
}
```

注意到这里要输出的顺序是Bottom-Up,或许暗示着存在某种更加简单的方法.


更简洁的方案如下:

```Java
import java.util.List;

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
        if (level + 1 > list.size()) list.add(0, new LinkedList<>());
        visit(list, root.left, level + 1);
        visit(list, root.right, level + 1);
        list.get(list.size() - level - 1).add(root.val);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        visit(list, root, 0);
        return list;
    }
}
```

没有什么特殊的技巧,与之前的相比,空间复杂度减少O(n).
从这个角度看,这道题的本质就是二叉树的中序遍历,其次是一些小的技巧.
所以掌握基础才是解决问题的关键.

