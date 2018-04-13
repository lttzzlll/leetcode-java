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


如何理解visit函数的功能?

如果去掉这一行
```Java
max = Math.max(max, lmax + rmax);
```

visit函数变成
```Java
int visit(TreeNode root) {
    if (root == null) return 0;
    int lh = visit(root.left);
    int rh = visit(root.right);
    int lmax = (root.left != null && root.left.val == root.val) ? (lh + 1) : 0;
    int rmax = (root.right != null && root.right.val == root.val) ? (rh + 1) : 0;
    max = Math.max(max, lmax + rmax);
    return Math.max(lmax, rmax);
}
```

此时,这个函数的功能就是求以root为根结点并且左右子树的值也必须和根结点相同的
路径的长度.

但是我们要求解的是以root为根结点的整棵树的最大路径长度-全局最优解,而以当前
root结点为中心的左右子树的值和root结点一致的解是一个局部最优解,这个局部最优解
可能是全部最优解,也可能不是全局最优解.比如,下面这种情况:

```
            5
          4   5
        4  4   5
       4    4
```

以4为中心的结点才是全局最优解,以5为中心的结点不是全局最优解.所以需要通过比较
每个局部最优解的值,才能得出全局最优解,所以才需要这一行代码:
```Java
max = Math.max(max, lmax + rmax);
```

但是如何理解下面这段代码呢?

```Java
public int longestUnivaluePath(TreeNode root) {
    visit(root);
    return max;
}
```

虽然root根结点不一定是全局最优解,但是我们需要在root根结点才能拿到这个全局最优解.
也就是说,产生全局最优解的结点不一定是最终拿到全局最优解的结点.通常拿到全局最优解的结点
都是以根结点作为出发点.

也许,通过剪枝可以提前拿到全局最优解,但也不一定会在产生全局最优解的结点就能立即停止函数,返回
全局最优解.

