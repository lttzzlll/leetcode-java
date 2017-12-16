### [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/description/)

本质上是二叉树的中序遍历,并不难,比较麻烦的地方在于特殊情况-int取值范围的边界问题
int: -2147483648 - 2147483647.如果是Python这类的动态语言,就不存在这个问题,但是因为Java如此的c,所以比较麻烦,最终还是采用了一种偷懒的方法BigInteger,让这个问题消失,但是并没有解决.

```Java
import java.math.BigInteger;
class Solution {
    private BigInteger lastMaxVal = new BigInteger("-2147483649");

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        String numStr = String.valueOf(root.val);
        BigInteger num = new BigInteger(numStr);
        if (num.compareTo(lastMaxVal) != 1) return false;
        lastMaxVal = num;
        return isValidBST(root.right);
    }
}
```

有没有一种很好的方法,可以比较优雅的解决这个问题?

为什么不用Long呢?Long的范围为64个bit,比int多了一倍,取值范围 -9223372036854775808 - 9223372036854775807, 所以会得到下面的方案:

```Java
class Solution {

    private long lastMaxVal = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (root.val <= lastMaxVal) return false;
        lastMaxVal = root.val;
        return isValidBST(root.right);
    }
}
```

Discuss中提供了另外一种表示,有点像"二分类"的样子,但是,涉及到二叉树的问题,本质上大都是一样的思路.
```Java
class Solution {
    private boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val <= minVal || root.val >= maxVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
```

确实更简洁.
