### [Binary Tree Tilt](https://leetcode.com/problems/binary-tree-tilt/description/)

试想下面几种情况:

0. 最简单的情况:空树,没有树节点,返回0

1. 很简单的情况:只有一个根节点root, root.left == null & root.right == null, 返回0.

2. 一般情况,树有好几层,比如:
         root
         - -
        -   -
       -     -
      -       -
    left     right

  此时: f(root) = | Weight(left) - Weight(right) |


3. 再复杂一点:
                           root
                           - -
                          -   -
                         -     -
                        -       -
                     left      right
                     - -        - -
                    -   -      -   -
                   -     -    -     -
                 left  right left  right

   此时: f(root) = | Weight(root.left) - Weight(root.right) | + f(root.left) + f(root.right)

   Weight(TreeNode): 求这棵树的"总质量"


所以,当推导出这个公式的时候,问题就很好解决了.

这道题大概分为两个求解的部分:
1. 求子树的"总重量"
2. 求子树的"Tilt"值.

这两者的关系是: Tilt(TreeNode) = Tilt(TreeNode.left) + Tilt(TreeNode.right) + Weight(TreeNode.left) + Weight(TreeNode.right).
[comment]: <> (即为上面推导出来的公式.还可以泛化推广一下到多叉树
Tilt(TreeNode) = Tilt(TreeNode[...subTreeNodes]) + Weight(TreeNode[...subTreeNodes]))

这道题的求解方法既可以用Top-to-Bottom, 又可以用Bottom-to-Top.
因为求子树的Tilt值得过程就是一个自上往下遍历的过程.而求子树的Weight既可以从上往下遍历所有的子树,也可以先求子树的重量然后再汇总到父节点.
后者的优点在于子节点的重量已经知道,父节点只需会中所有子节点的重量然后加上自己节点的重量即可.

根据上面的讨论:

1. Top-to-Bottom版本:

```Java
class Solution {
    private int weight(TreeNode root) {
        if (root == null) return 0;
        return weight(root.left) + weight(root.right) + root.val;
    }

    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        return findTilt(root.left) + findTilt(root.right) +
                Math.abs(weight(root.left) - weight(root.right));
    }
}
```

2. Bottom-to-Top版本:

```Java
class Solution {
    int gVal = 0;

    private int weight(TreeNode root) {
        if (root == null) return 0;
        int left = weight(root.left);
        int right = weight(root.right);
        gVal += Math.abs(left - right);
        return left + right + root.val;
    }

    public int findTilt(TreeNode root) {
        weight(root);
        return gVal;
    }
}
```

gVal用来收集最终的结果. 这一行逻辑图示如下:

                root
                 --
     -------------------------------- gVal += Math.abs(left - right)
                -  -
               -    -
              -      -
             -        -
           left     right


    gVal += Math.abs(left - right) 这一行相当于刺破weight函数原来的栈运行空间, 在函数返回前插入这一行逻辑.

    与1.Top-to-Bottom版本中的Weight函数相比,2.Bottom-to-Top版本中的Weight函数更加"机智"一点.
    当函数还没有触及到root节点时, gVal的值等于 左右子树的重量差;一旦回溯到上一级父节点Weight函数中便包含了原来节点的val值.所以很巧妙.
    而且,对于函数栈的空间利用相当高.因为是字底向上,先求子树的Weight,再求上一级父节点的Weight,具有连贯性,所以所有节点都只被访问了一次,
    时间复杂度和空间复杂度都是O(n).
    而版本1中的Tilt函数由于是自顶向下搜索,所以会不断地调用Weight函数,所以其时间复杂度和空间复杂度远远大于O(n).
    至少为O(nlog(n)).