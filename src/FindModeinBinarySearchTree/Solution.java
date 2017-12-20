package FindModeinBinarySearchTree;

/**
 * Created by liutaotao on 2017/12/17.
 */

import java.util.HashMap;
import java.util.LinkedList;
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
    private int count(TreeNode root, int val) {
        if (root == null) return 0;
        if (root.val < val) {
            return count(root.right, val);
        } else if (root.val > val) {
            return count(root.left, val);
        } else {
            return 1 + count(root.left, val) + count(root.right, val);
        }
    }

    // 这道题应该是一边遍历节点,一边计算,而不是分开,分开就没有同步的过程了.
    public int[] findMode(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>();

    }

    public static void main(String[] args) {

    }
}
