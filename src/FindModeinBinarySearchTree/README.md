### [Find Mode in Binary Search Tree](https://leetcode.com/problems/find-mode-in-binary-search-tree/description/)

在这道题中,中序遍历一棵有序二叉树求出现次数最多的元素并将其更新在一个集合中其实和在一个有序序列中遍历求出现次数最多的元素并不断更新在一个集合中本质上是一样的,都需要维护一个集合,用来收集出现次数最多的元素,不同点就是遍历的集合变了,一个是线性序列,另一个是非线性序列,因此遍历的方式不一样,但除此之外,其他的东西都一样.
也就是说,当要遍历的集合再次改变的时候,只需要对应修改遍历该集合的方式即可,其他的思路都一样.

```Java

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    Integer preVal = null;
    int count = 1;
    int maxCount = 0;

    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traverse(root.left, list);
        if (preVal != null) {
            if (root.val == preVal) {
                count++;
            } else {
                count = 1;
            }
        }
        if (count > maxCount) {
            maxCount = count;
            list.clear();
            list.add(root.val);
        } else if (count == maxCount) {
            list.add(root.val);
        }
        preVal = root.val;
        traverse(root.right, list);
    }

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

```

此处,将二叉树变成一个线性表,比如数组,其思路也是一样的,改变的只是遍历集合的方式,代码如下:
```Java
public class Solution{
    private void tranverse(int[] nums, List<Integer> list) {
        Integer preVal = null;
        int count = 1;
        int maxCount = 0;
        for (int i : nums) {
            if (preVal != null) {
                if (i == preVal) {
                    count++;
                } else {
                    count = 1;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                list.clear();
                list.add(i);
            } else if (count == maxCount) {
                list.add(i);
            }
            preVal = i;
        }
    }

    public int[] findMode(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        List<Integer> list = new ArrayList<>();
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
```

如果每道题都可以举一反三,才可以说理解了这道题真正在考察什么,单纯的刷一两个题没多大意义. 关于数据结构,每次学习一个新的数据结构,都会先学习其特点,然后学习遍历该数据结果的方式,虽然很有用,但是当时却没有明白到底是什么意思.

#### Tips
将 List<T> 转换为 T[] 的时候使用了 Java8 中的函数式表达式. 虽然还是很笨,但Java终于可以"在一行内把事情搞定了".
