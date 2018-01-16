package BinaryTreeInorderTraversal;

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
        x = val;
    }
}

public class Solution {
    private void visit(TreeNode root, List<Integer> list) {
        if (root == null) return;
        visit(root.left, list);
        list.add(root.val);
        visit(root.right, list);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        visit(root, res);
        return res;
    }
}
