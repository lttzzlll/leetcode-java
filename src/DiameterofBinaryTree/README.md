### [Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/description/)


如果会了 [Longest Univalue Path](https://leetcode.com/problems/longest-univalue-path/description/)
这道题,那么这道简化版的题也就会了.

代码如下:

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
    int maxLen;

    int visit(TreeNode root) {
        if (root == null) return 0;
        int leftLength = root.left == null ? 0 : visit(root.left) + 1;
        int rightLength = root.right == null ? 0 : visit(root.right) + 1;
        maxLen = Math.max(maxLen, leftLength + rightLength);
        return Math.max(leftLength, rightLength);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        visit(root);
        return maxLen;
    }
}
```

其中,visit函数的意义在于:求当前结点的左右子树中路径最长的值.

把
```Java
maxLen = Math.max(maxLen, leftLength + rightLength);
```
这句话去掉,那么就是这个意思:

```Java
int visit(TreeNode root) {
    if (root == null) return 0;
    int leftLength = root.left == null ? 0 : visit(root.left) + 1;
    int rightLength = root.right == null ? 0 : visit(root.right) + 1;
    return Math.max(leftLength, rightLength);
}
```

然后在这个基础之上,需要看在加上当前结点的情况下,连接左右子树能够构成的
最长路径是多少.所以需要下面这一步:

```Java
maxLen = Math.max(maxLen, leftLength + rightLength);
```

这里最终返回的maxLen实际上等于根结点的 leftLegnth + rightLength,但是由于
visit是一个递归函数,而且先求的是子问题的解,所以maxLen记录了从叶节点到根结点
各个阶段的最大值.如果把这句话修改为:

```Java
maxLen = leftLength + rightLength;
```

最终结果不一定是正确的,因为题意中的最后一句话
***This path may or may not pass through the root.
其实已经说明出现最长路径的结点不一定经过根结点,比如,下面这种情况:

```
             1
          2
       4    5
     6       7
   8          9
 10            11
```

像这种情况,最长路径是以2为节点的左子树为中心结点,而不经过根结点.

但是,由于我们使用的是递归算法,对于子问题的划分是按照二叉树的结构进行
划分的,所以最终子问题的汇总会出现在根结点,所以最优的结果虽然不出现在根结点
的位置,但是我们获取最优结果却需要在根结点才能拿到.能够把问题说的更加明白一些,
对问题的理解就更加透彻.


