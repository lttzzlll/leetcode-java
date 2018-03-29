### [Path Sum II](https://leetcode.com/problems/path-sum-ii/description/)

虽然是中级题,但也很水.

基本思路就是无论当前节点的value是大于还是小于sum,都不要关注,只在到达叶节点的时候
才查看是否node.val == sum,如果相等,则加入记录中;否则,说明从根节点到叶节点的这条路径
所有节点的值之和不等于sum,此路不同,所以丢弃.

这里,有一个非常重要的问题就是每条从根节点到叶节点的路径应该是相互独立,互不干扰的.
因为Java中的数据结构-容器在函数传参的时候所传递的值是原容器的一个引用,所以这里必须
要在每个分叉的节点做一次拷贝,这里应该有可以优化的地方,这里为了方便,没有深究.

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

    void visit(List<List<Integer>> list, List<Integer> curList, TreeNode root, int sum) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                curList.add(root.val);
                list.add(curList);
            } else curList.clear();
            return;
        }
        curList.add(root.val);
        if (root.left != null) visit(list, curList.stream().collect(Collectors.toList()), root.left, sum - root.val);
        if (root.right != null) visit(list, curList.stream().collect(Collectors.toList()), root.right, sum - root.val);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new LinkedList<>();
        visit(list, new ArrayList<>(), root, sum);
        return list;
    }
}
```

Discuss中给出了一个更简洁的方法,代码如下:

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
        } else {
            visit(list, curList, root.left, sum - root.val);
            visit(list, curList, root.right, sum - root.val);
        }
        curList.remove(curList.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new LinkedList<>();
        visit(list, new ArrayList<>(), root, sum);
        return list;
    }
}
```

注意到visit函数中出现的几次curList.remove(curList.size() - 1)的意义:
因为visit函数本质上还是深搜,所以一定会有回溯的阶段.

第一个 curList.remove(curList.size() - 1) 是将当前节点加入当前路径.

与之对应的,最后一个 curList.remove(curList.size() - 1) 则是在回溯到该节点的父节点之前将当前节点
移除当前路径.

中间的 curList.remove(curList.size() - 1) 与最后一个相同,如果visit函数改写成如下的形式,
便更加容易理解:

```Java
void visit(List<List<Integer>> list, List<Integer> curList, TreeNode root, int sum) {
    if (root == null) return;
    curList.add(root.val);
    if (root.val == sum && root.left == null && root.right == null) {
        list.add(curList.stream().collect(Collectors.toList()));
        curList.remove(curList.size() - 1);
        return;
    } else {
        visit(list, curList, root.left, sum - root.val);
        visit(list, curList, root.right, sum - root.val);
        curList.remove(curList.size() - 1);
    }
}
```

同样,也等价于下面这种形式:

```Java
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
```

本题实质上考察的还是对二叉树深度优先搜索及回溯的理解,对深搜的理解到位了,就明白
为什么要在这个时刻添加/删除一个元素.对于回溯的理解:深搜实际上是从上到下对树遍历一边,
而回溯则是从下往上对树遍历一边.
