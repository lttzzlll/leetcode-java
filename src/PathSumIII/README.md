### [Path Sum III](https://leetcode.com/problems/path-sum-iii/description/)

试着试着就通过了.说明对这道题的理解还不是很深.

最初的版本如下:

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
    int calc(TreeNode root, int sum) {
        if (root == null) return 0;
        if (root.val > sum) return 0;
        if (root.val == sum) return 1;
        else return calc(root.left, sum - root.val) + calc(root.right, sum - root.val);
    }

    int visit(TreeNode root, int sum) {
        if (root == null) return 0;
        return calc(root, sum) + visit(root.left, sum) + visit(root.right, sum);
    }

    public int pathSum(TreeNode root, int sum) {
        return visit(root, sum);
    }
}
```

这个版本有两个缺陷:
1. 只能对非负数有效,对存在负数的情况则无效.
比如taraget = -5, curNode.val = -3, childNode.val = -2,
因为 -3 > -5 所以 直接return,便忽视了这种情况.

针对这种情况,稍加改进,得到新的版本:

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
    int calc(TreeNode root, int sum) {
        if (root == null) return 0;
//        if (root.val > sum) return 0;
        if (root.val == sum) return 1;
        else return calc(root.left, sum - root.val) + calc(root.right, sum - root.val);
    }

    int visit(TreeNode root, int sum) {
        if (root == null) return 0;
        return calc(root, sum) + visit(root.left, sum) + visit(root.right, sum);
    }

    public int pathSum(TreeNode root, int sum) {
        return visit(root, sum);
    }
}
```

很明显,改进的地方在于当 curNode.val > target 时,仍然继续往下搜索.在代码
上表现为注释掉了 if (root.val > sum) return 0; 这一行.

但是上面这个版本还是有缺陷,当
target = -5, curNode.val = -5, childNode.val = 0时,便忽视了
prevNode... -> curNode -> childNode 这条路径,只留下 prevNode... -> CurNode这条路径.
针对这种情况,继续改进,得到下面代码:

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
    int calc(TreeNode root, int sum) {
        if (root == null) return 0;
        // if (root.val > sum) return 0;
        if (root.val == sum) return 1 + calc(root.left, sum - root.val) + calc(root.right, sum - root.val);
        else return calc(root.left, sum - root.val) + calc(root.right, sum - root.val);
    }

    int visit(TreeNode root, int sum) {
        if (root == null) return 0;
        return calc(root, sum) + visit(root.left, sum) + visit(root.right, sum);
    }

    public int pathSum(TreeNode root, int sum) {
        return visit(root, sum);
    }
}
```

即在 curNode.val == target的情况下,不要停止搜索,而是继续向下搜索,
在代码上表现为 
 if (root.val == sum) return 1; -> if (root.val == sum) return 1 + calc(root.left, sum - root.val) + calc(root.right, sum - root.val);

这样,才满足了所有的条件.
