### [Binary Search Tree Iterator](https://leetcode.com/problems/binary-search-tree-iterator/description/)

> 实现二叉排序树的迭代器(访问者)模式.

两个方法接口:
1. hasNext. 判断是否存在下一个将要访问的节点. O(1)
2. next. 获取下一个要访问的节点. O(n)

因为hasNext的时间复杂度要求为O(1),所以这里只能通过访问一个保存"状态"的变量.此处用来保存这个状态的变量有两个,一个是Stack,一个是TreeNode.具体结合next方法.
这里next的时间复杂度要求为O(log(n)),而Stack中保存的正是node=node.left这条直到叶节点的路径.所以此处访问下一个节点的时间复杂度正好是O(log(n)).

代码:

```Java
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode node;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        node = root;
    }

    public boolean hasNext() {
        return !stack.isEmpty() || node != null;
    }


    public int next() {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        node = stack.pop();
        int val = node.val;
        node = node.right;
        return val;
    }
}
```

因为访问的是一个二叉排序树,所以按顺序访问的次序为 node->left, node.self, node->right.即

```
void preorder(TreeNode root) {
    if (root != null) {
        preorder(root.left);
        visit(root);
        preorder(root.right);
    }
}
```

这是经典的遍历二叉排序树的方式.现在要把这个算法实现为访问者模式.即一次只访问一个节点,是否访问这个节点及是否继续访问的控制权要在调用者的手中.
由于二叉树特殊的结构[非线性结构],但是呢,又要"线性访问"其中的元素.所以,这里要用一种其他的数据结构暂存访问的结果.
而且要求我们访问这种数据结构的时间复杂度为O(log(n)),另外还需要满足二叉树回溯访问下一个节点的特性,所以这里用到了栈.
利用其FILO的特征,当我们遍历到叶节点的时候,需要回溯到上一个节点的时候,通过stack.pop()就回到了上一个已经被访问过的节点并且"回溯"到该节点
重新访问.

函数next应该如何理解?

```Java
public int next() {
    while (node != null) {
        stack.push(node);
        node = node.left;
    }
    node = stack.pop();
    int val = node.val;
    node = node.right;
    return val;
}
```

二叉排序树的访问顺序已知: node.left, node, node.right.
所以最小的元素在node.left的最left,此时stack中保存的栈顶元素就是最左侧的叶节点,即为最小的元素.
注意:这里访问最左侧元素与访问该左侧元素的父元素的动作都是一样的:stack.pop(),因为node与node.left
在同一条路径上,所以之前的遍历二叉排序树的方式node.left, node, node.right在这里变成了:
leftnoed=stack.pop(), node=stack.pop(),rightnode=node.right.这个地方是需要转换一下的地方.

在一开始学习二叉树的时候,就有分别用递归与栈的方式分别实现前序,中序,后序,遍历,当时感觉用递归实现就可以了,
用栈实现没什么意义.现在终于直到用栈实现的意义了.所以下面分别用栈来实现一下二叉树的前序,中序,后序遍历.

preorder

```Java
class PreOrderBSTIterator implements BSTIterator {
    Stack<TreeNode> stack;
    TreeNode node;

    public PreOrderBSTIterator(TreeNode root) {
        stack = new Stack<>();
        node = root;
    }

    @Override
    public int next() {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        node = stack.pop();
        int val = node.val;
        node = node.right;
        return val;
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty() || node != null;
    }
}

```

inorder

```Java
class InOrderBSTIterator implements BSTIterator {
    Stack<TreeNode> stack;

    public InOrderBSTIterator(TreeNode root) {
        stack = new Stack<>();
        if (root != null)
            stack.push(root);
    }

    /**
     *         10
     *        -  -
     *       -    -
     *      -      -
     *     5        15
     *    --        --
     *   -  -      -  -
     *  -    -    -    -
     * -      -  -      -
     * 1       8 12      20
     */

    @Override
    public int next() {
        TreeNode node = stack.pop();
        int val = node.val;
        if (node.right != null) stack.push(node.right);
        if (node.left != null) stack.push(node.left);
        return val;
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

```

postorder

```Java
class PostOrderBSTIterator implements BSTIterator {
    Stack<TreeNode> s1;
    Stack<TreeNode> s2;


    public PostOrderBSTIterator(TreeNode root) {
        s1 = new Stack<>();
        s2 = new Stack<>();
        if (root != null) s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode node = s1.pop();
            s2.push(node);
            if (node.left != null) s1.push(node.left);
            if (node.right != null) s1.push(node.right);
        }
    }

    /**
     *                 12
     *                -  -
     *               -    -
     *              -      -
     *             5        15
     *            --        --
     *           -  -      -  -
     *          -    -    -    -
     *         -      -  -      -
     *        1       8 13      20
     *                -
     *                 -
     *                  -
     *                  10
     *                  --
     *                 -  -
     *                -    -
     *               -      -
     *              9        11
     */
    @Override
    public int next() {
        return s2.pop().val;
    }

    @Override
    public boolean hasNext() {
        return !s2.isEmpty();
    }
}

```

此处的PostOrder是用两个栈实现的,而且调用next()的时间复杂度也不是O(log(n)),因为前期有一个访问全部节点然后放入栈的过程,所以总体时间复杂度为O(n),
空间复杂度也为O(n).

二叉树的后序遍历用栈实现不用于前序遍历和中序遍历,前两者类似于"尾递归",可以被"优化",而后序遍历没有这个"尾巴",之前的经验不再生效.

存在用一个栈实现后序遍历的方案,但是不同于前序和中序,算法复杂度大大增加.

为什么后序遍历不能使用一个栈来实现[简单实现]?