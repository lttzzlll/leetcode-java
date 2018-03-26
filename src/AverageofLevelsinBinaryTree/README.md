### [Average of Levels in Binary Tree](https://leetcode.com/problems/average-of-levels-in-binary-tree/description/)

> 水题,这道题[Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/description/)
会了,该题就没什么了.

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

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new LinkedList<>();
        if (list != null) {
            List<List<Integer>> res = new LinkedList<>();
            visit(res, root, 0);
            for (int i = 0; i < res.size(); i++) {
                double sum = 0;
                for (int j = 0; j < res.get(i).size(); j++) {
                    sum += res.get(i).get(j);
                }
                list.add(sum / res.get(i).size());
            }
        }
        return list;
    }
}
```

上面,之所以现将每层的所有元素全部保存下来,是因为在水平遍历的时候,没办法保存
该层元素的数量,所以没办法求平均.

一种更加简洁的方法:

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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new LinkedList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int levelCount = queue.size();
                double sum = 0.0;
                for (int i = 0; i < levelCount; i++) {
                    TreeNode node = queue.poll();
                    sum += node.val;
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                list.add(sum / levelCount);
            }
        }
        return list;
    }
}
```

这种方法最为巧妙的地方在于,队列中保存的元素全部都是同一层的元素,所以可以
知道该层元素的数量.

之所以队列中保存的元素全部都是同一层的元素,是因为当开始遍历该层元素的时候,
上层的所有元素全部出队列,因次队列中保存的是当前层的元素以及下一层的元素,又因为
是层次遍历,队列中前面保存的都是当前层的元素,后面才是下一层的元素,而且,
在开始当前层的遍历之前,就已经记录了当前层的元素数量(就是当前时刻队列的大小,此时下层元素
还没有开始入队).

所以,在二叉树队列的层次遍历中,当前队列保存了当前层的元素,当前队列的大小就是
当前层元素的数目.

这才是做这道题最大的收获.