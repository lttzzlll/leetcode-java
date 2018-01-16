package BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liutaotao on 2018/1/16.
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
    private void vist(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        vist(root.left, list);
        vist(root.right, list);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        vist(root, res);
        return res;
    }

    public static void main(String[] args) {

    }
}
